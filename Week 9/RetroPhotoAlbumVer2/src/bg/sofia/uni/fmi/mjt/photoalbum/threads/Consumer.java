package bg.sofia.uni.fmi.mjt.photoalbum.threads;

import bg.sofia.uni.fmi.mjt.photoalbum.album.Album;

public class Consumer extends Thread {

    private Album imagesAlbum;

    public Consumer(Album imagesAlbum) {
        this.imagesAlbum = imagesAlbum;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }
}
