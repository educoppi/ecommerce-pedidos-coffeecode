private static final double VALOR_POR_QUILO = 7.50;
private static final double FRETE_MINIMO = 15.00;
private static final double TAXA_DESCONTO = 0.10;
private static final double DESCONTO_MAXIMO = 50.00;
private static final double VALOR_FRETE_GRATIS = 300.00;

private static double calcularDesconto(double valorDoPedido) {
    double desconto = valorDoPedido * TAXA_DESCONTO;
    return Math.min(desconto, DESCONTO_MAXIMO);
}