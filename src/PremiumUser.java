//Underklasse til user
public class PremiumUser extends User {
    public PremiumUser(String name) {
        super(name);
    }
    // Fortæller at brugeren har Spotify Premium og dermed ingen reklamer
    @Override
    public void showAdvertisment() {
        System.out.println("Du har Spotify Premium, ingen reklamer her! ");

    }
    // Kan downloade sange
    @Override
    public boolean canDownload() {
        return true;
    }
}

