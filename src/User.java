//Superklasse User brugeren skriver sit navn
public abstract class User {
    protected String name;

    public User (String name){
    this.name=name;
    }

    //Metoder til user som fortæller
    public abstract void showAdvertisment();
    public abstract boolean canDownload();
}

