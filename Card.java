public class Card extends Product
{
    /*Constructor*/
    public Card(String id) {
        super(id, Product.Type.Card);
    }

    /*Members*/
    String  serialNumber;
    int     value;

    /*Get methods*/
    public String   getSerialNumber() { return serialNumber; }
    public int      getValue() { return value; }

    /*Set methods*/
    public void setSerialNumber(String number) { serialNumber = number; }
    public void setValue(int value) { this.value = value; }

    /*Other methods*/
    public void createProductDetails()
    {
        System.out.print("Input serial number: ");
        setSerialNumber(Shop.scanner.nextLine());

        System.out.print("Input value: ");
        setValue(Shop.scanner.nextInt());
    }

    public String toString()
    {
        String str = new String("");
        str += "---------------\n" + 
               super.toString() +
               "Serial number: " + getSerialNumber() + 
               "\nValue: " + getValue() +
               "\n---------------\n";
        return str;
    }
}