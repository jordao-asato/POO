public abstract class Veiculo {
    public String modelo;
    public String placa;
    public double nivelCombustivel;
    public double consumoCombustivel;

    public Veiculo(String modelo, String placa, double nivelCombustivel, double consumoCombustivel) {
        this.modelo = modelo;
        this.placa = placa;
        this.nivelCombustivel = nivelCombustivel;
        this.consumoCombustivel = consumoCombustivel;
    }

    public void mover(double distancia) {
        double tempoDeUso = distancia * consumoCombustivel;
        if (tempoDeUso <= nivelCombustivel) {
            nivelCombustivel = nivelCombustivel - tempoDeUso;
            System.out.println("Veículo movido por " + distancia + " km. Combustível restante: " + nivelCombustivel + " litros.");
        } else {
            System.out.println("Combustível insuficiente para percorrer " + distancia + " km.");
        }

    }

    public void abastecer(double litro) {
        nivelCombustivel = nivelCombustivel + litro;
        System.out.println("Combustivel:  " + nivelCombustivel);
    }

}
