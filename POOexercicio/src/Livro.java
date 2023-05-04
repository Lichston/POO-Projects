import java.util.ArrayList;

public class Livro{
    private String isbn;
    private String titulo;
    private int ano;
    private ArrayList<String> autoresDoLivro;

    public Livro(String isbn, String titulo, int ano){
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
        autoresDoLivro = new ArrayList<>(0);
        
    }

    public boolean adicionaAutor(Autor autor){

        return autoresDoLivro.add(autor.getNome()); 

    }

    public ArrayList<String> pesquisaAutores(){

        return autoresDoLivro;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitulo(){
        return titulo;
    }
    
    public int getAno(){
        return ano;
    }

    

}