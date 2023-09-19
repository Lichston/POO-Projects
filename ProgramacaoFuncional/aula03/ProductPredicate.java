package aula03;

import java.util.function.Predicate;

import aula01.Product;

public class ProductPredicate implements Predicate<Product>{

    @Override
    public boolean test(Product p) {
        // TODO Auto-generated method stub
        return p.getPrice() >= 100;
    }
    
}
