public class PremiumUser extends User {
    public PremiumUser(String name) {
        super(name);
    }

    @Override
    public void showAdvertisment() {
        System.out.println("Du har Spotify Premium, ingen reklamer her! ");

    }

    @Override
    public boolean canDownload() {
        return true;
    }
}

