package bg.sofia.uni.fmi.mjt.photoalbum;

import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;

public class Producer extends Thread {
    private Album imagesAlbum;
    private Image currImageToAdd;

    public Producer(Album imagesAlbum, Image currImageToAdd) {
        this.imagesAlbum = imagesAlbum;
        this.currImageToAdd = currImageToAdd;
    }

    @Override
    public void run() {
        imagesAlbum.addImage(currImageToAdd);
    }
}
