package com.impacta.microservices.contacorrente.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contacorrente")
public class ContaCorrente implements Serializable {

    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cc")
    private Integer id_cc;

   // @Transient
   // private String porta;

    @Column(name = "conta_id")
    private Integer contaId;

    @Column(name = "saldo")
    private Double saldo;

    @Column(name = "cliente_id")
    private Integer clienteId;

    public ContaCorrente() {
    }

    @JsonCreator
    public ContaCorrente(@JsonProperty("id_cc") Integer id_cc,
                         @JsonProperty("conta_id") Integer contaId,
                         @JsonProperty("cliente_id") Integer clienteId,
                         @JsonProperty("saldo") Double saldo) {
        this.id_cc = id_cc;
        this.contaId = contaId;
        this.clienteId = clienteId;
        this.saldo = saldo;
    }

    public Integer getId_cc() {
        return id_cc;
    }

    public void setId_cc(Integer id_cc) {
        this.id_cc = id_cc;
    }

    public Integer getContaId() {
        return contaId;
    }

    public void setContaId(Integer contaId) {
        this.contaId = contaId;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

}
