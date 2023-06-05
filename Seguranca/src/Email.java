public class Email implements Segurança{
    public String nomeDoUsuario;
    public String email;
    private int senhaDaConta;

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public void setNomeDoUsuario(String nomeDoUsuario) {
        this.nomeDoUsuario = nomeDoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSenhaDaConta() {
        return senhaDaConta;
    }

    public void setSenhaDaConta(int senhaDaConta) {
        this.senhaDaConta = senhaDaConta;
    }
}
