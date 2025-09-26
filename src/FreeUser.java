//Underklasse til user
public class FreeUser extends User {
    public FreeUser (String name){
        super(name);
    }

    //Viser reklamer hvis brugeren er FreeUser
    @Override
    public void showAdvertisment() {
        System.out.println(" Opgrader til Spotify Premium for at slippe for reklamer! ");
        }

        //Kan ikke downloade sange
        @Override
        public boolean canDownload() {
            return false;
        }
    }
