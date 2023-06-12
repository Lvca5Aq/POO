import java.math.BigInteger;

public class ClientePlatina extends Cliente implements Investir{
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

    public ClientePlatina(String nome, String sobreNome, long cpf, float saldo, long senha) {
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
            this.setMilhas(Math.round(0.10f*s));
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

    @Override
    public String fazerInvestimento(float v, Stock a) throws Exceções.limiteSuperado {
        double sorte;
        if (v > this.getSaldo()) {
            throw new Exceções.limiteSuperado("O valor que voce esta querendo investir excede o saldo, que é de " + this.getSaldo() + " R$");
        }
        this.setSaldo(this.getSaldo() - v);
        sorte = Math.round(Math.random() * 100);
        if (sorte <= a.getProbReturn()) {
            this.setSaldo(this.getSaldo() + (v * a.getMultiplicador()));
            return "Parabens seu investimento foi um sucesso o valor investido foi multiplicado por" + a.getMultiplicador() + ". Seu novo saldo é de:" + this.getSaldo() + "R$";
        } else {
            return "Infelizmente seu investimento falhou";
        }
    }

    public String converterMilhas(int v) throws Exceções.limiteSuperado {
        if (v>this.getMilhas()){
            throw new Exceções.limiteSuperado("O valor que voce esta querendo converter excede o saldo de milhas, que é de " + this.getMilhas());
        }else {
            this.setSaldo(this.getSaldo()+v);
            this.setMilhas(this.getMilhas()-v);
            return "Valor convertido com sucesso.";
        }
    }

    @Override
    public String toString() {
        return "ClientePlatina{" +
                "credito=" + credito +
                ", divida=" + divida +
                ", milhas=" + milhas +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                '}';
    }
}
