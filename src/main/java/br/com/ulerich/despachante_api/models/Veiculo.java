package br.com.ulerich.despachante_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_veiculo;

    private String placa;
    private String renavam;
    private String modelo_ano; // Ex: "Onix 2020"

    // Aqui acontece a mágica da conexão entre as tabelas!
    // @ManyToOne significa "Muitos veículos podem pertencer a Um cliente"
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // Construtor vazio (obrigatório)
    public Veiculo() {
    }

    // Getters e Setters
    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getModelo_ano() {
        return modelo_ano;
    }

    public void setModelo_ano(String modelo_ano) {
        this.modelo_ano = modelo_ano;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}