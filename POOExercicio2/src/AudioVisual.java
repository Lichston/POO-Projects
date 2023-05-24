abstract class AudioVisual implements Cobravel {

    private String titulo;
    private double precoBase;

    


    public AudioVisual(String titulo, double precoBase) {
        this.titulo = titulo;
        this.precoBase = precoBase;
    }
    

    @Override
    public double calculaPrecoVenda() {
       
        return precoBase;
    }

    @Override
    public double calculaImposto() {
    
        return calculaPrecoVenda();
    }

    public String getTitulo() {
        return titulo;
    }

    //método utilizado para o passo 2
    @Override
    public String toString() {
        return ("2;" + titulo + ";");
    }

    
    

    
}
