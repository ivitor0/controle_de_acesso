import java.util.List;

public class Turma {
    private List<Estudante> estudantes;
    private int anoTurma;
    private Curso curso;
    private boolean professorFaltou;

    // Construtor
    public Turma(List<Estudante> estudantes, int anoTurma, Curso curso, boolean professorFaltou) {
        this.estudantes = estudantes;
        this.anoTurma = anoTurma;
        this.curso = curso;
        this.professorFaltou = professorFaltou;
    }

    // Getters
    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public boolean isProfessorFaltou() {
        return professorFaltou;
    }
}