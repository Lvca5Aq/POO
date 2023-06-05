public class Conta implements Segurança{
    private long cpf;
    private int senhaDaConta;
    private float saldo;

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getSenhaDaConta() {
        return senhaDaConta;
    }

    public void setSenhaDaConta(int senhaDaConta) {
        this.senhaDaConta = senhaDaConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void sacar(float valor, int senha){
        if (verificaSenha(senha)==true){
            this.setSaldo(this.getSaldo()-valor);
            mensagemSucesso();
        } else {
            mensagemFracassso();
        }
    }

    public void depositar(float valor, int senha){
        if (verificaSenha(senha)==true){
            this.setSaldo(this.getSaldo()+valor);
            mensagemSucesso();
        } else {
            mensagemFracassso();
        }
    }

    public boolean verificaSenha(int senha){
        if(this.getSenhaDaConta()==senha){
            return true;
        }else {
            return false;
        }
    }

    public void mensagemSucesso(){
        System.out.println("Operaçao realizada");
    }

    public void mensagemFracassso(){
        System.out.println("Operaçao nao realizada");
    }
}
