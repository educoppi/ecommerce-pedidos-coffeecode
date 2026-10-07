package com.coffeecode.ecommerce.model;

import java.math.BigDecimal;
import java.util.Date;

import com.coffeecode.ecommerce.model.pagamento.ProcessadorPagamento;

public class Dinheiro extends FormaPagamento implements ProcessadorPagamento {
    private final BigDecimal valorRecebido;

    public Dinheiro (BigDecimal valor, Date dataDeVencimento, BigDecimal valorRecebido) {
        super(valor, dataDeVencimento);
        this.valorRecebido = valorRecebido;
    }

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

    public BigDecimal calcularTroco(BigDecimal valorDaCompra) {
        BigDecimal troco = valorRecebido.subtract(valorDaCompra);
        

        if (troco.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO; 
        }
        
        return troco;
    }
}