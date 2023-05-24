import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.*;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class Acervo{
    //Atributos
    private String[] categoria;
    private ArrayList<AudioVisual> itens;
    private int quantidadeRPG;


    public Acervo() {
        itens = new ArrayList<>(5);
        quantidadeRPG = 0;
        //Array de String para verificar se a categoria lida existe
        categoria = "ACAO;ESPORTE;ESTRATEGIA;SIMULACAO;RPG".split(";");
    }

    //método que realiza toda leitura do arquivo
    public boolean leArquivo() throws Exception {

        Path path = Paths.get("dados.csv");

        try (BufferedReader br = Files.newBufferedReader(path, Charset.forName("UTF8"))) {
            String linha = null;
            
            br.readLine();
            while ((linha = br.readLine()) != null) {

                try{
                    
                    Scanner sc = new Scanner(linha).useDelimiter(";");
                    String titulo = sc.next();
                    Double precobase = Double.parseDouble(sc.next());
                    int tipo = Integer.parseInt(sc.next());

                    if(tipo == 1){

                        int duracao_categoria = Integer.parseInt(sc.next());
                        AudioVisual a = new BluRay(titulo, precobase, duracao_categoria);
                        itens.add(a);
                        
                    }
                    else if(tipo == 2){

                        String duracao_categoria = sc.next();

                        for (String cat: categoria ){
                            
                            if(cat.equals(duracao_categoria) && duracao_categoria.equals("RPG")){

                                AudioVisual novo = new Game(titulo, precobase, duracao_categoria);
                                itens.add(novo);
                                quantidadeRPG++;

                            }
                            else if(cat.equals(duracao_categoria)){

                                AudioVisual novo = new Game(titulo, precobase, duracao_categoria);
                                itens.add(novo);
                            }

                        }
                    
                    }

                    sc.close();
                    
                }
                catch(Exception a){

                    
                    System.err.format("Erro de entrada ", a);
                    System.out.println(a.getMessage()); 
                     
                    
                }
                
                
                

            }
           
        }
        catch (Exception e) {

            System.setErr(null);
                                    
        }
        
        return false;
    
    }

    //método que realiza a escrita dos objetos para o arquivo CSV, conforme os critérios solicitados
    public boolean escreveObjetos() throws Exception{

        Path path = Paths.get("resultado.csv");
        try (BufferedWriter br = Files.newBufferedWriter(path, Charset.forName("UTF8"))) {

            br.write("1;" + itens.size());
            br.newLine();

            for (AudioVisual item: itens ) {

                br.write(item.toString());
                br.newLine();

            }

            br.write("3;" + quantidadeRPG);
            br.newLine();            

            if (calculaMediaMaisProxima() != null){
                DecimalFormat formatter = new DecimalFormat("#0.00");                
                br.write("4;" + formatter.format(calculaMedia()) + ";" + calculaMediaMaisProxima().getTitulo() );
            }

            else{
                br.write("4;Nenhum Bluray cadastrado");;
            }
            
                                        
        }

        catch( Exception e){

            throw new Exception(e.getMessage());
            
        }

            return false;
        }
        
        //método necessário para realizar o calculo da média dos impostos BluRay, necessário para o passo 4
        public double calculaMedia(){

            int cont = 0;
            double soma = 0;
            double media = 0;

            for (AudioVisual item: itens){

                if(item instanceof BluRay){

                    soma = soma + item.calculaImposto();
                    cont++;

                }

            }

            media = (soma / cont);

            return media;


        }

        //método utilizado para achar o BluRay com o imposto mais próximo da média
        public AudioVisual calculaMediaMaisProxima(){

            AudioVisual aux = null;
            double media = calculaMedia();
            double mediaMaisProxima = media;

            for (AudioVisual item: itens){

                if(item instanceof BluRay){

                    if(item.calculaImposto() >= media && (item.calculaImposto() - media) < mediaMaisProxima){
                        mediaMaisProxima = (item.calculaImposto() - media);
                        aux = item;
                    }

                    else if(item.calculaImposto() < media && (media - item.calculaImposto()) < mediaMaisProxima ){
                        mediaMaisProxima = (media - item.calculaImposto());
                        aux = item;
                        
                    }

                }

            }
            
            return aux;

        }
            
        

    }

    

