import java.util.Scanner;
import java.util.ArrayList;


public class Principal {

    public static void main(String[] args) {
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        while(opcao != 6){
            System.out.println("\nMenu:");
            System.out.println("1- Cadastrar um veículo");
            System.out.println("2- Mover um veículo");
            System.out.println("3- Abastecer um veiculo");
            System.out.println("4- Realizar manutenção em um ônibus");
            System.out.println("5- Exibir as informações do veículo");
            System.out.println("6- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();


            switch(opcao) {
                case 1:
                    cadastrarVeiculo(veiculos, input);
                    break;
                case 2:
                    moverVeiculo(veiculos, input);
                    break;
                case 3:
                    abastecerVeiculo(veiculos, input);
                    break;
                case 4:
                    realizarManutencaoOnibus(veiculos, input);
                    break;
                case 5:
                    exibirInformacoesVeiculo(veiculos, input);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        input.close();

    }

    public static void cadastrarVeiculo(ArrayList<Veiculo> veiculos, Scanner input){
        System.out.println("Escolha o veículo: ");
        System.out.println("1 - Carro");
        System.out.println("2 - Caminhão");
        System.out.println("3 - Ônibus");

        int tipo = input.nextInt();
        input.nextLine();

        System.out.println("Modelo:");
        String modelo = input.nextLine();
        System.out.println("Placa: ");
        String placa = input.nextLine();
        System.out.println("Nível de combustível: ");
        double nivelCombustivel = input.nextDouble();
        System.out.println("Consumo de combustível: ");
        double consumoCombustivel = input.nextDouble();

        switch (tipo){
            case 1:
                Carro carro = new Carro(modelo,placa,nivelCombustivel,consumoCombustivel);
                veiculos.add(carro);
                break;
            case 2:
                System.out.println("Carga: ");
                double carga = input.nextDouble();
                Caminhao caminhao = new Caminhao(modelo,placa,nivelCombustivel,consumoCombustivel,carga);
                veiculos.add(caminhao);
                break;
            case 3:
                System.out.println("Número de passageiros: ");
                int nroPassageiros = input.nextInt();
                Onibus onibus = new Onibus(modelo,placa,nivelCombustivel,consumoCombustivel, nroPassageiros);
                veiculos.add(onibus);
                break;
            default:
                System.out.println("Inválido!");
                break;
        }
    }

    public static void moverVeiculo(ArrayList<Veiculo> veiculos, Scanner input){
        Veiculo veiculo = escolherVeiculo(veiculos, input);
        if (veiculo != null){
            System.out.println("Distância a mover:");
            double distancia = input.nextDouble();
            veiculo.mover(distancia);
        }
    }

    public static void abastecerVeiculo(ArrayList<Veiculo> veiculos, Scanner input){
        Veiculo veiculo = escolherVeiculo(veiculos, input);
        if (veiculo != null){
            System.out.println("Litros a abastecer:");
            double litros = input.nextDouble();
            veiculo.abastecer(litros);
        }
    }

    public static void realizarManutencaoOnibus(ArrayList<Veiculo> veiculos, Scanner input){
        Veiculo veiculo = escolherVeiculo(veiculos, input);
        if(veiculo instanceof Onibus){
            ((Onibus) veiculo).realizarManutencao();
        }
    }
    public static void exibirInformacoesVeiculo(ArrayList<Veiculo> veiculos, Scanner input){
        Veiculo veiculo = escolherVeiculo(veiculos, input);
        if (veiculo != null){
            System.out.println("Modelo: "+ veiculo.modelo);
            System.out.println("Placa: "+ veiculo.placa);
            System.out.println("Nível de combustível: "+ veiculo.nivelCombustivel);
            System.out.println("Consumo de combustível: "+ veiculo.consumoCombustivel);

            if(veiculo instanceof Caminhao){
                System.out.println("Carga: "+ ((Caminhao) veiculo).getCarga());
            }
            else if (veiculo instanceof Onibus){
                System.out.println("Número de passageiros: "+ ((Onibus) veiculo).nroPassageiros);
                System.out.println("Km após última manutenção: " + ((Onibus) veiculo).getKmPosManutencao());
            }
        }
    }
    public static Veiculo escolherVeiculo(ArrayList<Veiculo> veiculos, Scanner input) {
        System.out.print("Informe a placa do veículo: ");
        String placa = input.next();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.placa.equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }
}
