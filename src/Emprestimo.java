public class Emprestimo {
    final Usuario usuario;
    final Livro livro;
    final String data;

    public Emprestimo(Usuario usuario, Livro livro, String data) {
        this.usuario = usuario;
        this.livro = livro;
        this.data = data;
    }

    public String formatarResumo() {
        return "Usuário: " + usuario.getNome() + " - Livro: " + livro.getTitulo() + " - Data: " + data;
    }
}
