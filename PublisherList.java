import java.util.LinkedList;

public class PublisherList
{
    /*Constructor*/
    PublisherList() {
        list = new LinkedList<Publisher>();
    }
    
    /*Members*/
    LinkedList<Publisher> list;

    /*Get methods*/
    public Publisher getPublisher(String name) {
        int index = findPublisher(name);
        if (index == -1)
        {
            System.out.println("Cannot find publisher!");
            return null;
        }

        return list.get(index);
    }

    public int getQuantity() {
        return list.size();
    }

    public int getQuantity(String name) {
        return getPublisher(name).getQuantity();
    }

    /*Set methods*/
    /*Other methods*/
    public void addPublisher(String name) {
        int index = findPublisher(name);
        if (index != -1)
        {
            System.out.println("Publisher is already exist!");
            return;
        }
        
        Publisher publisher = new Publisher(name);
        list.add(publisher);
    }

    public void removePublisher(String name) {
        int index = findPublisher(name);
        if (index != -1)
        {
            System.out.println("Publisher is already exist!");
            return;
        }

        list.remove(index);
    }

    public int findPublisher(String name) { 
        for (Publisher publisher : list) 
            if (publisher.getName().equalsIgnoreCase(name))
                return list.indexOf(publisher);
        
        return -1;
    }
}