package com.coffeecode.ecommerce.model;

public class Pix extends FormaPagamento implements ProcessadorPagamento {
    private final String chave;

    @Override
    public boolean processar(BigDecimal valor) {
        System.out.println("Enviando cobrança Pix para a chave " + chave);
        return true; // aprovação imediata
    }

    @Override
    public String getComprovante() {
        return "PIX-" + System.currentTimeMillis();
    }

    @Override
    public String getDescricao() {
        return "Pix - chave " + chave;
    }
}