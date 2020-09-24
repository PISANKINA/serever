package lesson3;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    public List<Product> catalog = new ArrayList<>();

    public List<Product> getAllProducts(){
        return catalog;
    } //метод возвращает список из всех продуктов

    public void createProduct(Product product) throws ProductAlreadyExists {  //метод сохраняет в справочнике новый продукт
        if (catalog.contains(product)) throw new ProductAlreadyExists("Product Already Exists"); //Если в справочнике есть
                                                                                                //продукт с таким же именем, выбросить проверяемое исключение
        else catalog.add(product);
    }

    public void updateProduct(Product product) throws ProductNotValid{ //метод обновляет продукт в справочнике.
        List<Long> idis = new ArrayList<>();
        for (Product catalogProduct : catalog){
            idis.add(catalogProduct.getId());
        }

        if (idis.contains(product.getId())) {
            if (product.getName().equals("")) throw new ProductNotValid("Product Now Valid");//Если в новом продукте не
                                                                                            //заполнено поле name, выбросить проверяемое исключение
            catalog.add(idis.indexOf(product.getId()), product);
        //Если продукт с таким идентификатором не существует, выбросить непроверяемое исключение
        }else throw new ProductNotFound("ProductNotFound");
    }

    public void deleteProduct(long id){  //удаляет продукт из справочника
        boolean isRemoved = false;
        for (Product catalogProduct : catalog){
            if (catalogProduct.getId() == id){
                catalog.remove(catalogProduct);
                isRemoved = true;
            }
        }
        if (!isRemoved) throw new ProductNotFound("Product Not Found"); //если подходящий продукт в справочнике не найден,
                                                                        //выбрасывается непроверяемое исключение
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

