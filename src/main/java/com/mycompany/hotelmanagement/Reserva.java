/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagement;

/**
 *
 * @author marianasilva
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reserva 
{
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private String status; // "pendente", "confirmada", "rejeitada"
    private String preferencias;
    private Quarto[] quarto;

    // Lista estática para persistência
    private static List<Reserva> reservas = new ArrayList<>();

    // Construtor
    public Reserva(int id, Date dataInicio, Date dataFim, String preferencias, Quarto[] quarto) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.preferencias = preferencias;
        this.status = "pendente"; // Status inicial é sempre "pendente"
        this.quarto = quarto;
    }

    // Métodos de persistência

    // Adicionar uma reserva
    public static void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
        System.out.println("Reserva adicionada: " + reserva);
    }

    // Listar todas as reservas
    public static List<Reserva> listarReservas() {
        return reservas;
    }

    // Remover uma reserva por ID
    public static boolean removerReserva(int id) {
        return reservas.removeIf(reserva -> reserva.getId() == id);
    }

    // Confirmar uma reserva por ID
    public static void confirmarReserva(int id) {
        Reserva reserva = buscarReservaPorId(id);
        if (reserva != null) {
            if ("pendente".equalsIgnoreCase(reserva.getStatus())) {
                reserva.setStatus("confirmada");
                System.out.println("Reserva " + id + " confirmada com sucesso.");
            } else {
                System.out.println("A reserva " + id + " não está em status pendente.");
            }
        } else {
            System.out.println("Reserva com ID " + id + " não encontrada.");
        }
    }

    // Rejeitar uma reserva por ID
    public static void rejeitarReserva(int id) {
        Reserva reserva = buscarReservaPorId(id);
        if (reserva != null) {
            if ("pendente".equalsIgnoreCase(reserva.getStatus())) {
                reserva.setStatus("rejeitada");
                System.out.println("Reserva " + id + " rejeitada com sucesso.");
            } else {
                System.out.println("A reserva " + id + " não está em status pendente.");
            }
        } else {
            System.out.println("Reserva com ID " + id + " não encontrada.");
        }
    }

    // Método auxiliar: Buscar uma reserva por ID
    public static Reserva buscarReservaPorId(int id) {
        return reservas.stream()
                .filter(reserva -> reserva.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public Quarto[] getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto[] quarto) {
        this.quarto = quarto;
    }

    @Override
    public String toString() {
        return "Reserva {" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", status='" + status + '\'' +
                ", preferencias=" + String.join(", ", preferencias) +
                '}';
    }
}