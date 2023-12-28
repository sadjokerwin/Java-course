package bg.sofia.uni.fmi.mjt.photoalbum.album;

import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;

import java.util.Queue;

public class Album {
    private Queue<Image> images;

    public Album(Queue<Image> images) {
        this.images = images;
    }

    public synchronized void addImage(Image toAdd) {
        images.add(toAdd);
        notifyAll();
    }

    public synchronized Image getImage() throws InterruptedException {
        while (images.isEmpty()) {
            wait();
        }
        return images.poll();
    }
}
