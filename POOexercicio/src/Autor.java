import java.util.ArrayList;

public class Autor {

    private int codigo;
    private String nome;
    private Livro livro;
    private ArrayList<Livro> livrosDoAutor;

    public Autor(int codigo, String nome, Livro livro){

        this.codigo = codigo;
        this.nome = nome;
        this.livro = livro;
        livrosDoAutor = new ArrayList<>(0);
        livrosDoAutor.add(livro);
        }

    public boolean adicionaLivro(Livro livro){

        return livrosDoAutor.add(livro);

    }

    public ArrayList<Livro> pesquisaLivros(){

        return livrosDoAutor;

    }

    public String printLivro(Livro livro){

        String stringLivro = this.codigo + ";" +this.nome   + ";" + livro.getIsbn()   + ";" + livro.getTitulo() + ";" + livro.getAno() ;

        return stringLivro;

    }

    public int getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }
    
    public Livro getLivro(){
        return livro;
    }



}
