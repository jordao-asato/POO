
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataNotificacaoDecorator extends NotificacaoDecorator {
    public DataNotificacaoDecorator(Aluno aluno) {
        super(aluno);
    }

    @Override
    public void atualizar(String mensagem) {
        // Formatar a data e a hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = LocalDateTime.now().format(formatter);

        // Chamar o método da classe base com a mensagem formatada
        super.atualizar(mensagem + " [Atualizado em: " + dataFormatada + "]");
    }
}

