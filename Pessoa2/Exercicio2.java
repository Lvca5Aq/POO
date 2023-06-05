public class Exercicio2 {
    public static void main(String[] args) {
        Conta lucas = new Conta();
        Conta carla = new Conta();
        lucas.setCpf(626594063);
        lucas.setSaldo(100.20);
        lucas.setNum(5822727);
        lucas.setTipo(false);
        lucas.calBonificaçao();
        lucas.saque(10);
        lucas.deposito(10);
        lucas.status();
        carla.setCpf(353828);
        carla.setSaldo(500.50);
        carla.setNum(159825);
        carla.setTipo(true);
        lucas.traferencia(carla, 100.20);
        lucas.status();
        carla.status();
    }
}
