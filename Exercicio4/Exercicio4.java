public class Exercicio4 {
    public static void main(String[] args) {
        Empregado lucas = new Empregado(null, null, 0);
        Empregado carla = new Empregado(null, null, 0);
        Empregado weskley = new Empregado(null, null, 0);
        carla.setNome("Carla");
        carla.setSobrenome("Alcoforado");
        carla.setSalario(5000.80);
        weskley.setSalario(-1000);
        System.out.println(weskley.getSalario());
        System.out.println("O salario da Carla é:"+carla.getSalario()+"R$");
        System.out.println("O salario do Lucas é:"+lucas.getSalario()+"R$");
        lucas.forneceAumento();
        System.out.println("O salario do Lucas é:"+lucas.getSalario()+"R$");
        System.out.println(lucas);
    }
}
