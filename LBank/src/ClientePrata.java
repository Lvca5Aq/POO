import java.math.BigInteger;

public class ClientePrata extends Cliente{
    public float taxa;

    public ClientePrata(String nome, String sobreNome, long cpf, float saldo, long senha) {
        super(nome, sobreNome, cpf, saldo, senha);
        this.taxa = 0.05f;

    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    @Override
    public String toString() {
        return "ClientePrata{" +
                "taxa=" + taxa +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                '}';
    }

    @Override
    public String fazerSaque(float s) throws Exceções.limiteSuperado {
        float T = s*this.getTaxa();
        this.setLimiteDeSaque(this.getSaldo()*0.25f);
        if(s>this.getLimiteDeSaque()) {
            throw new Exceções.limiteSuperado("O limite de saque foi superado");
        }else if(s+T>this.getSaldo()){
            throw new Exceções.limiteSuperado("O valor do saque ultrapassa o valor do saldo mas a taxa");
        }else {
            this.setSaldo(s+T-this.getSaldo());
            return "Saque feito com sucesso seu novo saldo é: " + this.getSaldo() + " R$";
        }
    }
    @Override
    public String CompraCartao(float s) throws Exceções.limiteSuperado {
        float T = s*this.getTaxa();
        if(s+T>this.getSaldo()){
            throw new Exceções.limiteSuperado("O valor da compra ultrapassa o valor do saldo");
        }else {
            this.setSaldo(this.getSaldo()-s+T);
            return "Compra feita com sucesso, seu novo saldo é: " + this.getSaldo() + " R$";
        }
    }
}
