import java.util.LinkedList;

public abstract class ProductList<T extends Product> implements IPrintable
{
    /*Member*/
    protected LinkedList<T> list;
    protected PublisherList publisherList;

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
    public abstract void addProduct(String id, int quantity);

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

    protected boolean checkPublisherList(Product product) {
        if (publisherList.findPublisher(product.getPublisher()) == -1) 
        {
            System.out.println("This is new publisher! Adding to the list!");
            publisherList.addPublisher(product.getPublisher());
            publisherList.getPublisher(product.getPublisher()).addTitle(product.getName());
            return true;
        }
        else
        {
            Publisher publisher = publisherList.getPublisher(product.getPublisher());

            if (publisher.findTitle(product.getName()) != -1)
            {
                System.out.println("This product is already exist! Re-check the ID!");
                return false;
            }
            else
            {
                publisher.addTitle(product.getName());
                return true;
            }
        }
    }
}