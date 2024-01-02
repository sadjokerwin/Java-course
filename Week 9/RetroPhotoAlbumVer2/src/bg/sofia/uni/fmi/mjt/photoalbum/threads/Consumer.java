package bg.sofia.uni.fmi.mjt.photoalbum.threads;

import bg.sofia.uni.fmi.mjt.photoalbum.album.Album;

public class Consumer extends Thread {

    private Album imagesAlbum;
    private boolean running = true;
    public Consumer(Album imagesAlbum) {
        this.imagesAlbum = imagesAlbum;
    }

    @Override
    public void run() {
//        System.out.println("Consumer " + Thread.currentThread().getName() + " started");
        consume();
    }

    public void consume() {
        while (running) {
            if (imagesAlbum.isProducerFinished) {
                stopConsuming();
                break;
            }
            try {
                imagesAlbum.getImage();
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void stopConsuming() {
        running = false;
        imagesAlbum.notifyIsNotEmpty();
    }
}
