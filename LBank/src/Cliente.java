import java.math.BigInteger;

public abstract class Cliente extends Pessoa {
    private float saldo;
    private long senha;
    private float limiteDeSaque;


    public Cliente(String nome, String sobreNome, long cpf, float saldo, long senha) {
        super(nome, sobreNome, cpf);
        this.saldo = saldo;
        this.senha = senha;
        this.limiteDeSaque = saldo*0.25f;
    }


    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    public float getLimiteDeSaque() {
        return limiteDeSaque;
    }

    public void setLimiteDeSaque(float limiteDeSaque) {
        this.limiteDeSaque = limiteDeSaque;
    }

    public String trocarSenha(long s) throws Exceções.senhaInaceita {
        if (String.valueOf(s).length() != 6){
            throw new Exceções.senhaInaceita("A senha necessita ter exatemente 6 caracteres");
        }else {
            this.setSenha(s);
            return "Senha alterada com sucesso";
        }
    }

    public String fazerDeposito(float d) throws Exceções.depositoVazio {
        if (d == 0) {
            throw new Exceções.depositoVazio("O seu deposito esta vazio");
        } else {
            this.setSaldo(this.getSaldo() + d);
            return "Deposito feito com sucesso seu novo saldo é: " + this.getSaldo() + "R$";
        }
    }

    public String fazerSaque(float s) throws Exceções.limiteSuperado {
        this.setLimiteDeSaque(this.getSaldo()*0.25f);
        if(s>this.getLimiteDeSaque()) {
            throw new Exceções.limiteSuperado("O limite de saque foi superado");
        }else if(s>this.getSaldo()){
            throw new Exceções.limiteSuperado("O valor do saque ultrapassa o valor do saldo");
        }else {
            this.setSaldo(this.getSaldo()-s);
            return "Saque feito com sucesso seu novo saldo é: " + this.getSaldo() + " R$";
        }
    }

    public String CompraCartao(float s) throws Exceções.limiteSuperado {
        if(s>this.getSaldo()){
            throw new Exceções.limiteSuperado("O valor da compra ultrapassa o valor do saldo");
        }else {
            this.setSaldo(this.getSaldo()-s);
            return "Compra feita com sucesso, seu novo saldo é: " + this.getSaldo() + " R$";
        }
    }

}
