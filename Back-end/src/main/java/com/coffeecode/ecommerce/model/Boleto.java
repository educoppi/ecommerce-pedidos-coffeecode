import com.coffeecode.ecommerce.model.FormaPagamento;

public class Boleto extends FormaPagamento{
    private String codigoDeBarras;

    public Boleto (BigDecimal valor, Date dataDeVencimento, String codigoDeBarras) {
        super(valor, dataDeVencimento);
        setCodigoDeBarras(codigoDeBarras);
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }
}
