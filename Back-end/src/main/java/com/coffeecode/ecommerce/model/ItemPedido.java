package com.coffeecode.ecommerce.model;

import java.math.BigDecimal;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private BigDecimal precoPraticado;

    // Construtor que utiliza os métodos set para inicializar os atributos
    public ItemPedido(Produto produto, int quantidade, BigDecimal precoPraticado) {
        setProduto(produto);
        setQuantidade(quantidade);
        setPrecoPraticado(precoPraticado);
    }


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoPraticado() {
        return precoPraticado;
    }



    public void setPrecoPraticado(BigDecimal precoPraticado) {
        if (precoPraticado.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O preço praticado não pode ser negativo.");
        }
        this.precoPraticado = precoPraticado;
    }

    public BigDecimal calcularSubtotal() {
        return this.precoPraticado.multiply(BigDecimal.valueOf(this.quantidade));
    }
}