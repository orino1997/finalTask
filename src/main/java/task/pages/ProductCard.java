package task.pages;

public class ProductCard {
    private String title;
    private int price;

    public ProductCard(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }
}
