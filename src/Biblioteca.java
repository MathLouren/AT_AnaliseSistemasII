import java.util.ArrayList;

public class Biblioteca {
    private static final String DATA_PADRAO_EMPRESTIMO = "10/09/2025";
    private static final String MENSAGEM_LIVRO_NAO_DISPONIVEL = "Livro não disponível.";

    private ArrayList<Livro> acervo = new ArrayList<>();
    private ArrayList<Emprestimo> historicoEmprestimos = new ArrayList<>();

    public void cadastrarLivro(String titulo, String autor, int anoPublicacao) {
        acervo.add(new Livro(titulo, autor, anoPublicacao));
    }

    public void emprestarLivro(Usuario usuario, String tituloLivro) {
        Livro livro = buscarLivroDisponivel(tituloLivro);

        if (livro == null) {
            imprimir(MENSAGEM_LIVRO_NAO_DISPONIVEL);
            return;
        }

        registrarEmprestimo(usuario, livro);
        imprimir(criarMensagemEmprestimo(usuario, livro));
    }

    public void exibirEmprestimos() {
        for (Emprestimo emprestimo : historicoEmprestimos) {
            imprimir(emprestimo.formatarResumo());
        }
    }

    public void exibirRelatorioLivros() {
        for (Livro livro : acervo) {
            imprimir(formatarLivroParaRelatorio(livro));
        }
    }

    private Livro buscarLivroDisponivel(String tituloLivro) {
        for (Livro livro : acervo) {
            if (livro.getTitulo().equals(tituloLivro) && livro.estaDisponivel()) {
                return livro;
            }
        }
        return null;
    }

    private void registrarEmprestimo(Usuario usuario, Livro livro) {
        historicoEmprestimos.add(new Emprestimo(usuario, livro, DATA_PADRAO_EMPRESTIMO));
        livro.marcarComoEmprestado();
    }

    private String criarMensagemEmprestimo(Usuario usuario, Livro livro) {
        return "Empréstimo realizado: " + usuario.getNome() + " pegou " + livro.getTitulo();
    }

    private String formatarLivroParaRelatorio(Livro livro) {
        return livro.getTitulo() + " - " + livro.getAutor() + " (" + livro.getAnoPublicacao() + ")";
    }

    private void imprimir(String mensagem) {
        System.out.println(mensagem);
    }
}
