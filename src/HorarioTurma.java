public class HorarioTurma {
    private Turma turma;
    private String diaSemana;
    private int horaInicio;  // Horário em minutos (ex: 14:00 -> 840)
    private int horaFim;
    private int ano;
    private int semestre;

    // Construtor
    public HorarioTurma(Turma turma, String diaSemana, int horaInicio, int horaFim, int ano, int semestre) {
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

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getHoraFim() {
        return horaFim;
    }
}