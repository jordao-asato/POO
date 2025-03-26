
public class UrgenteNotificacaoDecorator extends NotificacaoDecorator {
    public UrgenteNotificacaoDecorator(Aluno aluno) {
        super(aluno);
    }

    @Override
    public void atualizar(String mensagem) {
        super.atualizar("URGENTE: " + mensagem);
    }
}
