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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    public boolean isLiberacaoPais() {
        return liberacaoPais;
    }

    public void setLiberacaoPais(boolean liberacaoPais) {
        this.liberacaoPais = liberacaoPais;
    }
}