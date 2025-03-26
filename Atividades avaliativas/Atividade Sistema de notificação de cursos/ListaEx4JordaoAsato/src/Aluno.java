
public class Aluno implements Observer {
    protected String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println(nome + " recebeu a notificação: " + mensagem);
    }

    public String getNome() {
        return nome;
    }
}
