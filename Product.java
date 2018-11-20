public abstract class Product implements IPrintable
{
    /*Constructor*/
    public Product(String id, Product.Type type) { 
        this.id = new String("");
        name = new String("");
        code = new String("");
        setID(id);
        setType(type);
        createProductInfo(); 
    }

    public Product(Product product) {
        id = new String("");
        name = new String("");
        code = new String("");

        setID(product.getID());
        setName(product.getName());
        setPrice(product.getPrice());
        setType(product.getType());

        System.out.print("Input activation code: ");
        setCode(Shop.scanner.nextLine());
    }

    /*Inner objects*/
    public enum Type
    {
        Card,
        Game,
    };

    /*Members*/
    private String  id;
    private String  name;
    private String  code;
    private Type    type;
    private int     price;

    /*Get methods*/
    public String   getID() { return id; }
    public String   getName() { return name; }
    public String   getCode() { return code; }
    public Type     getType() { return type; }
    public int      getPrice() { return price; }

    /*Set methods*/
    public void     setID(String id) { this.id = id; }
    public void     setName(String name) { this.name = name; }
    public void     setCode(String code) { this.code = code; }
    public void     setType(Type type) { this.type = type; }
    public void     setPrice(int price) { this.price = price; }

    /*Other methods*/
    public abstract void createProductDetails();
    
    public void createProductInfo() {
        System.out.print("Input product name: ");
        setName(Shop.scanner.nextLine());

        System.out.print("Input activation code: ");
        setCode(Shop.scanner.nextLine());

        System.out.print("Input product price: ");
        setPrice(Shop.scanner.nextInt());
        Shop.scanner.nextLine();

        createProductDetails();
    }

    public String toString()
    {
        String str = new String("");
        str += "ID: " + getID() + "\n" +
               "Name: " + getName() + "\n" + 
               "Type: " + getType().toString() + "\n" +
               "Price: " + getPrice() + "\n";
        return str;
    }
}