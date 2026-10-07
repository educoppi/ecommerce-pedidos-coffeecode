package com.coffeecode.ecommerce.model;

import org.junit.jupiter.api.*;

import com.coffeecode.ecommerce.excecao.EstoqueInsuficienteException;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

class ProdutoTest {
    private Produto notebook;

    @BeforeEach
    void prepararCenario() {
        notebook = new Produto("131313", "Notebook", new BigDecimal("3000.00"), 5);
    }

    @Test
    @DisplayName("Deve baixar o estoque quando há quantidade suficiente")
    void deveBaixarEstoqueQuandoHaQuantidadeSuficiente() throws Exception {
        notebook.baixarEstoque(2); // Act
        assertEquals(3, notebook.getQuantidadeEmEstoque()); // Assert
    }

    @Test
    @DisplayName("Deve lançar exceção quando o estoque é insuficiente")
    void deveLancarExcecaoQuandoEstoqueInsuficiente() {

        EstoqueInsuficienteException erro = assertThrows(
                EstoqueInsuficienteException.class,
                () -> notebook.baixarEstoque(50));
                
        assertEquals(50, erro.getQuantidadeSolicitada());
        assertTrue(erro.getMessage().contains("Notebook"));
        assertEquals(5, notebook.getQuantidadeEmEstoque());
    }
}