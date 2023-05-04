import java.util.ArrayList;

public class Grupo {

    private ArrayList<Autor> autores;

    public Grupo(){
        autores = new ArrayList<>(0);
    }
    
    public boolean cadastraAutor(Autor autor){
        Autor aux;
        for(int x = 0;x<autores.size();x++){

            aux = autores.get(x);

                if (aux.getCodigo() == autor.getCodigo()){

                    return false;
                }        

        }

        return autores.add(autor);

    }

    public Autor pesquisaAutor(int codigo){
        
        for(int x = 0; x<autores.size();x++){

            Autor aux = autores.get(x);

                if (aux.getCodigo() == codigo){

                    return aux;

                }
            }

        return null;

    }

    public ArrayList<Autor> autoresCadastrados(){

        return autores;

    }


}
