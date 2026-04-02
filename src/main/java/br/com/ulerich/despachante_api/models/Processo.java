package br.com.ulerich.despachante_api.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "processos")
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_processo;

    private String tipo_servico; // Ex: Licenciamento 2026, Transferência
    private String status_atual; // Ex: Aguardando Pagamento, No Detran, Concluído
    private LocalDate data_entrada; // Salva a data exata que o serviço começou

    // Mágica da conexão: Todo processo é vinculado a um carro específico!
    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    // Construtor vazio (obrigatório)
    public Processo() {
    }

    // Getters e Setters
    public Long getId_processo() {
        return id_processo;
    }

    public void setId_processo(Long id_processo) {
        this.id_processo = id_processo;
    }

    public String getTipo_servico() {
        return tipo_servico;
    }

    public void setTipo_servico(String tipo_servico) {
        this.tipo_servico = tipo_servico;
    }

    public String getStatus_atual() {
        return status_atual;
    }

    public void setStatus_atual(String status_atual) {
        this.status_atual = status_atual;
    }

    public LocalDate getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(LocalDate data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}