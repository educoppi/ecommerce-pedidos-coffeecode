class PedidoFluxoIT {
    private Cliente cliente;
    private Produto notebook;

    @BeforeEach
    void prepararCenario() {
        cliente = new Cliente("Ana", "ana@email.com");
        notebook = new Produto("Notebook", new BigDecimal("3000.00"), 5);
    }

    @Test
    @DisplayName("Deve criar, somar e pagar um pedido, baixando o estoque")
    void deveExecutarFluxoCompletoDePedido() throws Exception {
        Pedido pedido = new Pedido(cliente); // Arrange
        pedido.adicionarItem(notebook, 2); // Act
        pedido.pagar(new Pix(new BigDecimal("6000.00"), "ana@email.com"));
        assertAll( // Assert
                () -> assertEquals(0, new BigDecimal("6000.00")
                        .compareTo(pedido.getValorTotal())),
                () -> assertEquals(SituacaoPedido.PAGO, pedido.getSituacao()),
                () -> assertEquals(3, notebook.getQuantidadeEmEstoque()),
                () -> assertEquals(1, pedido.getItens().size()));
    }

}