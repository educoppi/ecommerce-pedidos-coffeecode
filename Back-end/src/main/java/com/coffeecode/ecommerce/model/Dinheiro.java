package com.coffeecode.ecommerce.model;

public class Dinheiro implements ProcessadorPagamento {
    private final BigDecimal valorRecebido;

    @Override
    public boolean processar(BigDecimal valor) {
        return valorRecebido.compareTo(valor) >= 0;
    }

    @Override
    public String getComprovante() {
        return "RECIBO-" + System.currentTimeMillis();
    }

    @Override

    public String getDescricao() {
        return "Dinheiro";
    }
}