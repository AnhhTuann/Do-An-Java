public class Card extends Product
{
    /*Constructor*/
    public Card() {
        super(Product.Type.Card);
        serialNumber = new String("");
    }

    public Card(String id) {
        super(id, Product.Type.Card);
    }

    public Card(Card card) {
        super(card);
        setValue(card.getValue());
        setPublisher(card.getPublisher());

        serialNumber = new String("");

        System.out.print("Input serial number: ");
        setSerialNumber(Shop.scanner.nextLine());
    }

    /*Members*/
    private String  serialNumber;
    private int     value;

    /*Get methods*/
    public String   getSerialNumber() { return serialNumber; }
    public int      getValue() { return value; }

    /*Set methods*/
    public void setSerialNumber(String number) { serialNumber = number; }
    public void setValue(int value) { this.value = value; }

    /*Other methods*/
    @Override
    public void createProductDetails()
    {
        serialNumber = new String("");

        System.out.print("Input serial number: ");
        setSerialNumber(Shop.scanner.nextLine());

        System.out.print("Input value: ");
        setValue(Shop.scanner.nextInt());
        Shop.scanner.nextLine();
    }

    @Override
    public String toString()
    {
        String str;
        str = super.toString() + String.format("%-20s|%-10s|%n", getSerialNumber(), getValue());
        return str;
    }

    @Override 
    public String toData() {
        String str = super.toData(); 
        str += getSerialNumber() + " "
             + getValue() + " "
             + getCode()
             + "xDATASEPARATEx";
        
        return str;
    }

    @Override
    public void getData(String[] str) {
        super.getData(str);
        setSerialNumber(str[4]);
        setValue(Integer.parseInt(str[5]));
        setCode(str[6]);
    }
}