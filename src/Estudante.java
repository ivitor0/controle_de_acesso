public class Estudante {

    private String matricula;
    private String nome;
    private String cpf;
    private String email;
    private String emailResponsavel;
    private boolean liberacaoPais;

    // Construtor
    public Estudante(String matricula, String nome, String cpf, String email, String emailResponsavel, boolean liberacaoPais) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.emailResponsavel = emailResponsavel;
        this.liberacaoPais = liberacaoPais;
    }

    // Getters
    public String getMatricula() {
        return matricula;
    }

    public boolean isLiberacaoPais() {
        return liberacaoPais;
    }
}