package com.impacta.microservices.contacorrente.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Debito implements Serializable {

    private Integer contaId;
    private BigDecimal debito;

    public Debito() {}

    public Debito(BigDecimal debito) {
        this.debito = debito;
    }

    public BigDecimal getDebito() {
        return debito;
    }

    public void setDebito(BigDecimal debito) {
        this.debito = debito;
    }

    public Integer getContaId() {return contaId;}

    public void setContaId(Integer contaId) {this.contaId = contaId;}

}
