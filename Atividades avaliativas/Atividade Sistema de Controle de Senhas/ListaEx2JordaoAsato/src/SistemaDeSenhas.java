import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class SistemaDeSenhas {

    private static Queue<Integer> filaSenhas = new LinkedList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Emitir nova senha");
            System.out.println("2. Desistir da fila");
            System.out.println("3. Atender usuário");
            System.out.println("4. Buscar posição na fila");
            System.out.println("5. Imprimir fila");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    emitirNovaSenha();
                    break;
                case 2:
                    desistirDaFila(scanner);
                    break;
                case 3:
                    atenderUsuario();
                    break;
                case 4:
                    buscarPosicaoNaFila(scanner);
                    break;
                case 5:
                    imprimirFila();
                    break;
                case 6:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void emitirNovaSenha() {
        int novaSenha = random.nextInt(1000);
        filaSenhas.add(novaSenha);
        System.out.println("Senha emitida: " + novaSenha);
    }

    private static void desistirDaFila(Scanner scanner) {
        System.out.print("Informe a senha que deseja remover: ");
        int senha = scanner.nextInt();
        if (filaSenhas.remove(senha)) {
            System.out.println("Senha " + senha + " removida da fila.");
        } else {
            System.out.println("Senha " + senha + " não encontrada na fila.");
        }
    }

    private static void atenderUsuario() {
        if (filaSenhas.isEmpty()) {
            System.out.println("Não há senhas na fila.");
        } else {
            int senhaAtendida = filaSenhas.poll();
            System.out.println("Atendendo senha: " + senhaAtendida);
        }
    }

    private static void buscarPosicaoNaFila(Scanner scanner) {
        System.out.print("Informe a senha para buscar a posição: ");
        int senha = scanner.nextInt();
        int posicao = 1;
        boolean encontrada = false;
        for (int s : filaSenhas) {
            if (s == senha) {
                encontrada = true;
                break;
            }
            posicao++;
        }
        if (encontrada) {
            System.out.println("A senha " + senha + " está na posição: " + posicao);
        } else {
            System.out.println("Senha " + senha + " não encontrada na fila.");
        }
    }

    private static void imprimirFila() {
        if (filaSenhas.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Senhas na fila: " + filaSenhas);
        }
    }
}
