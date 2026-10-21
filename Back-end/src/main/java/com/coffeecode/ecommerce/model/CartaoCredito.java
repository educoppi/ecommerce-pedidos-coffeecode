package com.coffeecode.ecommerce.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import com.coffeecode.ecommerce.model.pagamento.ProcessadorPagamento;

public class CartaoCredito extends FormaPagamento implements ProcessadorPagamento {
    private String numeroDoCartao;

    public CartaoCredito(BigDecimal valor, Date dataDeVencimento, String numeroDoCartao) {
        super(valor, dataDeVencimento);
        setNumeroDoCartao(numeroDoCartao);
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

 
    @Override
    public String getComprovante() {
        String ultimosDigitos = numeroDoCartao.length() > 4
                ? numeroDoCartao.substring(numeroDoCartao.length() - 4)
                : numeroDoCartao;

        return "Comprovante gerado com sucesso. Cartão final: " + ultimosDigitos;
    }
 
    @Override
    public String getDescricao() {
        return "Pagamento efetuado via Cartão de Crédito";
    }

    public BigDecimal calcularValorParcela(int quantidadeParcelas) {
        if (quantidadeParcelas <= 0) {
            throw new IllegalArgumentException("A quantidade de parcelas deve ser maior que zero.");
        }

        BigDecimal valorTotal = getValor();

        return valorTotal.divide(new BigDecimal(quantidadeParcelas), 2, RoundingMode.HALF_UP);
    }


    @Override
    public boolean processar(BigDecimal valor) {
        throw new UnsupportedOperationException("Unimplemented method 'processar'");
    }

}