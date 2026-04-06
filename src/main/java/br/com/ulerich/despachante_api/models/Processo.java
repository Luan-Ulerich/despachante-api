package br.com.ulerich.despachante_api.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "processos")
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_processo;

    @NotBlank(message = "O tipo de serviço é obrigatório (Ex: Transferência, 1º Emplacamento)")
    private String tipo_servico;

    @NotBlank(message = "O status atual é obrigatório (Ex: Aguardando Pagamento, Em Análise)")
    private String status_atual;

    private LocalDate data_entrada;

    @NotNull(message = "O processo deve obrigatoriamente estar vinculado a um veículo")
    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;


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

    @jakarta.persistence.PrePersist
    public void preencherDataAutomaticamente() {
        this.data_entrada = LocalDate.now();
    }
}