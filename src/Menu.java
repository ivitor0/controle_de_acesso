import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Estudante> estudantes = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();
    private List<HorarioTurma> horariosTurma = new ArrayList<>();

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=== Menu de Acesso ===");
            System.out.println("1. Adicionar Estudante");
            System.out.println("2. Adicionar Curso");
            System.out.println("3. Adicionar Turma");
            System.out.println("4. Vincular Estudante a Turma");
            System.out.println("5. Registrar Horário da Turma");
            System.out.println("6. Cadastrar Liberação de Curso/Turma");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    adicionarEstudante(scanner);
                    break;
                case 2:
                    adicionarCurso(scanner);
                    break;
                case 3:
                    adicionarTurma(scanner);
                    break;
                case 4:
                    vincularEstudanteATurma(scanner);
                    break;
                case 5:
                    registrarHorarioDaTurma(scanner);
                    break;
                case 6:
                    cadastrarLiberacao(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private void adicionarEstudante(Scanner scanner) {
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Email do Responsável: ");
        String emailResponsavel = scanner.nextLine();
        System.out.print("Liberação dos Pais (true/false): ");
        boolean liberacaoPais = scanner.nextBoolean();
        scanner.nextLine(); // Consumir a nova linha

        Estudante estudante = new Estudante(matricula, nome, cpf, email, emailResponsavel, liberacaoPais);
        estudantes.add(estudante);
        System.out.println("Estudante adicionado com sucesso.");
    }

    private void adicionarCurso(Scanner scanner) {
        System.out.print("Código do Curso: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome do Curso: ");
        String nome = scanner.nextLine();
        System.out.print("Ativo (true/false): ");
        boolean ativo = scanner.nextBoolean();
        scanner.nextLine(); // Consumir a nova linha

        Curso curso = new Curso(codigo, nome, ativo);
        cursos.add(curso);
        System.out.println("Curso adicionado com sucesso.");
    }

    private void adicionarTurma(Scanner scanner) {
        System.out.print("Ano da Turma: ");
        int anoTurma = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Informe o código do curso: ");
        String codigoCurso = scanner.nextLine();
        Curso curso = null;
        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigoCurso)) {
                curso = c;
                break;
            }
        }

        if (curso == null) {
            System.out.println("Curso não encontrado.");
            return;
        }

        Turma turma = new Turma(new ArrayList<>(), anoTurma, curso, false);
        turmas.add(turma);
        System.out.println("Turma adicionada com sucesso.");
    }

    private void vincularEstudanteATurma(Scanner scanner) {
        System.out.print("Informe a matrícula do estudante: ");
        String matricula = scanner.nextLine();
        Estudante estudante = null;
        for (Estudante e : estudantes) {
            if (e.getMatricula().equals(matricula)) {
                estudante = e;
                break;
            }
        }

        if (estudante == null) {
            System.out.println("Estudante não encontrado.");
            return;
        }

        System.out.print("Informe o ano da turma: ");
        int anoTurma = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha
        Turma turma = null;

        for (Turma t : turmas) {
            if (t.getAnoTurma() == anoTurma) {
                turma = t;
                break;
            }
        }

        if (turma == null) {
            System.out.println("Turma não encontrada.");
            return;
        }

        turma.getEstudantes().add(estudante);
        System.out.println("Estudante vinculado à turma com sucesso.");
    }

    private void registrarHorarioDaTurma(Scanner scanner) {
        System.out.print("Informe o ano da turma: ");
        int anoTurma = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Turma turma = null;
        for (Turma t : turmas) {
            if (t.getAnoTurma() == anoTurma) {
                turma = t;
                break;
            }
        }

        if (turma == null) {
            System.out.println("Turma não encontrada.");
            return;
        }

        System.out.print("Dia da Semana: ");
        String diaSemana = scanner.nextLine();
        System.out.print("Hora de Início (em minutos): ");
        int horaInicio = scanner.nextInt();
        System.out.print("Hora de Fim (em minutos): ");
        int horaFim = scanner.nextInt();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Semestre: ");
        int semestre = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        HorarioTurma horario = new HorarioTurma(turma, diaSemana, horaInicio, horaFim, ano, semestre);
        horariosTurma.add(horario);
        System.out.println("Horário da turma registrado com sucesso.");
    }

    private void cadastrarLiberacao(Scanner scanner) {
        System.out.print("Informe a matrícula do estudante: ");
        String matricula = scanner.nextLine();
        Estudante estudante = null;

        for (Estudante e : estudantes) {
            if (e.getMatricula().equals(matricula)) {
                estudante = e;
                break;
            }
        }

        if (estudante == null) {
            System.out.println("Estudante não encontrado.");
            return;
        }

        System.out.print("Informe o código do curso: ");
        String codigoCurso = scanner.nextLine();
        Curso curso = null;

        for (Curso c : cursos) {
            if (c.getCodigo().equals(codigoCurso)) {
                curso = c;
                break;
            }
        }

        if (curso == null) {
            System.out.println("Curso não encontrado.");
            return;
        }

        // Aqui você pode adicionar a lógica para registrar a liberação
        // Por exemplo, pode-se armazenar em uma lista ou diretamente no objeto Estudante
        // Exemplo simplificado:
        estudante.setLiberacaoPais(true); // Defina como necessário

        System.out.println("Liberação cadastrada com sucesso para o estudante " + estudante.getNome());
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}
