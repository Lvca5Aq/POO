import java.math.BigInteger;

public class ClientePlatina extends Cliente{
    private float credito;
    private float divida;
    private float milhas;


    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }

    public float getDivida() {
        return divida;
    }

    public void setDivida(float divida) {
        this.divida = divida;
    }

    public float getMilhas() {
        return milhas;
    }

    public void setMilhas(float milhas) {
        this.milhas = milhas;
    }

    public ClientePlatina(String nome, String sobreNome, BigInteger cpf, float saldo, long senha) {
        super(nome, sobreNome, cpf, saldo, senha);
        this.credito = 6f*saldo;
        this.divida = 0f;
        this.milhas = 0f;
    }
    @Override
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

    @Override
    public String CompraCartao(float s) throws Exceções.limiteSuperado {
        if(s>this.getSaldo()+this.getCredito()){
            throw new Exceções.limiteSuperado("O valor da compra ultrapassa o valor do credito e do saldo juntos");
        }else if(s<this.getSaldo()){
            this.setSaldo(this.getSaldo()-s);
            this.setMilhas(0.1f*s);
            return "Compra feita com sucesso seu novo saldo é: " + this.getSaldo() + " R$";
        } else {
            this.setDivida(s-this.getSaldo());
            this.setSaldo(0);
            return "Compra feita com cartao de credito seu novo saldo é: " + this.getSaldo() + " R$ e uma divida de " + this.getDivida() + " R$";
        }
    }

    public String pagaCartao(float v) throws Exceções.valorSuperior, Exceções.limiteSuperado {
        if (v>this.getDivida()){
            throw  new Exceções.valorSuperior("O valor que voce esta querendo pagar excede o valor da divida, que é de "+ this.getDivida()+ " R$");
        } else if (v>this.getSaldo()) {
            throw  new Exceções.limiteSuperado("O valor que voce esta querendo pagar excede o saldo, que é de "+ this.getSaldo()+" R$");
        } else {
            this.setDivida(this.getDivida()-v);
            this.setCredito(this.getCredito()+v);
            this.setSaldo(this.getSaldo()-v);
            return "Valor pago com sucesso";
        }
    }



}
