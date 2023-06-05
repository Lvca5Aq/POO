public class Elevador {
    int andar;
    int totalAndar;
    int capacidadePessoas;
    int pessoas;

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getTotalAndar() {
        return totalAndar;
    }

    public void setTotalAndar(int totalAndar) {
        this.totalAndar = totalAndar;
    }

    public int getCapacidadePessoas() {
        return capacidadePessoas;
    }

    public void setCapacidadePessoas(int capacidadePessoas) {
        this.capacidadePessoas = capacidadePessoas;
    }

    public int getPessoas() {
        return pessoas;
    }

    public void setPessoas(int pessoas) {
        this.pessoas = pessoas;
    }

    public Elevador(int totalAndar, int capacidadePessoas) {
        this.andar = 0;
        this.totalAndar = totalAndar;
        this.capacidadePessoas = capacidadePessoas;
        this.pessoas = 0;
    }
    public void entra(){
        if (this.getPessoas()==this.getCapacidadePessoas()){
            System.out.println("Nao pode entrar mais ninguem");
        } else {
            this.setPessoas(this.getPessoas()+1);
            System.out.println("entrou uma pessoa agora estamos com:"+this.getPessoas());
        }
    }
    public void saida(){
        if (this.getPessoas()==0){
            System.out.println("nao tem ninguem para sair");
        } else {
            this.setPessoas(this.getPessoas()-1);
            System.out.println("saiu uma pessoa agora estamos com:"+this.getPessoas());
        }
    }
    public void subir(){
        if (this.getAndar()==this.getTotalAndar()){
            System.out.println("nao tem para onde subir");
        } else {
            this.setAndar(this.getAndar()+1);
            System.out.println("subimos um andar agora estamos no:"+this.getAndar());
        }
    }
    public void desce(){
        if (this.getAndar()==0){
            System.out.println("nao tem para onde descer");
        } else {
            this.setPessoas(this.getPessoas()-1);
            System.out.println("descemos um andar agora estamos no :"+this.getAndar());
        }
        
    }
}
