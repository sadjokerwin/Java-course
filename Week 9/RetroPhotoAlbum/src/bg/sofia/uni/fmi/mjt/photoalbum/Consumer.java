package bg.sofia.uni.fmi.mjt.photoalbum;

import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageConverter;

public class Consumer extends Thread {
    private Image toAlter;
    private Album images;
    private ImageConverter imageConverter;
    private static int activeThreadsS = 0;
    private static final int MAX_THREADS = 5;

    public Consumer(Album images, ImageConverter imageConverter) {
        this.images = images;
        this.imageConverter = imageConverter;
    }

    public static boolean canStartNew() {
        synchronized (Consumer.class) {
            return activeThreadsS < MAX_THREADS;
        }
    }

    @Override
    public void run() {
        try {
            synchronized (Consumer.class) {
                activeThreadsS++;
            }

            toAlter = images.getImage();
            if (toAlter == null) return;
            toAlter = imageConverter.convertToBlackAndWhite(toAlter);
            imageConverter.writeImage(toAlter, toAlter.getFormat());

            synchronized (Consumer.class) {
                activeThreadsS--;

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
