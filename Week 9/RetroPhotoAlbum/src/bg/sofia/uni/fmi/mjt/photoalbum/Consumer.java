package bg.sofia.uni.fmi.mjt.photoalbum;

import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageConverter;

public class Consumer extends Thread {
    private Image toAlter;
    private Album images;
    private final ImageConverter imageConverter;
    private static int activeThreadsS = 0;
    private static int MAX_THREADS = 6;

    private static synchronized void setMaxThreads(int value) {
        MAX_THREADS = value;
    }

    public Consumer(Album images, ImageConverter imageConverter, int maxThreads) {
        this.images = images;
        this.imageConverter = imageConverter;
//        synchronized (Consumer.class) {
//            if (MAX_THREADS != maxThreads) {
//                setMaxThreads(maxThreads);
//            }
//        }
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
//                if (images.getImages().isEmpty()) {
//                    wait();
//                }
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
