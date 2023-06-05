public class Conta {
    private Cliente dono;
    private float saldo;

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        if(saldo<0){
            this.saldo = 0;
        }else{
            this.saldo = saldo;
        }
    }


    @Override
    public String toString() {
        return "Conta{" +
                "dono=" + dono +
                ", saldo=" + saldo +
                '}';
    }

    public Conta(Cliente dono, float saldo) {
        this.dono = dono;
        this.saldo = saldo;
    }

    public void fazOperaçao(Operaçao x){
        if (x.getTipo()=="D"||x.getTipo()=="d"){
            this.setSaldo(this.getSaldo()+x.getValor());
        } else if (x.getTipo()=="R"||x.getTipo()=="r"){
            this.setSaldo(this.getSaldo()-x.getValor());
        }
    }


}
