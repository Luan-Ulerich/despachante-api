package br.com.ulerich.despachante_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_veiculo;

    @NotBlank(message = "A placa é obrigatória")
    @Pattern(regexp = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$", message = "A placa deve estar no padrão antigo (ABC1234) ou Mercosul (ABC1D23) sem traços")
    @Column(unique = true)
    private String placa;

    @NotBlank(message = "O Renavam é obrigatório")
    @Pattern(regexp = "^\\d{11}$", message = "O Renavam deve conter exatamente 11 números")
    @Column(unique = true)
    private String renavam;

    @NotBlank(message = "O modelo e ano são obrigatórios")
    private String modelo_ano;

    @NotNull(message = "O veículo deve obrigatoriamente pertencer a um cliente")
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    public Veiculo() {
    }


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