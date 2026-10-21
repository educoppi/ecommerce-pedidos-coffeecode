@ExtendWith(MockitoExtension.class)
class PagamentoFluxoIT {
    @Mock
    GatewayPagamento gateway;
    @InjectMocks
    ServicoPedido servico;

    @Test
    @DisplayName("Deve marcar o pedido como pago quando o gateway aprova")
    void deveMarcarPedidoComoPagoQuandoGatewayAprova() throws Exception {
        when(gateway.cobrar(any(BigDecimal.class))).thenReturn(true);
        Pedido pedido = servico.finalizar(pedidoComDoisItens());
        assertEquals(SituacaoPedido.PAGO, pedido.getSituacao());
        verify(gateway).cobrar(new BigDecimal("6000.00"));
    }

    @Test
    @DisplayName("Deve manter o pedido aberto quando o gateway recusa")
    void deveManterPedidoAbertoQuandoGatewayRecusa() {
        when(gateway.cobrar(any())).thenReturn(false);
        assertThrows(PagamentoRecusadoException.class,
                () -> servico.finalizar(pedidoComDoisItens()));

        verify(gateway, never()).emitirComprovante(any());
    }
}