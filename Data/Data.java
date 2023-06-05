public class Data {
    int dia;
    int mes;
    int ano;


    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Data:" + this.getDia() + "/" + this.getMes() + "/" + this.getAno();
    }

    public void checarIgualdade(Data x) {
        if(this.getAno()==x.getAno()&&this.getMes()==x.getMes()&&this.getDia()==x.getDia()){
            System.out.println("Datas iguais");
        } else {
            System.out.println("Datas diferentes");
        }
    }

    
}