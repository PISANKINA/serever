package lesson3;

public class Product {
    private long id;
    private String name;
    private int count;
    private String quality;

    Product(long id, String name, int count, String quality){
        this.id = id;
        this.name = name;
        this.count = count;
        this.quality = quality;
    }
    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getCount(){
        return count;
    }

    public String getQuality(){
        return quality;
    }

    public void productInformation(){
        System.out.println("Номер: " + id + "   Наименование: " + name + "   Количество: " + count
                + "  Качество: " + quality);
    }
}
