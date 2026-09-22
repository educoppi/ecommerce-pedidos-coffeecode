package com.coffeecode.ecommerce.model;

public class Pix extends FormaPagamento implements ProcessadorPagamento {
    private final String chave;

    public Pix(String chave) {
        super(valor, dataDeVencimento);
        this.chave = chave;
    }

    @Override
    public boolean processar(BigDecimal valor) {
        System.out.println("Enviando cobrança Pix para a chave " + chave);
        return true;
    }

    @Override
    public String getComprovante() {
        return "PIX-" + System.currentTimeMillis();
    }

    @Override
    public String getDescricao() {
        return "Pix - chave " + chave;
    }

    public BigDecimal calcularValorParcela(int quantidadeParcelas) {
        if (quantidadeParcelas <= 0) {
            throw new IllegalArgumentException("A quantidade de parcelas deve ser maior que zero.");
        }

        BigDecimal valorTotal = getValor(); 

        return valorTotal.divide(new BigDecimal(quantidadeParcelas), 2, RoundingMode.HALF_UP);
    }
}