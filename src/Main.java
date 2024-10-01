import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorDePermissoes gestorDePermissoes = new GestorDePermissoes();

        // Exemplo de criação de dados
        Curso curso = new Curso("CS101", "Ciência da Computação", true);
        Estudante estudante = new Estudante("123", "João Silva", "12345678900", "joao@gmail.com", "pai@gmail.com", true);
        List<Estudante> estudantes = new ArrayList<>();
        estudantes.add(estudante);
        Turma turma = new Turma(estudantes, 2024, curso, false);
        HorarioTurma horarioTurma = new HorarioTurma(turma, "Segunda-feira", LocalTime.of(14, 0), LocalTime.of(15, 0), 2024, 2);
        List<HorarioTurma> horarios = new ArrayList<>();
        horarios.add(horarioTurma);

        // Simulação de verificar saída
        System.out.println("Informe a matrícula do estudante:");
        String matricula = scanner.nextLine();

        System.out.println("Informe o horário (HH:mm):");
        String horarioInput = scanner.nextLine();
        LocalTime horario = LocalTime.parse(horarioInput);

        boolean podeSair = gestorDePermissoes.permitirSaidaEstudante(matricula, LocalDate.now(), horario, horarios);
        if (podeSair) {
            System.out.println("Saída liberada!");
        } else {
            System.out.println("Saída proibida!");
        }

        scanner.close();
    }
}