package com.coffeecode.ecommerce.model;

import java.math.BigDecimal;

import com.coffeecode.ecommerce.excecao.EstoqueInsuficienteException;

// Modelo da classe Produto
public class Produto {
    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int quantidadeEmEstoque;
    private boolean ativo;

    public Produto() {
        this.ativo = true;
    }

    public Produto(String codigo, String nome, BigDecimal preco, int estoque) {
        setCodigo(codigo);
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(estoque);
        this.ativo = true;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        if (preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo: " + preco);
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo: " + quantidade);
        }

        this.quantidadeEmEstoque = quantidade;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean temEstoqueDisponivel(int quantidadeDesejada) {
        return ativo && this.quantidadeEmEstoque >= quantidadeDesejada;
    }

    public void baixarEstoque(int quantidade) throws EstoqueInsuficienteException {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
        if (quantidade > this.quantidadeEmEstoque) {
            throw new EstoqueInsuficienteException(this, quantidade);
        }
        this.quantidadeEmEstoque -= quantidade;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - R$ %.2f (%d em estoque)",
                codigo, nome, preco, quantidadeEmEstoque);
    }
}