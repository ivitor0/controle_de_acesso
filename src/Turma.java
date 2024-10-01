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

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public int getAnoTurma() {
        return anoTurma;
    }

    public void setAnoTurma(int anoTurma) {
        this.anoTurma = anoTurma;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isProfessorFaltou() {
        return professorFaltou;
    }

    public void setProfessorFaltou(boolean professorFaltou) {
        this.professorFaltou = professorFaltou;
    }
}