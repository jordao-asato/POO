public class Caminhao extends Veiculo {

    private double carga;

    public Caminhao(String modelo, String placa, double nivelCombustivel, double consumoCombustivel, double carga) {
        super(modelo, placa, nivelCombustivel, consumoCombustivel);
        this.carga = carga;
    }

    @Override
    public void mover(double distancia) {
        double tempoDeUso = distancia * consumoCombustivel * (carga * 0.05);
        if (nivelCombustivel >= tempoDeUso) {
            nivelCombustivel = nivelCombustivel - tempoDeUso;

            System.out.println(
                    "Caminhao movido por " + distancia + "km .Nivel de combustivel :   " + nivelCombustivel + " litros");
        } else {
            System.out.println(("Nivel de combustivel insuficiente para mover o caminhao!"));
        }
    }

    @Override
    public void abastecer(double litro) {
        nivelCombustivel = nivelCombustivel + litro;
        System.out.println("Caminhão abastecido com " + litro + " litros. Nível atual de combustível: "
                + nivelCombustivel + " litros.");
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
}
