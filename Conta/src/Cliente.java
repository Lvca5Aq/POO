public class Cliente {
    private int cpf;
    private String endereço;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf=" + cpf +
                ", endereço='" + endereço + '\'' +
                '}';
    }

    public Cliente(int cpf, String endereço) {
        this.cpf = cpf;
        this.endereço = endereço;
    }
}
