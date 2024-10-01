import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class GestorDePermissoes {

    // Método principal para permitir ou não a saída de um estudante
    public boolean permitirSaidaEstudante(String matricula, LocalDate data, LocalTime horario, List<HorarioTurma> horarios) {
        HorarioTurma horarioAtual = verificarHorarioDeAula(horario, horarios);
        if (horarioAtual != null) {
            Estudante estudante = encontrarEstudanteNaTurma(matricula, horarioAtual.getTurma());
            if (estudante != null) {
                return verificarCondicoesDeSaida(estudante, horarioAtual.getTurma());
            }
        }
        return false;
    }

    // Método para verificar se o estudante está no horário de aula
    private HorarioTurma verificarHorarioDeAula(LocalTime horario, List<HorarioTurma> horarios) {
        for (HorarioTurma horarioTurma : horarios) {
            if (!horario.isBefore(horarioTurma.getHoraInicio()) && !horario.isAfter(horarioTurma.getHoraFim())) {
                return horarioTurma;
            }
        }
        return null;
    }

    // Método para encontrar um estudante na turma com base na matrícula
    private Estudante encontrarEstudanteNaTurma(String matricula, Turma turma) {
        for (Estudante estudante : turma.getEstudantes()) {
            if (estudante.getMatricula().equals(matricula)) {
                return estudante;
            }
        }
        return null;
    }


    private boolean verificarCondicoesDeSaida(Estudante estudante, Turma turma) {
        if (turma.isProfessorFaltou() && estudante.isLiberacaoPais()) {
            return true;
        }
        return false;
    }
}