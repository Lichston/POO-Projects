import java.text.*;

public class Game extends AudioVisual {    
    //classe enum foi programada dentro da área de atributos
    private enum Categoria{

        ACAO("ACAO", 0.2), ESPORTE("ESPORTE", 0.3), ESTRATEGIA("ESTRATEGIA", 0.4), SIMULACAO("SIMULACAO", 0.5), RPG("RPG", 0.7);

        double porcentagem;
        private Categoria(String categoria, double porcentagem){
            this.porcentagem = porcentagem;
        }



        public double getPorcentagem() {
            return porcentagem;
        }

    }
    //atributo que vai receber o conteúdo correspondente a categoria
    private Categoria categoriaEnum;

    public Game(String titulo, double precoBase, String categoria) {        
        super(titulo, precoBase);
        categoriaEnum = Categoria.valueOf(categoria);
    }


    @Override
    public double calculaPrecoVenda() {        
        double preco = super.calculaPrecoVenda();
        return (super.calculaPrecoVenda() + (preco * categoriaEnum.getPorcentagem()));
    }


    @Override
    public double calculaImposto() {
        return (super.calculaImposto() * 0.5);        
    }

    //padronização para o passo 2 da classe Game
    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return super.toString() + formatter.format(calculaPrecoVenda()) + ";" + formatter.format(calculaImposto());
    }    
    
}
