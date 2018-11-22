import java.util.LinkedList;

public class CardList extends ProductList<Card>
{
    /*Constructor*/
    public CardList(PublisherList publisherList) {
        list = new LinkedList<Card>();
        this.publisherList = publisherList;
    }

    /*Other methods*/
    @Override
    public void addProduct(String id, int quantity) {
        int index = findProduct(id);
        if (index == -1)
        {
            System.out.println("This is new ID!");
            Card newProduct = new Card(id);

            if (!checkPublisherList(newProduct))
            {
                System.out.println("Failed! Invalid information!");
                return;
            }
            
            list.add(newProduct);
            for (int i = 0; i < quantity - 1; ++i)
            {
                Card product = new Card(newProduct);
                list.add(product);
            }
        }
        else
        {
            Card existProduct = getProduct(id);
            for (int i = 0; i < quantity; ++i)
            {
                Card product = new Card(existProduct);
                list.add(product);
            }
        }
    }
}