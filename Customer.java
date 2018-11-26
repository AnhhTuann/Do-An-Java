
public class Customer implements IPrintable {
    /*Members*/
    private String id;
    private String lastName;
    private String firstName;
    private int    yearOfBirth;
    private String phoneNumber;
    private String address;
    private int    point;
    
    /*Constructor*/
    public Customer(String id)
    {
        setID(id);
        createCustomerInfo();
    }

    
    /*Set Methods*/
    public void    setID(String id) { this.id = id; }
    public void    setLastName(String lastName) {this.lastName=lastName;}
    public void    setFirstName(String firstName){this.firstName=firstName;}
    public void    setYearOfBirth(int yearOfBirth){this.yearOfBirth=yearOfBirth;}
    public void    setAddress(String address){this.address=address;}
    public void    setPhoneNumber(String phoneNumber){this.phoneNumber=phoneNumber;}
    public void    setPoint(int point){this.point=point;}
    
    /*Get Methods*/
    public String getID() {return id;}
    public String getLastName() {return lastName;}
    public String getFirstName() {return firstName;}
    public int    getYearOfBirth() {return yearOfBirth;}
    public String getAddress()  {return address;}
    public String getPhoneNumber() {return phoneNumber;}
    public int    getPoint()       {return point;}
    
    
    public String toString()
    {
        String str = "";
        str += String.format("|%-10s|%-20s|%-20s|%-15s|%-25s|%-15s|%-15s|%n", getID(), getFirstName(), getLastName(), getYearOfBirth(), getAddress(),getPhoneNumber(),getPoint());
        return str;
    }
    public void createCustomerInfo()
    {
        System.out.print("Input First Name: ");
        setFirstName(Shop.scanner.nextLine());

        System.out.print("Input Last Name: ");
        setLastName(Shop.scanner.nextLine());

        System.out.print("Input Year Of Birth: ");
        setYearOfBirth(Shop.scanner.nextInt());
        Shop.scanner.nextLine();
        
        System.out.print("Input Address: ");
        setAddress(Shop.scanner.nextLine());
        
        System.out.print("Input Phone Number: ");
        setPhoneNumber(Shop.scanner.nextLine());
        
        setPoint(0);
    }
    
    
}
