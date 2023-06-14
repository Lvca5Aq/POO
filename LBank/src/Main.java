import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exceções.limiteSuperado {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<ClientePrata> pratas = new ArrayList<ClientePrata>();
        ArrayList<ClienteOuro> ouros = new ArrayList<ClienteOuro>();
        ArrayList<ClientePlatina> platinas = new ArrayList<ClientePlatina>();
        Funcionario Lucas = new Funcionario("Lucas","Aquino",626594,2207,58227);
        Map <String, Stock> listInvestimetos = new TreeMap<String, Stock>();
        Stock PETR4 = new Stock(86885,40,2);
        Stock ABEV3 = new Stock(66685,25,3);
        Stock CMIG4 = new Stock(67775,5,10);
        listInvestimetos.put("86885",PETR4);
        listInvestimetos.put("66685",ABEV3);
        listInvestimetos.put("67775",CMIG4);
        Scanner s = new Scanner(System.in);
        int op = 0;
        int opl=0;
        do {
            System.out.println("Digite 1 para fazer o login");
            System.out.println("Digite 2 para fazer o cadastro");
            System.out.println("Digite 3 para logar como funcionario");
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
                                        concluido=true;
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
                                                concluido = true;
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
                                        Stock I = null;
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
                                        Stock I = null;
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
                float saldo=0;
                boolean repetido=false;
                boolean concluido = false;
                do {
                    long cpfC = 0;
                    System.out.println("Vamos fazer seu cadastro. Me informe o seu CPF (apenas 6 dígitos):");
                    try {
                        s.nextLine(); // Descartar quebra de linha pendente ou entrada inválida
                        cpfC = s.nextLong();
                        System.out.println(cpfC);
                    } catch (InputMismatchException e) {
                        System.out.println("Você digitou uma letra onde deveria digitar um número. Por favor, insira um número.");
                        s.nextLine(); // Descartar entrada inválida
                    }
                    for (Cliente cliente : clientes) {
                        if (cpfC == cliente.getCpf()) {
                            System.out.println("Seu CPF já está cadastrado.");
                            repetido = true;
                            concluido = true;
                            break;
                        }
                    }

                    if (!repetido) {
                        System.out.println("CPF aceito");
                        System.out.println("Agora me diga qual será o depósito inicial:");
                        try {
                            s.nextLine();
                            saldo = s.nextFloat();
                        } catch (InputMismatchException e) {
                            System.out.println("Você digitou uma letra onde deveria digitar um número. Por favor, insira um número.");
                        }
                        if (saldo <= 5000) {
                            String nome = "";
                            String sobrenome = "";
                            long senha = 0;
                            try {
                                System.out.println("Agora me diga o seu primeiro nome:");
                                s.nextLine();
                                nome = s.nextLine();
                                System.out.println("Agora me diga o seu segundo nome:");
                                sobrenome = s.nextLine();
                                System.out.println("Agora me diga a sua senha:");
                                senha = s.nextLong();
                                ClientePrata prata = new ClientePrata(nome, sobrenome, cpfC, saldo, senha);
                                clientes.add(prata);
                                pratas.add(prata);
                                concluido = true;
                                System.out.println("Parabéns! Você foi selecionado para o nosso cliente prata. As informações da sua conta são: " + prata);
                            } catch (InputMismatchException e) {
                                System.out.println("Você digitou o tipo de informação errada.");
                            }
                        } else if (saldo < 10000 && saldo > 5000) {
                            String nome = "";
                            String sobrenome = "";
                            long senha = 0;
                            try {
                                System.out.println("Agora me diga o seu primeiro nome:");
                                s.nextLine();
                                nome = s.nextLine();
                                System.out.println("Agora me diga o seu segundo nome:");
                                sobrenome = s.nextLine();
                                System.out.println("Agora me diga a sua senha:");
                                senha = s.nextLong();
                                ClienteOuro ouro = new ClienteOuro(nome, sobrenome, cpfC, saldo, senha);
                                clientes.add(ouro);
                                ouros.add(ouro);
                                concluido = true;
                                System.out.println("Parabéns! Você foi selecionado para o nosso cliente ouro. As informações da sua conta são: " + ouro);
                            } catch (InputMismatchException e) {
                                System.out.println("Você digitou o tipo de informação errada.");
                            }
                        } else if (saldo >= 10000) {
                            String nome = "";
                            String sobrenome = "";
                            long senha = 0;
                            try {
                                System.out.println("Agora me diga o seu primeiro nome:");
                                s.nextLine();
                                nome = s.nextLine();
                                System.out.println("Agora me diga o seu segundo nome:");
                                sobrenome = s.nextLine();
                                System.out.println("Agora me diga a sua senha:");
                                senha = s.nextLong();
                                ClientePlatina platina = new ClientePlatina(nome, sobrenome, cpfC, saldo, senha);
                                clientes.add(platina);
                                platinas.add(platina);
                                concluido = true;
                                System.out.println("Parabéns! Você foi selecionado para o nosso cliente platina. As informações da sua conta são: " + platina);
                            } catch (InputMismatchException e) {
                                System.out.println("Você digitou o tipo de informação errada.");
                            }
                        }
                    }
                } while (!concluido);
            } else if (op == 3) {
                boolean loginF = false;
                do {
                    long matricula = 0;
                    long senha = 0;
                    System.out.println("Bem vindo para efetuar seu login preciso da sua matricula");
                    try {
                        s.nextLine();
                        matricula = s.nextLong();
                    }catch (InputMismatchException e){
                        System.out.println("Você digitou o tipo de informação errada.");
                    }
                    if (matricula != Lucas.getMatricula()){
                        System.out.println("Matricula errada tente novamente");
                    } else {
                        System.out.println("Agora digite a senha");
                        s.nextLine();
                        try {
                            senha = s.nextLong();
                        }catch (InputMismatchException e){
                            System.out.println("Você digitou o tipo de informação errada.");
                        }
                        if (senha != Lucas.getSenha()){
                            System.out.println("senha errada tente novamente");
                        }else {
                            loginF = true;
                        }
                    }
                } while(!loginF);
                if (loginF){
                    int opf = 0;
                    do {
                        System.out.println("bem vindo a plataforma do funcionario, aqui voce pode adicionar novos investimentos");
                        System.out.println("Digite 1 para adicionar um novo investimento");
                        System.out.println("Digite 9 para sair");
                        try {
                            s.nextLine();
                            opf = s.nextInt();
                        }catch (InputMismatchException e){
                            System.out.println("Você digitou o tipo de informação errada.");
                        }
                        if (opf == 1){
                            boolean concluido = false;
                            do {
                                int cod = 0;
                                int probReturn = 0;
                                int multiplicador = 0;
                                System.out.println("Para adicionar um novo investimento primeiro me passe o codigo dele(5 digitos)");
                                try {
                                    s.nextLine();
                                    cod = s.nextInt();
                                    System.out.println("Agora a probabilidade de retorno dele");
                                    probReturn = s.nextInt();
                                    System.out.println("Por fim o multiplicador");
                                    multiplicador = s.nextInt();
                                    Stock novoInvestimento = new Stock(cod,probReturn,multiplicador);
                                    listInvestimetos.put(String.valueOf(cod),novoInvestimento);
                                    concluido = true;
                                }catch(InputMismatchException e){
                                    System.out.println("Você digitou o tipo de informação errada.");
                                }
                            }while (!concluido);
                        }
                    }while (opf!=9);
                }
            }
        }while (op!=9);
        System.out.println("Obrigado por usar o nosso banco");
    }
}