
public abstract class NotificacaoDecorator extends Aluno {
    protected Aluno alunoDecorado;

    public NotificacaoDecorator(Aluno aluno) {
        super(aluno.nome);
        this.alunoDecorado = aluno;
    }

    @Override
    public void atualizar(String mensagem) {
        alunoDecorado.atualizar(mensagem);
    }
}
