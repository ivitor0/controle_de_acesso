import java.time.LocalTime;

public class HorarioTurma {
    private Turma turma;
    private String diaSemana;
    private LocalTime horaInicio;  // Mudado para LocalTime
    private LocalTime horaFim;      // Mudado para LocalTime
    private int ano;
    private int semestre;

    // Construtor
    public HorarioTurma(Turma turma, String diaSemana, LocalTime horaInicio, LocalTime horaFim, int ano, int semestre) {
        this.turma = turma;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.ano = ano;
        this.semestre = semestre;
    }

    // Getters
    public Turma getTurma() {
        return turma;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }
}