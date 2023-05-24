import java.text.*;

public class BluRay extends AudioVisual {

    private int duracao;

    public BluRay(String titulo, double precoBase, int duracao) {
        super(titulo, precoBase);
        this.duracao = duracao;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public double calculaPrecoVenda() {
        
        return ((super.calculaPrecoVenda() * duracao) / 100);

    }


    @Override
    public double calculaImposto() {

        return (super.calculaImposto() * 0.4);

    }

    //padronização para o passo 2 da classe BluRay
    @Override
    public String toString() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return super.toString() + formatter.format(calculaPrecoVenda()) + ";" + formatter.format(calculaImposto());
    }



}
