import java.util.LinkedList;

public class ProductList implements IPrintable
{
    /*Constructor*/
    public ProductList() {
        list = new LinkedList<Product>();
    }

    /*Members*/
    LinkedList<Product> list;

    /*Get methods*/
    public Product getProduct(String id) {}
    public int getTotalQuantity() {}
    public int getQuantity(String id) {}

    /*Set methods*/
    /*Other methods*/
    public void addProduct(String id) {}
    public void addProduct(Product product) {}
    public void removeProduct(String id) {}
    public void sort() {}

    public Product peekProduct(String id) {}
    public int findProduct(String id) {}
}