public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarLivro("O Senhor dos Anéis", "J. R. R. Tolkien", 1954);
        biblioteca.cadastrarLivro("Refatoração", "Martin Fowler", 2020);

        Usuario usuario = new Usuario("Maria", 21, "maria@gmail.com");

        biblioteca.emprestarLivro(usuario, "O Senhor dos Anéis");
        biblioteca.emprestarLivro(usuario, "Refatoração");

        biblioteca.exibirEmprestimos();
    }
}
