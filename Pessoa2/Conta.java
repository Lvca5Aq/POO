public class Conta {
    private long cpf;
    public int num;
    private double saldo;
    public double bonificaçao;
    public boolean tipo;

    public void calBonificaçao() {
        if(getTipo()){
            setBonificaçao(10*getSaldo()/100);
        } else {
            setBonificaçao(5*getSaldo()/100);
        }
        
    }

    public void saque(double v) {
        setSaldo(getSaldo()-v);
    }

    public void deposito(double v) {
        setSaldo(getSaldo()+v);
    }

    public void traferencia(Conta outra, double v) {
        this.saque(v);
        outra.deposito(v);
    }

    public void status() {
       System.out.println(this.getCpf());
       System.out.println(this.getNum());
       System.out.println(this.getSaldo());
       System.out.println(this.getBonificaçao());
    }
    public long getCpf() {
        return this.cpf;
    }


    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getBonificaçao() {
        return this.bonificaçao;
    }

    public void setBonificaçao(double bonificaçao) {
        this.bonificaçao = bonificaçao;
    }
   
    public boolean getTipo() {
        return this.tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }
}
