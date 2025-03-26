public class Carro extends Veiculo {

    public Carro(String modelo, String placa, double nivelCombustivel, double consumoCombustivel) {
        super(modelo, placa, nivelCombustivel, consumoCombustivel);

    }

    @Override
    public void mover(double distancia) { // calcular o combustivel do veiculo ao se mover de acordo com a distancia
        double tempoDeUso = distancia * consumoCombustivel;
        // comparando o quanto que ainda resta de combustivel
        if (nivelCombustivel >= tempoDeUso) {
            nivelCombustivel = nivelCombustivel - tempoDeUso;

            System.out.println("Nível de combustivel restante :   " + nivelCombustivel);
        } else {
            System.out.println(("Nível de combustivel insuficiente!"));
        }

    }

    @Override
    public void abastecer(double litro) {
        nivelCombustivel = nivelCombustivel + litro;
        System.out.println("Carro abastecido com " + litro + " litros. Nível atual de combustível: " + nivelCombustivel + " litros.");
    }

}
