package com.coffeecode.ecommerce.model;

import java.math.BigDecimal;

// Modelo da classe Produto
public class Produto {
    private String codigo;
    private String nome;
    private String descricao;
    private BigDecimal preco; // Alterado para BigDecimal para alinhar com a classe Pedido
    private int quantidadeEmEstoque;
    private boolean ativo;

    public Produto() {
        this.ativo = true;
    }

    public Produto(String codigo, String nome, double preco, int estoque) {
        setCodigo(codigo);
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(estoque);
        this.ativo = true;
    }

    public String getCodigo() {
        return codigo;
    }

    // Criado o método setCodigo que estava faltando no construtor
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    // Sobrecarga para aceitar double no construtor e converter para BigDecimal
    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo: " + preco);
        }
        this.preco = BigDecimal.valueOf(preco);
    }

    public void setPreco(BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço não pode ser nulo ou negativo");
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
        this.quantidadeEmEstoque = quantity;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean temEstoqueDisponivel(int quantidadeDesejada) {
        return ativo && this.quantidadeEmEstoque >= quantidadeDesejada;
    }

    // Se a classe EstoqueInsuficienteException ainda não existir no seu projeto, 
    // comente este método ou crie a respectiva Exception.
    public void baixarEstoque(int quantidade) throws Exception {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva.");
        }
        if (quantidade > this.quantidadeEmEstoque) {
            throw new Exception("Estoque insuficiente para o produto: " + nome);
        }
        this.quantidadeEmEstoque -= quantidade;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - R$ %s (%d em estoque)",
                codigo, nome, preco != null ? preco.toString() : "0.00", quantidadeEmEstoque);
    }

    // --- MÉTODO MAIN ADICIONADO ABAIXO PARA EXECUTAR O ARQUIVO ---
    public static void main(String[] args) {
        System.out.println("Classe Produto executada com sucesso!");
        
        // Exemplo de teste da classe:
        Produto produto = new Produto("P001", "Café Espresso", 8.50, 20);
        System.out.println("Produto criado: " + produto);
    }
}
