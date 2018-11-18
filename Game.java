public class Game extends Product
{
    /*Constructor*/
    Game(String id){
        super(id, Product.Type.Game);
    }

    /*Inner objects*/
    public enum Platform
    {
        Steam,
        Origin,
        Uplay,
        BattleNet,
    }

    public enum Genre
    {
        Action,
        Action_adventure,
        Adventure,
        Simulation,
        Strategy,
        Sports,
        Role_playing,
    }

    /*Members*/
    int releasedYear;
    Genre genre;
    Platform platform;
    String version;

    /*Get methods*/
    public int getReleasedYear() { return releasedYear; }
    public Genre getGenre() { return genre; }
    public Platform getPlatform() { return platform; }
    public String getVersion() { return version; }

    /*Set methods*/
    public void setReleasedYear(int year) { releasedYear = year; }
    public void setGenre(Genre genre) { this.genre = genre; }
    public void setPlatform(Platform platform) { this.platform = platform; }
    public void setVersion(String version) { this.version = version; }

    /*Other methods*/
    public void createProductDetails()
    {
        int check = 0;
        while (check == 0)
        {
            check = 1;
            System.out.print("1. Action\n2. Action-adventure\n3. Adventure\n4. Simulation\n5. Strategy\n6. Sports\n7. Role-playing\n");
            System.out.print("Choose game genre: ");
            switch (Shop.scanner.nextInt())
            {
                case 1:
                    setGenre(Genre.Action);
                    break;
                case 2:
                    setGenre(Genre.Action_adventure);
                    break;
                case 3:
                    setGenre(Genre.Adventure);
                    break;
                case 4:
                    setGenre(Genre.Simulation);
                    break;
                case 5:
                    setGenre(Genre.Strategy);
                    break;
                case 6:
                    setGenre(Genre.Sports);
                    break;
                case 7:
                    setGenre(Genre.Role_playing);
                    break;
                default: 
                    check = 0;
                    break;
            }
        }

        check = 0;
        while (check == 0)
        {
            check = 1;
            System.out.print("1. Steam\n2. Origin\n3. Uplay\n4. Battle.net\n");
            System.out.print("Choose supported platform: ");
            switch (Shop.scanner.nextInt())
            {
                case 1:
                    setPlatform(Platform.Steam);
                    break;
                case 2:
                    setPlatform(Platform.Origin);
                    break;
                case 3:
                    setPlatform(Platform.Uplay);
                    break;
                case 4:
                    setPlatform(Platform.BattleNet);
                    break;
                default:
                    check = 0;
                    break;
            }
        }

        System.out.print("Input released year: ");
        setReleasedYear(Shop.scanner.nextInt());
        Shop.scanner.nextLine();

        System.out.print("Input version: ");
        setVersion(Shop.scanner.nextLine());
    }

    public String toString()
    {
        String str = new String("");
        str += "---------------\n" + 
               super.toString() +
               "Released Year: " + getReleasedYear() + 
               "\nGenre: " + getGenre().toString() +
               "\nPlatform: " + getPlatform().toString() + 
               "\nVersion: " + getVersion() +
               "\n---------------\n";
        return str;
    }
}