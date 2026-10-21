package com.coffeecode.ecommerce.model;
public abstract class Pessoa {
    private String nome;
    private String documento;

    public Pessoa(String nome, String documento) {
        setNome(nome);
        setDocumento(documento);
    }

    public Pessoa (String nome) {
        setNome(nome);
    }

    

    public String getNome() {
        return nome;
    }



    public String getDocumento() {
        return documento;
    }



    private void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        this.nome = nome.trim();
    }

    
    
    public abstract String getIdentificacao();
}