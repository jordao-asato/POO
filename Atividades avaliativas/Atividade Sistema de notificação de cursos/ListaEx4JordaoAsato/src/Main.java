import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Curso> cursos = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();

        while (true) {
            System.out.println("1. Cadastrar Curso");
            System.out.println("2. Atualizar Curso");
            System.out.println("3. Inscrever Aluno");
            System.out.println("4. Personalizar notificações de um aluno");
            System.out.println("5. Listar Cursos");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do curso: ");
                    String nomeCurso = scanner.nextLine();
                    System.out.print("Descrição do curso: ");
                    String descricaoCurso = scanner.nextLine();

                    boolean cursoExistente = false;
                    for (Curso curso : cursos) {
                        if (curso.getNome().equals(nomeCurso)) {
                            cursoExistente = true;
                            System.out.println("Curso já cadastrado: " + nomeCurso);
                            break;
                        }
                    }
                    if (!cursoExistente) {
                        cursos.add(new Curso(nomeCurso, descricaoCurso));
                        System.out.println("Curso cadastrado com sucesso: " + nomeCurso);
                    }
                    break;
                case 2:
                    System.out.print("Nome do curso a atualizar: ");
                    nomeCurso = scanner.nextLine();

                    Curso cursoEncontrado = null;
                    for (Curso curso : cursos) {
                        if (curso.getNome().equals(nomeCurso)) {
                            cursoEncontrado = curso;
                            break;
                        }
                    }

                    if (cursoEncontrado == null) {
                        System.out.println("Curso não encontrado!");
                        break;
                    }

                    System.out.print("Nova descrição: ");
                    String novaDescricao = scanner.nextLine();
                    cursoEncontrado.atualizarCurso(novaDescricao);
                    System.out.println("Descrição do curso " + nomeCurso + " foi alterada para: " + novaDescricao);
                    break;
                case 3:
                    System.out.print("Nome do aluno: ");
                    String nomeAluno = scanner.nextLine();

                    Aluno alunoEncontrado = null;
                    for (Aluno aluno : alunos) {
                        if (aluno.getNome().equals(nomeAluno)) {
                            alunoEncontrado = aluno;
                            break;
                        }
                    }

                    if (alunoEncontrado == null) {
                        alunoEncontrado = new Aluno(nomeAluno);
                        alunos.add(alunoEncontrado);
                        System.out.println("Aluno cadastrado com sucesso: " + nomeAluno);
                    } else {
                        System.out.println("Aluno já cadastrado: " + nomeAluno);
                    }

                    // Inscrever o aluno em um curso específico
                    System.out.print("Nome do curso para inscrição: ");
                    nomeCurso = scanner.nextLine();
                    cursoEncontrado = null;
                    for (Curso curso : cursos) {
                        if (curso.getNome().equals(nomeCurso)) {
                            cursoEncontrado = curso;
                            break;
                        }
                    }

                    if (cursoEncontrado == null) {
                        System.out.println("Curso não encontrado!");
                    } else {
                        cursoEncontrado.inscrever(alunoEncontrado);
                        System.out.println("Aluno " + nomeAluno + " inscrito no curso " + nomeCurso);
                    }
                    break;
                case 4:
                    System.out.print("Nome do aluno para personalização: ");
                    nomeAluno = scanner.nextLine();
                    Aluno alunoParaPersonalizar = null;

                    // Verificar se o aluno existe
                    for (Aluno a : alunos) {
                        if (a.getNome().equals(nomeAluno)) {
                            alunoParaPersonalizar = a;
                            break;
                        }
                    }

                    if (alunoParaPersonalizar == null) {
                        System.out.println("Aluno não encontrado! Inscreva o aluno em um curso primeiro.");
                        break;
                    }

                    // Exibir opções de personalização
                    System.out.println("Escolha uma personalização:");
                    System.out.println("1. Adicionar 'URGENTE'");
                    System.out.println("2. Notificação em MAIÚSCULAS");
                    System.out.println("3. Incluir DATA");

                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    Aluno alunoDecorado = alunoParaPersonalizar; // Inicia com o aluno original

                    if (escolha == 1) {
                        alunoDecorado = new UrgenteNotificacaoDecorator(alunoParaPersonalizar);
                        System.out.println("Personalização 'URGENTE' adicionada para " + nomeAluno + ".");
                    } else if (escolha == 2) {
                        alunoDecorado = new MaiusculasNotificacaoDecorator(alunoParaPersonalizar);
                        System.out.println("Notificações em MAIÚSCULAS adicionadas para " + nomeAluno + ".");
                    } else if (escolha == 3) {
                        alunoDecorado = new DataNotificacaoDecorator(alunoParaPersonalizar);
                        System.out.println("Data incluída nas notificações para " + nomeAluno + ".");
                    } else {
                        System.out.println("Opção inválida!");
                        break;
                    }

                    // Atualiza a lista de alunos com o aluno decorado
                    int index = alunos.indexOf(alunoParaPersonalizar);
                    if (index != -1) {
                        alunos.set(index, alunoDecorado);
                    } else {
                        System.out.println("Erro ao atualizar o aluno. Aluno não encontrado na lista.");
                    }

                    // Atualiza as inscrições do aluno decorado em todos os cursos
                    for (Curso curso : cursos) {
                        if (curso.getInscritos().contains(alunoParaPersonalizar)) {
                            curso.desinscrever(alunoParaPersonalizar);
                            curso.inscrever(alunoDecorado);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Cursos cadastrados:");
                    for (Curso curso : cursos) {
                        System.out.println("Nome: " + curso.getNome() + ", Descrição: " + curso.getDescricao());
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
