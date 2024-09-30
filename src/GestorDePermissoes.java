import java.time.LocalDate;
import java.util.List;

public class GestorDePermissoes {

    // Método principal para permitir ou não a saída de um estudante
    public boolean permitirSaidaEstudante(String matricula, LocalDate data, int horarioMinutos, List<HorarioTurma> horarios) {
        // Verifica se o estudante está em horário de aula
        HorarioTurma horarioAtual = verificarHorarioDeAula(horarioMinutos, horarios);
        if (horarioAtual != null) {
            // Encontra o estudante na turma
            Estudante estudante = encontrarEstudanteNaTurma(matricula, horarioAtual.getTurma());
            if (estudante != null) {
                // Verifica se as condições para saída são satisfeitas
                return verificarCondicoesDeSaida(estudante, horarioAtual.getTurma());
            }
        }
        return false; // Se não encontrou o estudante ou não está no horário de aula
    }

    // Método para verificar se o estudante está no horário de aula
    private HorarioTurma verificarHorarioDeAula(int horarioMinutos, List<HorarioTurma> horarios) {
        for (HorarioTurma horario : horarios) {
            if (horarioMinutos >= horario.getHoraInicio() && horarioMinutos <= horario.getHoraFim()) {
                return horario; // Retorna o horário da turma atual
            }
        }
        return null; // Não está em horário de aula
    }

    // Método para encontrar um estudante na turma com base na matrícula
    private Estudante encontrarEstudanteNaTurma(String matricula, Turma turma) {
        for (Estudante estudante : turma.getEstudantes()) {
            if (estudante.getMatricula().equals(matricula)) {
                return estudante; // Retorna o estudante encontrado
            }
        }
        return null; // Não encontrou o estudante
    }

    // Método para verificar as condições de saída do estudante
    private boolean verificarCondicoesDeSaida(Estudante estudante, Turma turma) {
        if (turma.isProfessorFaltou() && estudante.isLiberacaoPais()) {
            return true;  // Liberar saída se o professor faltou e o aluno tem permissão
        }
        return false; // Caso contrário, saída proibida
    }
}