/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gustavooliveira
 *
 */


public class Manutencao 
{
    private int id; // Identificador único da manutenção
    private int quartoId; // ID do quarto relacionado à manutenção
    private String descricao; // Descrição do tipo de manutenção
    private Boolean status; // Status da manutenção: "pendente", "em progresso", "concluída"
    private String realizadaPor; // Nome do funcionário que realizou a manutenção

    // Lista estática para persistência em memória
    private static List<Manutencao> manutencoes = new ArrayList<>();

    // Construtor
    public Manutencao(int id, int quartoId, String descricao, Boolean status, String realizadaPor) {
        this.id = id;
        this.quartoId = quartoId;
        this.descricao = descricao;
        this.status = status;
        this.realizadaPor = realizadaPor;
    }

    // Métodos de persistência

    // Adicionar uma manutenção
    public static void adicionarManutencao(Manutencao manutencao) {
        manutencoes.add(manutencao);
        System.out.println("Manutenção adicionada: " + manutencao);
    }

    // Listar todas as manutenções
    public static List<Manutencao> listarManutencoes() {
        return manutencoes;
    }


    // Remover manutenção por ID
    public static boolean removerManutencao(int quartoId) {
        return manutencoes.removeIf(manutencao -> manutencao.getQuartoId() == quartoId);
    }
    
    public static List<Manutencao> verificarManutencaoPorQuarto(int quartoId) {
    List<Manutencao> manutencoesPendentes = new ArrayList<>();
    for (Manutencao manutencao : manutencoes) {
        if (manutencao.getStatus() && manutencao.getQuartoId() == quartoId) { // Verifica status e quartoId
            manutencoesPendentes.add(manutencao);
        }
    }
    return manutencoesPendentes;
}

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(int quartoId) {
        this.quartoId = quartoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRealizadaPor() {
        return realizadaPor;
    }

    public void setRealizadaPor(String realizadaPor) {
        this.realizadaPor = realizadaPor;
    }

    @Override
    public String toString() {
        return "Manutencao {" +
                "id=" + id +
                ", quartoId=" + quartoId +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", realizadaPor='" + realizadaPor + '\'' +
                '}';
    }
}