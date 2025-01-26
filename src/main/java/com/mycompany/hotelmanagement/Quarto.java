/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelmanagement;

import static com.mycompany.hotelmanagement.Manutencao.removerManutencao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavooliveira
 */

public class Quarto 
{
    
    private int id;
    private String tipo;
    private String status; // disponível, ocupado, manutenção
    private int maxCapacidadeHospedes;
    private int numCamas;
    private int numCasasDeBanho;
    private String tipoVista; // exemplo: serra, mar
    private boolean temCozinha;
    private boolean temVaranda;
    private Manutencao manutencao ;
    
    // Lista estática para persistência em memória
    private static List<Quarto> quartos = new ArrayList<>();

    
    // Contrutor - criarQuarto 
    public Quarto(int id, String tipo, String status, int maxCapacidadeHospedes, int numCamas, int numCasasDeBanho, 
                  String tipoVista, boolean temCozinha, boolean temVaranda) 
    {
        this.id = id;
        this.tipo = tipo;
        this.status = status;
        this.maxCapacidadeHospedes = maxCapacidadeHospedes;
        this.numCamas = numCamas;
        this.numCasasDeBanho = numCasasDeBanho;
        this.tipoVista = tipoVista;
        this.temCozinha = temCozinha;
        this.temVaranda = temVaranda;
     }
    
    
    // Método estático para adicionar quartos
    public static void adicionarQuarto(Quarto quarto) 
    {
        quartos.add(quarto);
        System.out.println("Quarto adicionado: " + quarto);
    }
    
    // Listar todos os quartos
    public static List<Quarto> listarQuartos() {
        return quartos;
    }
    
     // Remover um quarto por ID
    public static boolean removerQuarto(int id) {
        
        removerManutencao(id);
        return quartos.removeIf(quarto -> quarto.getId() == id);
    }
    
    public static Quarto retornarQuartoPorId(int id) {
    return quartos.stream()
            .filter(quarto -> quarto.getId() == id)
            .findFirst()
            .orElse(null);
}

    // Getters e Setters - editar quarto 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMaxCapacidadeHospedes() {
        return maxCapacidadeHospedes;
    }

    public void setMaxCapacidadeHospedes(int maxCapacidadeHospedes) {
        this.maxCapacidadeHospedes = maxCapacidadeHospedes;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public int getNumCasasDeBanho() {
        return numCasasDeBanho;
    }

    public void setNumCasasDeBanho(int numCasasDeBanho) {
        this.numCasasDeBanho = numCasasDeBanho;
    }

    public String getTipoVista() {
        return tipoVista;
    }

    public void setTipoVista(String tipoVista) {
        this.tipoVista = tipoVista;
    }

    public boolean isTemCozinha() {
        return temCozinha;
    }

    public void setTemCozinha(boolean temCozinha) {
        this.temCozinha = temCozinha;
    }

    public boolean isTemVaranda() {
        return temVaranda;
    }

    public void setTemVaranda(boolean temVaranda) {
        this.temVaranda = temVaranda;
    }

    @Override
    public String toString() {
        return "Quarto {" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", status='" + status + '\'' +
                ", capacidadeMáxima=" + maxCapacidadeHospedes +
                ", número de camas=" + numCamas +
                ", número de casas de banho=" + numCasasDeBanho +
                ", vista='" + tipoVista + '\'' +
                ", tem cozinha=" + (temCozinha ? "sim" : "não") +
                ", tem varanda=" + (temVaranda ? "sim" : "não") +
                '}';
    }
}
