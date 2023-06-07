import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exceções.limiteSuperado {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<ClientePrata> pratas = new ArrayList<ClientePrata>();
        ArrayList<ClienteOuro> ouros = new ArrayList<ClienteOuro>();
        ArrayList<ClientePlatina> platinas = new ArrayList<ClientePlatina>();
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
                BigInteger cpf = BigInteger.valueOf(0);
                boolean login = false;
                boolean acharConta = false;
                do {
                    System.out.println("Digite o seu cpf");
                    try {
                        cpf = s.nextBigInteger();
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
                            for (Cliente ouro: ouros){
                                if (ouro.getCpf()==cpf){
                                    System.out.println("Digite 5 para pagar o seu cartao de credito");
                                }
                            }
                            System.out.println("Digite 6 para trocar a senha");
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
                                    System.out.println("Qual o valor da compra?");

                                    try {

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}