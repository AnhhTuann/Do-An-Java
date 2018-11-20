import java.util.LinkedList;

public class Publisher 
{
    /*Constructor*/
    /*Members*/
    String name;
    LinkedList<String> productList;

    /*Get methods*/
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return productList.size();
    }

    /*Set methods*/
    public void setName(String name) {
        this.name = name;
    }

    /*Other methods*/
    public void addProduct(String name) {
        productList.add(name);
    }


}