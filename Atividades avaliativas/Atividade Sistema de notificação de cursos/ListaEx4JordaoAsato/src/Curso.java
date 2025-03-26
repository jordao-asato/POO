
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private String descricao;
    private List<Observer> inscritos = new ArrayList<>();

    public Curso(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void atualizarCurso(String novaDescricao) {
        this.descricao = novaDescricao;
        notificarAlunos("Curso atualizado: " + nome);
    }

    public void inscrever(Observer aluno) {
        inscritos.add(aluno);
    }

    public void desinscrever(Observer aluno) {
        inscritos.remove(aluno);
    }

    public List<Observer> getInscritos() {
        return inscritos;
    }

    public void notificarAlunos(String mensagem) {
        for (Observer aluno : inscritos) {
            aluno.atualizar(mensagem);
        }
    }
}
