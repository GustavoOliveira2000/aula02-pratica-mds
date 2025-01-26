/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hotelmanagement;

import static com.mycompany.hotelmanagement.Manutencao.listarManutencoes;
import static com.mycompany.hotelmanagement.Quarto.listarQuartos;
import static com.mycompany.hotelmanagement.Reserva.listarReservas;

import java.util.List;
import java.util.Scanner;
import java.sql.Date;

/**
 *
 * @author gustavooliveira
 *
 */

public class Hotelmanagement 
{
    
    public static void main(String[] args) 
    {
        
        Quarto quarto1 = new Quarto(1, "Suite", "disponível", 4, 2, 1, "mar", true, true);
        Quarto quarto2 = new Quarto(2, "Duplo", "disponível", 2, 1, 1, "montanha", false, false);
        Quarto quarto3 = new Quarto(3, "Single", "disponível", 1, 1, 1, "cidade", false, false);

        // Adicionar quartos à persistência
        Quarto.adicionarQuarto(quarto1);
        Quarto.adicionarQuarto(quarto2);
        Quarto.adicionarQuarto(quarto3);
        
        Reserva reserva1 = new Reserva(101, Date.valueOf("2025-02-01"), Date.valueOf("2025-02-05"), "Vista para o mar", new Quarto[]{quarto1});
        Reserva reserva2 = new Reserva(102, Date.valueOf("2025-02-10"), Date.valueOf("2025-02-15"), "Cama extra", new Quarto[]{quarto2, quarto3});

        // Adicionar reservas à persistência
        Reserva.adicionarReserva(reserva1);
        Reserva.adicionarReserva(reserva2);
        
        
        Scanner scanner = new Scanner (System.in);
        System.out.println("**** Enter System as Funcionario (opt 1) , Gestor (opt 2) ou Hospede (opt 3) *****");
        System.out.println("Opt : ");
        int options = scanner.nextInt();
        
        
            switch(options)
                {
                    case 1 -> funcionarioManager() ;
                        case 2 -> gerenteManager();
                            case 3 -> hospedeManager();
                
                }

    }

     
     
    private static void gerenteManager()
    {
    
        // acessar metodos de quarto e métodos de manutenção
        Scanner scanner = new Scanner (System.in);
        System.out.println("**** Entre com informação sobre gerente *****");
        
        System.out.println("Nome : ");
        String nome = scanner.nextLine();
        System.out.println("Id : ");
        int id = scanner.nextInt();

        Funcionarios funcionario = new Funcionarios(id, nome, "Gerente");
        
        System.out.println("Funcionario Criado - " + funcionario.getNome());
        
        
        
        
        while (true) {
            System.out.println("\n--- Menu Gestor ---");
            System.out.println("1. Criar Quarto");
            System.out.println("2. Editar Quarto");
            System.out.println("3. Remover Quarto");
            System.out.println("4. Registrar Manutenção");
            System.out.println("5. Verificar Manutenção");
            System.out.println("6. Confirmar Reserva (Comentado)");
            System.out.println("7. Rejeitar Reserva (Comentado)");
            System.out.println("8. Listar Quartos");
            System.out.println("9. Listar Manutenções");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1 -> criarQuarto();
                case 2 -> editarQuarto();
                case 3 -> removerQuarto();
                case 4 -> registrarManutencao();
                case 5 -> verificarManutencao();
                case 6 -> confirmarReserva(); 
                case 7 -> rejeitarReserva(); 
                case 8 -> listarQuartos().forEach(System.out::println);
                case 9 -> listarManutencoes().forEach(System.out::println);
                case 0 -> {
                    System.out.println("Encerrando o sistema...");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
        
        
    
    }
    
    private static void funcionarioManager()
    {
                    // acessar metodos de quarto e métodos de manutenção
        Scanner scanner = new Scanner (System.in);
        System.out.println("**** Entre com informação sobre Funcionario *****");
        
        System.out.println("Nome : ");
        String nome = scanner.nextLine();
        System.out.println("Id : ");
        int id = scanner.nextInt();

        Funcionarios funcionario = new Funcionarios(id, nome, "Funcipnario");
        System.out.println("Funcionário Criado - " + funcionario.getNome());
          
        while (true) 
        {
            System.out.println("\n--- Menu Funcionário ---");
            System.out.println("1. Registrar Manutenção");
            System.out.println("2. Verificar Manutenção");
            System.out.println("3. Confirmar Reserva");
            System.out.println("4. Rejeitar Reserva");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1 -> registrarManutencao(); // Registrar Manutenção
                case 2 -> verificarManutencao(); // Verificar Manutenção
                case 3 -> confirmarReserva(); // Confirmar Reserva
                case 4 -> rejeitarReserva(); // Rejeitar Reserva
                case 0 -> {
                    System.out.println("Saindo do menu Funcionário...");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
        
    }
    
    private  static void hospedeManager ()
    {
    
            // metodos para fazer a reserva ... 
        
        Scanner scanner = new Scanner (System.in);
        System.out.println("**** Entre com informação sobre Hospede *****");
        
        System.out.println("Nome : ");
        String nome = scanner.nextLine();
        System.out.println("Contacto : ");
        String contacto = scanner.nextLine();
        System.out.println("Email : ");
        String email = scanner.nextLine();
        System.out.println("Id : ");
        int id = scanner.nextInt();

        Hospedes hospede = new Hospedes(id, nome,contacto, email );
            while (true) 
            {
            System.out.println("\n--- Menu Hóspede ---");
            System.out.println("1. Criar Reserva");
            System.out.println("2. Listar Reservas");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

        switch (escolha) 
        {
            case 1 -> criarReserva(); // Criar uma nova reserva
            case 2 -> listarReservas().forEach(System.out::println);
            case 0 -> 
                {
                System.out.println("Saindo do menu Hóspede...");
                return;
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
        
        }
     }
    

    // Case 1: Criar Quarto
    private static void criarQuarto() // - Ok 
    {
        
        Scanner scanner = new Scanner (System.in);
        
        System.out.println("Criando um novo quarto...");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Status ( novo, disponive, ocupado, manutenção ) : ");
        String status = scanner.nextLine();
        System.out.print("Capacidade Máxima: ");
        int capacidade = scanner.nextInt();
        System.out.print("Número de Camas: ");
        int camas = scanner.nextInt();
        System.out.print("Número de Casas de Banho: ");
        int banhos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo de Vista: ");
        String vista = scanner.nextLine();
        System.out.print("Tem Cozinha (true/false): ");
        boolean cozinha = scanner.nextBoolean();
        System.out.print("Tem Varanda (true/false): ");
        boolean varanda = scanner.nextBoolean();

        Quarto novoQuarto = new Quarto(id, tipo, status, capacidade, camas, banhos, vista, cozinha, varanda);
        Quarto.adicionarQuarto(novoQuarto);
    }

    // Case 2: Editar Quarto
    private static void editarQuarto() // - Ok 
    {
    
    Scanner scanner = new Scanner (System.in);
    
    System.out.print("Digite o ID do quarto que deseja editar: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha

    Quarto quarto = Quarto.retornarQuartoPorId(id);
    if (quarto == null) {
        System.out.println("Quarto não encontrado.");
        return;
    }

    System.out.println("Editando o quarto: " + quarto);

    // Editar Tipo
    System.out.print("Novo Tipo (ou pressione Enter para manter): ");
    String novoTipo = scanner.nextLine();
    if (!novoTipo.isBlank()) {
        quarto.setTipo(novoTipo);
    }

    // Editar Status
    System.out.print("Novo Status (ou pressione Enter para manter): ");
    String novoStatus = scanner.nextLine();
    if (!novoStatus.isBlank()) {
        quarto.setStatus(novoStatus);
    }

    // Editar Capacidade Máxima
    System.out.print("Nova Capacidade Máxima (-1 para manter): ");
    int novaCapacidade = scanner.nextInt();
    if (novaCapacidade != -1) {
        quarto.setMaxCapacidadeHospedes(novaCapacidade);
    }

    // Editar Número de Camas
    System.out.print("Novo Número de Camas (-1 para manter): ");
    int novoNumCamas = scanner.nextInt();
    if (novoNumCamas != -1) {
        quarto.setNumCamas(novoNumCamas);
    }

    // Editar Número de Casas de Banho
    System.out.print("Novo Número de Casas de Banho (-1 para manter): ");
    int novoNumCasasDeBanho = scanner.nextInt();
    if (novoNumCasasDeBanho != -1) {
        quarto.setNumCasasDeBanho(novoNumCasasDeBanho);
    }
    scanner.nextLine(); // Consumir a quebra de linha

    // Editar Tipo de Vista
    System.out.print("Novo Tipo de Vista (ou pressione Enter para manter): ");
    String novoTipoVista = scanner.nextLine();
    if (!novoTipoVista.isBlank()) {
        quarto.setTipoVista(novoTipoVista);
    }

    // Editar Tem Cozinha
    System.out.print("Tem Cozinha? (true/false ou pressione Enter para manter): ");
    String cozinhaInput = scanner.nextLine();
    if (!cozinhaInput.isBlank()) {
        boolean temCozinha = Boolean.parseBoolean(cozinhaInput);
        quarto.setTemCozinha(temCozinha);
    }

    // Editar Tem Varanda
    System.out.print("Tem Varanda? (true/false ou pressione Enter para manter): ");
    String varandaInput = scanner.nextLine();
    if (!varandaInput.isBlank()) {
        boolean temVaranda = Boolean.parseBoolean(varandaInput);
        quarto.setTemVaranda(temVaranda);
    }

    // Atualiza o quarto na lista
    Quarto.removerQuarto(id); // Remove o quarto antigo
    Quarto.adicionarQuarto(quarto); // Adiciona o quarto atualizado
    System.out.println("Quarto atualizado com sucesso.");
    }

    // Case 3: Remover Quarto
    private static void removerQuarto() // - Ok 
    {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("Digite o ID do quarto que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (Quarto.removerQuarto(id)) {
            System.out.println("Quarto removido com sucesso.");
        } else {
            System.out.println("Quarto não encontrado.");
        }
    }

    // Case 4: Registrar Manutenção
    private static void registrarManutencao() // - Ok 
    {
        Scanner scanner = new Scanner (System.in);
        
        System.out.print("Digite o ID da manutenção: ");
        int id = scanner.nextInt();
        System.out.print("Digite o ID do quarto relacionado: ");
        int quartoId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Descrição da manutenção: ");
        String descricao = scanner.nextLine();
        System.out.print("Status (true para pendente, false para concluída): ");
        boolean status = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Realizada por: ");
        String realizadaPor = scanner.nextLine();
        
        
        Manutencao manutencao = new Manutencao(id, quartoId, descricao, status, realizadaPor);
        Manutencao.adicionarManutencao(manutencao);
    }

    // Case 5: Verificar Manutenção
    private static void verificarManutencao() // Ok
    {
    Scanner scanner = new Scanner (System.in);
    
    System.out.print("Digite o ID do quarto para verificar manutenções pendentes: ");
    int quartoId = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha

    List<Manutencao> manutencoesPendentes = Manutencao.verificarManutencaoPorQuarto(quartoId);

    if (manutencoesPendentes.isEmpty()) {
        System.out.println("Não há manutenções pendentes para o quarto com ID " + quartoId + ".");
    } else {
        System.out.println("Manutenções pendentes para o quarto com ID " + quartoId + ":");
        manutencoesPendentes.forEach(System.out::println);
    }
}
    
    private static void confirmarReserva() // faltar testar
    {
        
        Scanner scanner = new Scanner (System.in);
        System.out.print("Digite o ID da reserva que deseja confirmar: ");
        int reservaId = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

    Reserva.confirmarReserva(reservaId); // Chama o método na classe Reserva
    }

    private static void rejeitarReserva() // falta testar
    {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Digite o ID da reserva que deseja rejeitar: ");
        int reservaId = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Reserva.rejeitarReserva(reservaId); // Chama o método na classe Reserva
    }

    private static void criarReserva() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Criando uma nova reserva...");
    System.out.print("ID da Reserva: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha
    System.out.print("Data de Início (formato: yyyy-MM-dd): ");
    Date dataInicio = Date.valueOf(scanner.nextLine()); // Converter para Date
    System.out.print("Data de Fim (formato: yyyy-MM-dd): ");
    Date dataFim = Date.valueOf(scanner.nextLine()); // Converter para Date
    System.out.print("Preferências (descreva suas preferências): ");
    String preferencias = scanner.nextLine();

    // Selecionar quartos
    System.out.print("Quantos quartos deseja reservar? ");
    int numQuartos = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha
    Quarto[] quartos = new Quarto[numQuartos];

    for (int i = 0; i < numQuartos; i++) {
        System.out.print("Digite o ID do quarto " + (i + 1) + ": ");
        int quartoId = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Quarto quarto = Quarto.retornarQuartoPorId(quartoId);
        if (quarto != null) {
            quartos[i] = quarto;
        } else {
            System.out.println("Quarto com ID " + quartoId + " não encontrado. Tente novamente.");
            i--; // Repetir a entrada
        }
    }

    // Criar a reserva
    Reserva reserva = new Reserva(id, dataInicio, dataFim, preferencias, quartos);
    Reserva.adicionarReserva(reserva);
    System.out.println("Reserva criada com sucesso!");
    }
}
