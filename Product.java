public abstract class Product implements IPrintable, IWritable
{
    /*Constructor*/
    public Product(Product.Type type) {
        this.id = new String("");
        name = new String("");
        code = new String("");
        publisher = new String("");
        
        setType(type);
    }

    public Product(String id, Product.Type type) { 
        this.id = new String("");
        name = new String("");
        code = new String("");
        publisher = new String("");

        setID(id);
        setType(type);
        createProductInfo(); 
    }

    public Product(Product product) {
        id = new String("");
        name = new String("");
        code = new String("");
        publisher = new String("");

        setID(product.getID());
        setName(product.getName());
        setPrice(product.getPrice());
        setType(product.getType());

        System.out.print("Input activation code: ");
        setCode(Shop.scanner.nextLine());
    }

    /*Inner objects*/
    public static enum Type
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
    private String  publisher;

    /*Get methods*/
    public String   getID() { return id; }
    public String   getName() { return name; }
    public String   getCode() { return code; }
    public Type     getType() { return type; }
    public int      getPrice() { return price; }
    public String   getPublisher() { return publisher; }

    /*Set methods*/
    public void     setID(String id) { this.id = id; }
    public void     setName(String name) { this.name = name; }
    public void     setCode(String code) { this.code = code; }
    public void     setType(Type type) { this.type = type; }
    public void     setPrice(int price) { this.price = price; }
    public void     setPublisher(String name) { publisher = name; }

    /*Other methods*/
    public abstract void createProductDetails();
    
    public void createProductInfo() {
        System.out.print("Input product name: ");
        setName(Shop.scanner.nextLine());

        System.out.print("Input publisher name: ");
        setPublisher(Shop.scanner.nextLine());

        System.out.print("Input activation code: ");
        setCode(Shop.scanner.nextLine());

        System.out.print("Input product price: ");
        setPrice(Shop.scanner.nextInt());
        Shop.scanner.nextLine();

        createProductDetails();
    }

    public String toString()
    {
        String str;
        str = String.format("|%-10s|%-20s|%-20s|%-5s|%-10s|", getID(), getName(), getPublisher(), getType().toString(), getPrice());
        return str;
    }

    public String toData() {
        String str = getID() + " " 
                   + getName() + " " 
                   + getPublisher() + " " 
                   + getPrice() + " ";
                   
        return str;
    }

    @Override
    public void getData(String[] str) {
        setID(str[0]);
        setName(str[1]);
        setPublisher(str[2]);
        setPrice(Integer.parseInt(str[3]));
    }
}