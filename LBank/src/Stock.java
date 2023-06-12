public class Stock {
    private int cod;
    private int probReturn;
    private int multiplicador;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getProbReturn() {
        return probReturn;
    }

    public void setProbReturn(int probReturn) {
        this.probReturn = probReturn;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public Stock(int cod, int probReturn, int multiplicador) {
        this.cod = cod;
        this.probReturn = probReturn;
        this.multiplicador = multiplicador;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "cod=" + cod +
                ", probReturn=" + probReturn +
                "%, multiplicador=" + multiplicador +
                '}';
    }
}

