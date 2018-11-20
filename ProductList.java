import java.util.LinkedList;

public class ProductList<T extends Product> implements IPrintable
{
    /*Constructor*/
    public ProductList()
    {
        list = new LinkedList<T>();
    }

    /*Member*/
    protected LinkedList<T> list;

    /*Get methods*/
    public T getProduct(String id)
    {
        int index = findProduct(id);
        if (index == -1)
        {
            System.out.println("Cannot find ID!");
            return null;
        }
        else
        {
            return list.get(index);
        }
    }

    public int getTotalQuantity() {
        return list.size();
    }

    public int getQuantity(String id) {
        int index = findProduct(id);
        int count = 0;
        if (index == -1)
        {
            System.out.println("Cannot find ID!");
            return 0;
        }
        else
        {
            for (T product : list)
                if (product.getID().equals(id))
                    ++count;
        }

        return count;
    }

    /*Set methods*/

    /*Other methods*/
    public void addProduct(String id, int quantity)
    {
        int index = findProduct(id);
        if (index == -1)
        {
            System.out.println("This is new ID!");
            T newProduct = new T(id);
            list.add(newProduct);
            for (int i = 0; i < quantity - 1; ++i)
            {
                T product = new T(newProduct);
                list.add(product);
            }
        }
        else
        {
            T existProduct = getProduct(id);
            for (int i = 0; i < quantity; ++i)
            {
                T product = new T(existProduct);
                list.add(product);
            }
        }
    }

    public void removeProduct(String id) {
        int index = findProduct(id);
        if (index == -1)
        {
            System.out.println("Failed: Cannot find ID!");
            return;
        }
        else
        {
           list.remove(index);
        }
    }

    public int findProduct(String id) {
        for (T product : list)
            if (product.getID().equals(id))
                return list.indexOf(product);

        return -1;
    }

    public String toString(){
        String str = new String("");
        str += "***** PRODUCTS *****\n";
        for (T product : list)
        {
            str += product.toString();
        }

        return str;
    }
}