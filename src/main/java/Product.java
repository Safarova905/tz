import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Product {
    private String name;
    private String price;
    private String sale;

    public Product(String name, String price, String sale) {
        this.name = name;
        this.price = price;
        this.sale = sale;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getSale() {
        return sale;
    }
    public void setSale(String sale) {
        this.sale = sale;
    }
 @Override
    public String toString() {
        return "name= " + name + "," + "price= " + price + "," + "sale= " + sale;
    }
}
