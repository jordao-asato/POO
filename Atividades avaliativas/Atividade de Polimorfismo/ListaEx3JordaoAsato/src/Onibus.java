public class Onibus extends Veiculo implements Manutencao {
    public int nroPassageiros;
    public double kmPosManutencao;

    public Onibus(String modelo, String placa, double nivelCombustivel, double consumoCombustivel, int nroPassageiros) {
        super(modelo, placa, nivelCombustivel, consumoCombustivel);
        this.nroPassageiros = nroPassageiros;
        this.kmPosManutencao = 0;
    }

    @Override
    public void mover(double distancia) {
        double tempoDeUso = distancia * consumoCombustivel * (nroPassageiros * 0.01);
        if (nivelCombustivel >= tempoDeUso) {
            nivelCombustivel = nivelCombustivel - tempoDeUso;
            System.out.println("Combustivel restante: " + nivelCombustivel);
            kmPosManutencao += distancia;
        } else {
            System.out.println("Combustivel insuficiente");
        }
    }


    @Override
    public void realizarManutencao() {
        System.out.println("Manutenção realizada!");
        kmPosManutencao = 0;
    }
    public double getKmPosManutencao() {
        return kmPosManutencao;
    }

}
