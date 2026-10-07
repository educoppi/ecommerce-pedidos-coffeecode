package com.coffeecode.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;

public abstract class FormaPagamento {
    private BigDecimal valor;
    private Date dataDeVencimento;

    public FormaPagamento(BigDecimal valor, Date dataDeVencimento) {
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public Date getDataDeVencimento() {
        return this.dataDeVencimento;
    }
}
