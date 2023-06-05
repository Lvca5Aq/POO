class main {
    public static void main(String[] args) {
        Data hoje = new Data();
        hoje.setAno(2002);
        hoje.setDia(22);
        hoje.setMes(07);
        System.out.println(hoje);
        Data amanha = new Data();
        amanha.setAno(2002);
        amanha.setDia(22);
        amanha.setMes(7);
        System.out.println(amanha);
        hoje.checarIgualdade(amanha);
    }
}