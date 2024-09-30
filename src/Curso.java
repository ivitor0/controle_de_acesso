public class Curso {
    private String codigo;
    private String nome;
    private boolean ativo;

    // Construtor
    public Curso(String codigo, String nome, boolean ativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.ativo = ativo;
    }

    // Getters
    public boolean isAtivo() {
        return ativo;
    }
}