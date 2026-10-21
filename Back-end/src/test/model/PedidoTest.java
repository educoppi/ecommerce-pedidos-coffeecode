class PedidoTest {
    private Cliente cliente;
    private Produto notebook;
    private Pedido pedido;

    @BeforeEach
    void prepararCenario() {
        cliente = new Cliente("Ana", "ana@email.com");
        notebook = new Produto("Notebook", new BigDecimal("3000.00"), 5);
        pedido = new Pedido(cliente);
    }

    @Test
    @DisplayName("Deve somar o total corretamente com dois itens")
    void deveSomarTotalComDoisItens() throws Exception {
        pedido.adicionarItem(notebook, 2);
        assertEquals(0, new BigDecimal("6000.00")
                .compareTo(pedido.getValorTotal()));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, -1, -50 })
    @DisplayName("Deve recusar quantidade não positiva")
    void deveRecusarQuantidadeNaoPositiva(int quantidade) {

        assertThrows(IllegalArgumentException.class,
                () -> notebook.baixarEstoque(quantidade));
    }
}