package bg.sofia.uni.fmi.mjt.photoalbum;

import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;

import java.util.Queue;

public class Album {
    private Queue<Image> images;

    public Album(Queue<Image> images) {
        this.images = images;
    }

    public synchronized void addImage(Image toAdd) {
//        System.out.println(1);
        images.add(toAdd);
        notifyAll();
    }

    public synchronized Queue<Image> getImages() {
        return images;
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
    public synchronized Image getImage() throws InterruptedException {
//        if (images.size() == 0) {
//            wait();
//        }
        Image item = images.poll();
        return item;
    }
}
