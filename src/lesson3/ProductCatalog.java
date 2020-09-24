package lesson3;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    public List<Product> catalog = new ArrayList<>();

    public List<Product> getAllProducts(){
        return catalog;
    }

    public void createProduct(Product product) throws ProductAlreadyExists {
        if (catalog.contains(product)) throw new ProductAlreadyExists("Product Already Exists");
        else catalog.add(product);
    }

    public void updateProduct(Product product) throws ProductNotValid{
        List<Long> idis = new ArrayList<>();
        for (Product catalogProduct : catalog){
            idis.add(catalogProduct.getId());
        }
        if (idis.contains(product.getId())) {
            if (product.getName().equals("")) throw new ProductNotValid("Product Now Valid");
            catalog.add(idis.indexOf(product.getId()), product);

        }else throw new ProductNotFound("ProductNotFound");
    }

    public void deleteProduct(long id){
        boolean isRemoved = false;
        for (Product catalogProduct : catalog){
            if (catalogProduct.getId() == id){
                catalog.remove(catalogProduct);
                isRemoved = true;
            }
        }
        if (!isRemoved) throw new ProductNotFound("Product Not Found");
        }
    }

    class ProductNotFound extends RuntimeException {
        public ProductNotFound(String message) {
            System.out.println(message);
        }
    }
    class ProductAlreadyExists extends Exception {
        public ProductAlreadyExists(String message){
            System.out.println(message);
        }
    }

    class ProductNotValid extends Exception {
        public ProductNotValid(String message){
            System.out.println(message);
        }

    }

