package bg.sofia.uni.fmi.mjt.photoalbum;

public class Producer extends Thread {
    private Album imagesAlbum;

    public Producer(Album imagesAlbum) {

    }
    @Override
    public void run() {
        imagesAlbum.addImage();
    }
}
