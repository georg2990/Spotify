public class FreeUser extends User {
    public FreeUser (String name){
        super(name);
    }
    @Override
    public void showAdvertisment() {
        System.out.println(" Opgrader til Spotify Premium for at slippe for reklamer! ");
        }
        @Override
        public boolean canDownload() {
            return false;
        }
    }
