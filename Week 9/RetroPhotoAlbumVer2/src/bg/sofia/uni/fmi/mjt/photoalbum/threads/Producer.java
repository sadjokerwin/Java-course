package bg.sofia.uni.fmi.mjt.photoalbum.threads;

import bg.sofia.uni.fmi.mjt.photoalbum.album.Album;
import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;

public class Producer extends Thread {
    private Album imagesAlbum;
    private Image imageToAdd;

    public Producer(Album imagesAlbum, Image imageToAdd) {
        this.imagesAlbum = imagesAlbum;
        this.imageToAdd = imageToAdd;
    }

    @Override
    public void run() {
        imagesAlbum.addImage(imageToAdd);
    }


}
