
public class MaiusculasNotificacaoDecorator extends NotificacaoDecorator {
    public MaiusculasNotificacaoDecorator(Aluno aluno) {
        super(aluno);
    }

    @Override
    public void atualizar(String mensagem) {
        super.atualizar(mensagem.toUpperCase());
    }
}
