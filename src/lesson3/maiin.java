package lesson3;

public class maiin {
    public static void main(String[] args){
        Product name1 = new Product(1, "футболка", 10, "хлопок");
        Product name2 = new Product(2, "кофта   ", 5 , "синтетика");
        Product name3 = new Product(3, "свитер  ", 14, "шерсть");
        Product name4 = new Product(4, "майка   ", 23, "хлопок");
        ProductCatalog catalog = new ProductCatalog();
        try {
            catalog.createProduct(name1);
            catalog.createProduct(name2);
            catalog.createProduct(name3);
            catalog.createProduct(name4);
        } catch (ProductAlreadyExists productAlreadyExists) {
            productAlreadyExists.printStackTrace();
        }
        for (Product product: catalog.getAllProducts()){
            product.productInformation();
            System.out.println();
        }
    }
}
