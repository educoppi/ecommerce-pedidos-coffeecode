package com.coffeecode.ecommerce.model;
import com.coffeecode.ecommerce.model.Produto;


public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double precoPraticado;

    
    public ItemPedido(Produto produto, int quantidade, double precoPraticado) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoPraticado = precoPraticado;
    }


    public Produto getProduto() {
        return produto;
    }


    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public double getPrecoPraticado() {
        return precoPraticado;
    }


    public void setPrecoPraticado(double precoPraticado) {
        this.precoPraticado = precoPraticado;
    }

    public double calcularSubtotal() {
        return this.precoPraticado * this.quantidade; 
    }
}