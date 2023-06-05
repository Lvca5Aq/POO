import java.util.Scanner;

public class Estudante {
    private int matricula;
    private int anoDeEntrada;
    private String curso;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getAnoDeEntrada() {
        return anoDeEntrada;
    }

    public void setAnoDeEntrada(int anoDeEntrada) {
        this.anoDeEntrada = anoDeEntrada;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public float valorCopia(int x){
        return x*0.10f;
    }
}
