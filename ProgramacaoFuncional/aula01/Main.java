package aula01;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        List<Product> list = new ArrayList<>();


        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        Comparator<Product> comp = (p1, p2) -> {

            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

        };

        // OU

        Comparator<Product> comp2 = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        
        
        // Inner class
        new Comparator<Product>(){
            
            @Override
            public int compare(Product p1, Product p2) {
                // TODO Auto-generated method stub
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            }

        };


        list.sort(new MyComparator());
        list.sort(comp);
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));



        for(Product p: list){
            System.out.println(p);
        }


    }

}
