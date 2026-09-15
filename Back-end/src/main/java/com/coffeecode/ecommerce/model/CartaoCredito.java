import com.coffeecode.ecommerce.model.FormaPagamento;

public class CartaoCredito {
    private String numeroDoCartao;

    public CartaoCredito (BigDecimal valor, Date dataDeVencimento, String numeroDoCartao) {
        super(valor, dataDeVencimento);
        setNumeroDoCartao(numeroDoCartao);
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }
}