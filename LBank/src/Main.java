import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exceções.limiteSuperado {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<ClientePrata> pratas = new ArrayList<ClientePrata>();
        ArrayList<ClienteOuro> ouros = new ArrayList<ClienteOuro>();
        ArrayList<ClientePlatina> platinas = new ArrayList<ClientePlatina>();
        Map <String, Stock> listInvestimetos = new TreeMap<String, Stock>();
        ClientePlatina lucas = new ClientePlatina("lucas","aquino", 626594,10000f,5822727);
        Scanner s = new Scanner(System.in);
        int op = 0;
        int opl=0;
        do {
            System.out.println("Digite 1 para fazer o login");
            System.out.println("Digite 2 para fazer o cadastro");
            System.out.println("Digite 9 para sair");
            try {
                op = s.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
            }
            if (op == 1){
                float cpf = 0;
                boolean login = false;
                boolean acharConta = false;
                do {
                    System.out.println("Digite o seu cpf");
                    try {
                        cpf = s.nextFloat();
                    }catch (InputMismatchException e){
                        System.out.println("Você digitou seu cpf incorretamente");
                    }
                    for (Cliente client:clientes){
                        if(client.getCpf()!=cpf){
                            System.out.println("Nao encontramos o seu Cpf no sistema");
                        }else {
                            acharConta=true;
                            long senha=0;
                            do {
                                System.out.println("Digite sua senha");
                                senha = s.nextLong();
                                if(client.getSenha()==senha){
                                    System.out.println("Login feito com sucesso");
                                    login=true;
                                } else {
                                    System.out.println("Senha incorreta");
                                }
                            }while (!login);
                        }
                    }
                }while (!acharConta);
                for (Cliente client: clientes){
                    if (client.getCpf()==cpf) {
                        System.out.println("Bem vindo/a sr/sra " + client.getNome() + "O que deseja fazer");
                        do {
                            System.out.println("Digite 1 para ver o saldo");
                            System.out.println("Digite 2 para fazer um deposito");
                            System.out.println("Digite 3 para fazer um saque");
                            System.out.println("Digite 4 para fazer uma compra no cartao");
                            for (ClienteOuro ouro: ouros){
                                if (ouro.getCpf()==cpf){
                                    System.out.println("Digite 5 para pagar o seu cartao de credito");
                                }
                            }
                            for (ClientePlatina platina: platinas){
                                if (platina.getCpf()==cpf){
                                    System.out.println("Digite 5 para pagar o seu cartao de credito");
                                }
                            }
                            System.out.println("Digite 6 para trocar a senha");
                            for (ClientePlatina platina: platinas){
                                if (platina.getCpf()==cpf){
                                    System.out.println("Digite 7 para converter as suas milhas em dinheiro");
                                }
                            }
                            for (ClienteOuro ouro: ouros){
                                if (ouro.getCpf()==cpf){
                                    System.out.println("Digite 8 para pagar fazer investimento");
                                }
                            }
                            for (ClientePlatina platina: platinas){
                                if (platina.getCpf()==cpf){
                                    System.out.println("Digite 8 para pagar fazer investimento");
                                }
                            }
                            System.out.println("Digite 9 para sair da conta");
                            try {
                                opl = s.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                            }
                            if (opl==1){
                                System.out.println("O seu saldo atualmente é de:" + client.getSaldo() + " R$");
                            } else if (opl == 2){
                                boolean concluido = false;
                                do {
                                    float valorD = 0;
                                    System.out.println("Quanto voce deseja depositar?");
                                    try {
                                        valorD = s.nextFloat();
                                        System.out.println(client.fazerDeposito(valorD));
                                        concluido = true;
                                    }catch (InputMismatchException e){
                                        System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                    } catch (Exceções.depositoVazio e) {
                                        System.out.println(e.getMsg());
                                    }
                                }while (!concluido);
                            } else if(opl==3){
                                boolean concluido = false;
                                do {
                                    float valorS;
                                    System.out.println("Quanto voce quer sacar?");
                                    try{
                                        valorS = s.nextFloat();
                                        System.out.println(client.fazerSaque(valorS));
                                        concluido = true;
                                    }catch (InputMismatchException e){
                                        System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                    }catch (Exceções.limiteSuperado e){
                                        System.out.println(e.getMsg());
                                    }
                                }while (!concluido);
                            } else if (opl == 4) {
                                boolean concluido = false;
                                do {
                                    float valorC;
                                    System.out.println("Qual o valor da compra?");
                                    try {
                                        valorC = s.nextFloat();
                                        System.out.println(client.CompraCartao(valorC));
                                    } catch (InputMismatchException e) {
                                        System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                    } catch (Exceções.limiteSuperado e) {
                                        System.out.println(e.getMsg());
                                    }
                                } while (!concluido);
                            } else if (opl == 5){
                                boolean encontrado = false;
                                for (ClienteOuro ouro: ouros){
                                    if (ouro.getCpf()==cpf){
                                        encontrado = true;
                                        boolean concluido = false;
                                        float valorD;
                                        do {
                                            System.out.println("Atualmente sua divida de cartao de credito é de: " + ouro.getDivida() + " R$");
                                            System.out.println("Quanto voce deseja pagar da divida?");
                                            try {
                                                valorD = s.nextFloat();
                                                System.out.println(ouro.pagaCartao(valorD));
                                                concluido = true;
                                            } catch (Exceções.valorSuperior e) {
                                                System.out.println(e.getMsg());
                                            } catch (Exceções.limiteSuperado e){
                                                System.out.println(e.getMsg());
                                            } catch (InputMismatchException e){
                                                System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                            }
                                        } while (!concluido);
                                    }
                                }
                                for (ClientePlatina platina: platinas){
                                    if (platina.getCpf()==cpf){
                                        encontrado = true;
                                        boolean concluido = false;
                                        float valorD;
                                        do {
                                            System.out.println("Atualmente sua divida de cartao de credito é de: " + platina.getDivida() + " R$");
                                            System.out.println("Quanto voce deseja pagar da divida?");
                                            try {
                                                valorD = s.nextFloat();
                                                System.out.println(platina.pagaCartao(valorD));
                                                concluido = true;
                                            } catch (Exceções.valorSuperior e) {
                                                System.out.println(e.getMsg());
                                            } catch (Exceções.limiteSuperado e){
                                                System.out.println(e.getMsg());
                                            } catch (InputMismatchException e){
                                                System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                            }
                                        } while (!concluido);
                                    }
                                }
                                if (!encontrado){
                                    System.out.println("A opçao 5 nao esta disponivel para voce, voltando para o menu inicial");
                                }
                            } else if (opl==6){
                                boolean concluido = false;
                                do {
                                    System.out.println("Qual a nova senha?(6 numeros)");
                                    long novaSenha;
                                    try {
                                        novaSenha = s.nextLong();
                                        client.trocarSenha(novaSenha);
                                        concluido = true;
                                    } catch (Exceções.senhaInaceita e) {
                                        System.out.println(e.getMsg());
                                    }catch (InputMismatchException e){
                                        System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                    }
                                }while (!concluido);
                            } else if(opl==7){
                                boolean encontrado = false;
                                for (ClientePlatina platina: platinas){
                                    if (platina.getCpf()==cpf){
                                        encontrado = true;
                                        boolean concluido=false;
                                        int valorM;
                                        do {
                                            System.out.println("Quantas milhas voce quer converter? Lembrando que voce tem atualmente"+platina.getMilhas());
                                            try {
                                                valorM = s.nextInt();
                                                System.out.println(platina.converterMilhas(valorM));
                                            }catch (InputMismatchException e){
                                                System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                            } catch (Exceções.limiteSuperado e){
                                                System.out.println(e.getMsg());
                                            }
                                        }while (!concluido);
                                    }
                                }
                                if (!encontrado){
                                    System.out.println("A opçao 7 nao esta disponivel para voce, voltando para o menu inicial");
                                }
                            } else if (opl==8){
                                boolean encontrado = false;
                                boolean concluido = false;
                                for (ClienteOuro ouro: ouros){
                                    if (ouro.getCpf()==cpf){
                                        encontrado = true;
                                        int codI;
                                        Stock I = new Stock();
                                        float valor;
                                        do {
                                            System.out.println("Aqui esta a nossa lista de investimentos que temos disponiveis:");
                                            Collection<Stock> stocks = listInvestimetos.values();
                                            for (Stock i: stocks){
                                                System.out.println(i);
                                            }
                                            System.out.println("Qual o codigo da açao que voce quer investir?");
                                            try {
                                                codI = s.nextInt();
                                                for (Stock i:stocks){
                                                    if(codI==i.getCod()){
                                                        I = i;
                                                    }
                                                }
                                            }catch (InputMismatchException e){
                                                System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                            }
                                            System.out.println("Quanto voce deseja investir");
                                            try {
                                                valor = s.nextFloat();
                                                System.out.println(ouro.fazerInvestimento(valor,I));
                                                concluido = true;
                                            }catch (InputMismatchException e){
                                                System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                            }catch (Exceções.limiteSuperado e){
                                                System.out.println(e.getMsg());
                                            }
                                        }while (!concluido);
                                    }
                                }
                                for (ClientePlatina platina: platinas){
                                    if (platina.getCpf()==cpf){
                                        encontrado = true;
                                        int codI;
                                        Stock I = new Stock();
                                        float valor;
                                        do {
                                            System.out.println("Aqui esta a nossa lista de investimentos que temos disponiveis:");
                                            Collection<Stock> stocks = listInvestimetos.values();
                                            for (Stock i: stocks){
                                                System.out.println(i);
                                            }
                                            System.out.println("Qual o codigo da açao que voce quer investir?");
                                            try {
                                                codI = s.nextInt();
                                                for (Stock i:stocks){
                                                    if(codI==i.getCod()){
                                                        I = i;
                                                    }
                                                }
                                            }catch (InputMismatchException e){
                                                System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                            }
                                            System.out.println("Quanto voce deseja investir");
                                            try {
                                                valor = s.nextFloat();
                                                System.out.println(platina.fazerInvestimento(valor,I));
                                                concluido = true;
                                            }catch (InputMismatchException e){
                                                System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                                            }catch (Exceções.limiteSuperado e){
                                                System.out.println(e.getMsg());
                                            }
                                        }while (!concluido);
                                    }
                                }
                                if (!encontrado){
                                    System.out.println("Esta opçao nao esta disponivel pra voce por enquanto");
                                }
                            }
                        }while (opl!= 9);
                    }
                }
            }else if(op==2){
                long cpfC=0;
                float saldo=0;
                boolean repetido=true;
                boolean concluido = false;
                do {
                    System.out.println("Vamos fazer seu cadastro. Me informe o seu cpf(apenas 6 digitos)");
                    try {
                        cpfC = s.nextLong();
                    }catch(InputMismatchException e){
                        System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                    }
                    for (Cliente cliente:clientes){
                        if (cpfC!= cliente.getCpf()){
                            do {
                            System.out.println("Cpf aceito");
                            repetido=false;
                            System.out.println("Agora me diga qual sera o deposito inicial");
                            try {
                                saldo=s.nextFloat();
                            }catch (InputMismatchException e){
                                System.out.println("Você digitou uma letra onde deveria digitar um numero. Por favor insira um numero");
                            }
                            if (saldo<5000){
                                    String nome = new String();
                                    String sobrenome = new String();
                                    long senha = 0;
                                    try {
                                        System.out.println("Agora me diga o seu primeiro nome");
                                        nome = s.nextLine();
                                        System.out.println("Agora me diga o seu segundo nome");
                                        sobrenome = s.nextLine();
                                        System.out.println("Agora me diga a sua senha");
                                        senha = s.nextLong();
                                        ClientePrata prata = new ClientePrata(nome,sobrenome,cpfC,saldo,senha);
                                        clientes.add(prata);
                                        pratas.add(prata);
                                        concluido=true;
                                        System.out.println("Parabens voce foi selecionado para o nosso cliente prata as informaçoes da sua conta sao:" + prata);
                                    }catch (InputMismatchException e){
                                        System.out.println("Você digitou o tipo de informação errada.");
                                    }
                            } else if (saldo<10000&&saldo>5000) {
                                    String nome = new String();
                                    String sobrenome = new String();
                                    long senha = 0;
                                    try {
                                        System.out.println("Agora me diga o seu primeiro nome");
                                        nome = s.nextLine();
                                        System.out.println("Agora me diga o seu segundo nome");
                                        sobrenome = s.nextLine();
                                        System.out.println("Agora me diga a sua senha");
                                        senha = s.nextLong();
                                        ClienteOuro ouro = new ClienteOuro(nome,sobrenome,cpfC,saldo,senha);
                                        clientes.add(ouro);
                                        ouros.add(ouro);
                                        concluido=true;
                                        System.out.println("Parabens voce foi selecionado para o nosso cliente ouro as informaçoes da sua conta sao:" + ouro);
                                    }catch (InputMismatchException e){
                                        System.out.println("Você digitou o tipo de informação errada.");
                                    }
                            } else if (saldo>10000){
                                    String nome = new String();
                                    String sobrenome = new String();
                                    long senha = 0;
                                    try {
                                        System.out.println("Agora me diga o seu primeiro nome");
                                        nome = s.nextLine();
                                        System.out.println("Agora me diga o seu segundo nome");
                                        sobrenome = s.nextLine();
                                        System.out.println("Agora me diga a sua senha");
                                        senha = s.nextLong();
                                        ClientePlatina platina = new ClientePlatina(nome,sobrenome,cpfC,saldo,senha);
                                        clientes.add(platina);
                                        platinas.add(platina);
                                        concluido=true;
                                        System.out.println("Parabens voce foi selecionado para o nosso cliente platina as informaçoes da sua conta sao:" + platina);
                                    }catch (InputMismatchException e){
                                        System.out.println("Você digitou o tipo de informação errada.");
                                    }
                                }
                            }while (!concluido);
                        }else {
                            System.out.println("seu cpf ja esta cadastrado");
                        }
                    }
                }while (repetido);
            }
        }while (op!=9);
        System.out.println("Obrigado por usar o nosso banco");
    }
}