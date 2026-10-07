package com.coffeecode.ecommerce.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PedidoTest {
    private Cliente cliente;
    private Produto notebook;
    private Pedido pedido;

    @BeforeEach
    void prepararCenario() {
        cliente = new Cliente("Ana", "ana@email.com");
        notebook = new Produto("31313", "Notebook", new BigDecimal("3000.00"), 5);
        pedido = new Pedido("1", cliente);
    }

    @Test
    @DisplayName("Deve somar o total corretamente com dois itens")
    void deveSomarTotalComDoisItens() throws Exception {
        pedido.adicionarItem(notebook, 2);
        assertEquals(0, new BigDecimal("6000.00")
                .compareTo(pedido.calcularValorTotal()));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -50 })
    @DisplayName("Deve recusar quantidade não positiva")
    void deveRecusarQuantidadeNaoPositiva(int quantidade) {

        assertThrows(IllegalArgumentException.class,
                () -> notebook.baixarEstoque(quantidade));
    }
}