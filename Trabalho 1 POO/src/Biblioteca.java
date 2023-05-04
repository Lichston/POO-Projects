import java.util.ArrayList;

public class Biblioteca{

    private ArrayList<Livro> livros = new ArrayList<>(0);


    //Método que adiciona um livro ao ArrayList, caso não haja um código ISBN repetido
    public boolean cadastraLivro(Livro livro){

        for(int x = 0; x<livros.size(); x++){

            Livro aux = livros.get(x);

            if(aux.getIsbn().equals(livro.getIsbn()) == true){

                return false;
                
            }

        }
        
        return livros.add(livro);


    }


    //Método que busca e retorna um livro pelo código ISBN
    public Livro pesquisaLivro(String isbn){

        Livro aux;
        
        for (int x = 0; x<livros.size(); x++){
            
            aux = livros.get(x);

            if (aux.getIsbn().equals(isbn) == true){

                return aux;
                
            }
            

        }
       
        return null;
    }

    //Método que busca e retorna um ArrayList de livros pelo ano
    public ArrayList<Livro> pesquisaLivro(int ano){

        ArrayList<Livro> livrosAno = new ArrayList<>();

        for(int x=0;x<livros.size(); x++){

            int aux = livros.get(x).getAno();

            if (aux == ano){

                livrosAno.add(livros.get(x));
            }


        }

        return livrosAno;

    }

    // Método que retorna uma String com o padrão de um livro
    public String toString(Livro livro){
        if (livro != null){
        return ("1;" + livro.getIsbn() + ";" + livro.getTitulo() + ";" + livro.getAno() );
        }
        else
        return "o livro não foi cadastrado";
    }

    // Método que retorna a quantidade de livros cadastrados no sistema;
    public ArrayList<Livro> todosLivros(){
        
        return livros;

    }
}