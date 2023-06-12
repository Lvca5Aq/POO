import java.math.BigInteger;

public class ClienteOuro extends Cliente implements Investir {
    public float taxa;
    private float credito;
    private float divida;


    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

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

    public ClienteOuro(String nome, String sobreNome, long cpf, float saldo, long senha) {
        super(nome, sobreNome, cpf, saldo, senha);
        this.taxa = 0.025f;
        this.credito = saldo * 4f;
        this.divida = 0;
    }

    @Override
    public String fazerSaque(float s) throws Exceções.limiteSuperado {
        float T = s * this.getTaxa();
        this.setLimiteDeSaque(this.getSaldo() * 0.25f);
        if (s > this.getLimiteDeSaque()) {
            throw new Exceções.limiteSuperado("O limite de saque foi superado");
        } else if (s > this.getSaldo() + T) {
            throw new Exceções.limiteSuperado("O valor do saque ultrapassa o valor do saldo mas a taxa");
        } else {
            this.setSaldo(s + T - this.getSaldo());
            return "Saque feito com sucesso seu novo saldo é: " + this.getSaldo() + " R$";
        }
    }

    @Override
    public String CompraCartao(float s) throws Exceções.limiteSuperado {
        float T = s * this.getTaxa();
        if (s + T > this.getSaldo() + this.getCredito()) {
            throw new Exceções.limiteSuperado("O valor da compra ultrapassa o valor do saldo");
        } else if (s + T < this.getSaldo()) {
            this.setSaldo(s + T - this.getSaldo());
            return "Compra feita com sucesso seu novo saldo é: " + this.getSaldo() + " R$";
        } else {
            this.setDivida(-1 * (this.getSaldo() - (s + T)));
            this.setCredito(this.getCredito() - (s - this.getSaldo()));
            this.setSaldo(0);
            return "Compra feita com cartao de credito seu novo saldo é: " + this.getSaldo() + " R$ e uma divida de " + this.getDivida() + " R$";
        }
    }

    public String pagaCartao(float v) throws Exceções.valorSuperior, Exceções.limiteSuperado {
        if (v > this.getDivida()) {
            throw new Exceções.valorSuperior("O valor que voce esta querendo pagar excede o valor da divida, que é de " + this.getDivida() + " R$");
        } else if (v > this.getSaldo()) {
            throw new Exceções.limiteSuperado("O valor que voce esta querendo pagar excede o saldo, que é de " + this.getSaldo() + " R$");
        } else {
            this.setDivida(this.getDivida() - v);
            this.setCredito(this.getCredito() + v);
            this.setSaldo(this.getSaldo() - v);
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
}
