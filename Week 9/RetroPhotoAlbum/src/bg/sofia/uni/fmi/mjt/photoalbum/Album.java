package bg.sofia.uni.fmi.mjt.photoalbum;

import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageConverter;

import java.io.File;
import java.util.Queue;

public class Album {
    private Queue<Image> images;
    private final String JPEG_SUFFIX = ".jpeg";
    private final String PNG_SUFFIX = ".jpeg";
    private final String JPG_SUFFIX = ".jpeg";

    private ImageConverter imageConverter;

    public Album(Queue<Image> images, String myDirectoryPath) {
        this.images = images;
        imageConverter = new ImageConverter();
    }

//    public void processImages(File directory) {
//        File[] directoryListing = directory.listFiles();
//        if (directoryListing != null) {
//            for (File child : directoryListing) {
//                if (child.toString().endsWith(JPEG_SUFFIX)
//                    || child.toString().endsWith(PNG_SUFFIX)
//                    || child.toString().endsWith(JPG_SUFFIX)) {
//                    Producer producer = new Producer(this);
//                    producer.start();
//                }
//            }
//        }
//    }
//    public synchronized void processImage() throws InterruptedException {
//        if (!notProcessedImages.isEmpty()) {
//            Image current = notProcessedImages.poll();
//
//            imageConverter.convertToBlackAndWhite(current);
//
//            imageConverter.writeImage(current, current.getFormat(), destination.toString());
//        } else {
//            wait();
//        }
//    }

    public synchronized void addImage(Image toAdd) {
        images.add(toAdd);
        notifyAll();
    }
}
