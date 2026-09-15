import java.math.BigDecimal;

import com.coffeecode.ecommerce.model.FormaPagamento;

public class Pix extends FormaPagamento {
    private String chave;

    public Pix (BigDecimal valor, Date dataDeVencimento, String chave) {
        super(valor, dataDeVencimento);
        setChave(chave);
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
}