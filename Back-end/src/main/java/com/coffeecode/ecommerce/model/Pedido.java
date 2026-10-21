package com.coffeecode.ecommerce.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.coffeecode.ecommerce.model.pagamento.ProcessadorPagamento;

public class Pedido {

    private final String numero;
    private final Cliente cliente;
    private final List<ItemPedido> itens = new ArrayList<>();
    private FormaPagamento formaPagamento;
    // Observação: Notei que estas variáveis abaixo são usadas no seu método pagar(), 
    // certifique-se de que elas estejam declaradas assim na sua classe original:
    private SituacaoDoPedido situacao; 
    private String comprovante; 

    public Pedido(String numero, Cliente cliente) {
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número do pedido é obrigatório");
        }
        this.cliente = Objects.requireNonNull(cliente, "Pedido exige um cliente");
        this.numero = numero;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        Objects.requireNonNull(produto, "Produto é obrigatório");

        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero");
        }
        if (!produto.temEstoqueDisponivel(quantidade)) {
            throw new IllegalStateException("Estoque insuficiente: " + produto.getNome());
        }

        itens.add(new ItemPedido(produto, quantidade, produto.getPreco()));
    }

    public boolean pagar(ProcessadorPagamento processador) {
        if (processador == null) {
            throw new IllegalArgumentException("Forma de pagamento é obrigatória");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("Pedido sem itens não pode ser pago");
        }
        boolean aprovado = processador.processar(calcularValorTotal());
        if (aprovado) {
            processador.getComprovante();
        }
        return aprovado;
    }

    public BigDecimal calcularValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            total = total.add(item.calcularSubtotal());
        }
        return total;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    // --- MÉTODO MAIN ADICIONADO ABAIXO PARA EXECUTAR O ARQUIVO ---
    public static void main(String[] args) {
        System.out.println("Programa iniciado com sucesso!");
        
        // Aqui dentro você pode instanciar seus objetos para testar, por exemplo:
        // Cliente cliente = new Cliente("João");
        // Pedido pedido = new Pedido("001", cliente);
        // System.out.println("Pedido criado: " + pedido.getNumero());
    }
}
