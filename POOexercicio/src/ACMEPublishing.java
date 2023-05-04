import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;



public class ACMEPublishing{

    private Scanner entrada;
    // Construtor
    public ACMEPublishing() {
        entrada = new Scanner(System.in);
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dados.txt"));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        entrada.useLocale(Locale.ENGLISH);
    }

    public void executar(){

        Biblioteca biblioteca = new Biblioteca();
        Grupo grupo = new Grupo();
        // Atributos do livro.
        String isbn = "0", titulo ;
        int ano;
        // Atributos do autor.
        String nome;
        int codigo;
        // Variável para troca de passos.
        String parada = "-1";
        // contador.
        int x = 0;

        // PASSO 1 - CADASTRAR LIVROS E MOSTRAR OS LIVROS CADASTRADOS.
        
        do{

            isbn = entrada.nextLine();

            if(isbn.equals(parada) == false ){

                
                titulo = entrada.nextLine();
                ano = entrada.nextInt();
    
                
                if(biblioteca.cadastraLivro(new Livro(isbn, titulo, ano)) == true ){
                
                
                    Livro auxLivro = new Livro(isbn, titulo, ano);

                    System.out.println("1;" + auxLivro.getIsbn() + ";" + auxLivro.getTitulo() + ";" + auxLivro.getAno() + ";");

                }
                
                else{
                    System.out.println("O livro não foi cadastrado, verifique se o código não ISBN do livro não foi cadastrado anteriormente.");
                }
                
            
                entrada.nextLine();
            }

            else
                //PASSO 2 - PRINTAR O TAMANHO DO ARRAYLIST DE LIVROS.
                System.out.println("2;" + biblioteca.todosLivros().size());
            
            
            
        }while(isbn.equals(parada) == false );


        

        //PASSOS 3 & 4.
        do{
            codigo = entrada.nextInt();
            
            //PASSO 3 - CADASTRAR OS AUTORES E MOSTRAR OS AUTORES CADASTRADOS.

            if(codigo != -1 ){

                entrada.nextLine();
                
                nome = entrada.nextLine();
                isbn = entrada.nextLine();

                Livro aux = biblioteca.pesquisaLivro(isbn);


                if (grupo.cadastraAutor(new Autor(codigo, nome, aux)) == true) {

                     Autor auxAutor = (new Autor(codigo, nome, aux));
                     
                     System.out.println("3;" + auxAutor.getCodigo() + ";" + auxAutor.getNome() + ";" + isbn);
                     aux.adicionaAutor(auxAutor);

                }     
                else{
                    System.out.println("O Autor não foi cadastrado, verifique se o código do autor já foi cadastrado anteriormente.");
                }
            
                

            }

            //PASSO 4 - PRINTAR O TAMANHO DO ARRAYLIST DE AUTORES.

            else{

                System.out.println("4;" + grupo.autoresCadastrados().size());

            }

            
        }while(codigo != (-1) );
        
        //PASSO 5 - ADICIONAR LIVRO A UM AUTOR E MOSTRAR NA TELA O AUTOR E LIVRO VINCULADOS.
        do{

            codigo = entrada.nextInt();

            if(codigo != (-1)){

                entrada.nextLine();

                isbn = entrada.nextLine();
                Livro auxLivro = biblioteca.pesquisaLivro(isbn);


                if(biblioteca.pesquisaLivro(isbn).adicionaAutor(grupo.pesquisaAutor(codigo)) == true &&
                grupo.pesquisaAutor(codigo).adicionaLivro(biblioteca.pesquisaLivro(isbn)) == true){
                    

                    auxLivro = grupo.pesquisaAutor(codigo).pesquisaLivros().get(x);

                    System.out.println("5;" + grupo.pesquisaAutor(codigo).printLivro(auxLivro));

                    x++;

                }



            }


        }while(codigo != (-1) );
        
        //PASSO 6 - MOSTRAR TODOS OS LIVROS DE UM DETERMINADO CÓDIGO DE AUTOR

        codigo = entrada.nextInt();
        Autor auxAutor = grupo.pesquisaAutor(codigo);

            if(auxAutor.pesquisaLivros().size() == 1){

                System.out.println( "6;" + auxAutor.printLivro(auxAutor.pesquisaLivros().get(0)));

            }

            else{


                for(int a = 0; a<auxAutor.pesquisaLivros().size() ;a++){

                    Livro auxLivro = auxAutor.pesquisaLivros().get(a);

        

                    System.out.println( "6;" + auxAutor.printLivro(auxLivro));


            }

        }
            // PASSO 7 - LER UM ISBN E MOSTRAR TODOS OS AUTORES DO LIVRO.

            entrada.nextLine();
            isbn = entrada.nextLine();
            Livro auxLivro = biblioteca.pesquisaLivro(isbn);
            System.out.print("7;" + isbn);


            for(int i = 0; i<auxLivro.pesquisaAutores().size(); i++){
            
            
                System.out.print(";" + auxLivro.pesquisaAutores().get(i));


            }

            System.out.println();

            // PASSO 8 - MOSTRAR TODOS OS LIVROS COM MAIS DE UM AUTOR.
            
            for(int i = 0; i<biblioteca.todosLivros().size(); i++){
                
                if(biblioteca.todosLivros().get(i).pesquisaAutores().size()>1){

                    System.out.println("8;" + biblioteca.todosLivros().get(i).getIsbn() + ";" + biblioteca.todosLivros().get(i).getTitulo());

                }

            }

            // PASSO 9 - MOSTRAR TODOS OS AUTORES COM MAIS DE UM LIVRO.

            for(int i = 0; i<grupo.autoresCadastrados().size(); i++){

                if(grupo.autoresCadastrados().get(i).pesquisaLivros().size()>1){

                    System.out.print( "9;" + grupo.autoresCadastrados().get(i).getNome());

                    for(int c = 0; c<grupo.autoresCadastrados().get(i).pesquisaLivros().size(); c++){

                    System.out.print( ";" + grupo.autoresCadastrados().get(i).pesquisaLivros().get(c).getIsbn());

                    }

                }

            }

            // PASSO 10 - LER UM ANO E MOSTRAR TODOS OS LIVROS CADASTRADOS COM O MESMO ANO;

            //Println para ir para próxima linha
            System.out.println();

            ano = entrada.nextInt();

            for(int z = 0; z<biblioteca.pesquisaLivro(ano).size(); z++){

                auxLivro = biblioteca.pesquisaLivro(ano).get(z);

                System.out.println("10;" + auxLivro.getIsbn() + ";" + auxLivro.getTitulo() + ";" + auxLivro.getAno());
            }



    }

    public void menu(){

         

    }



}