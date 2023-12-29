package bg.sofia.uni.fmi.mjt.photoalbum.album;

import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageConverter;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageWriter;

import java.util.Queue;

public class Album {
    private Queue<Image> images;
    public boolean isProducerFinished = false;
    private ImageWriter imageWriter;
    private ImageConverter imageConverter;

    public Album(Queue<Image> images) {
        this.images = images;
    }

    public void setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
    }

    public void setImageConverter(ImageConverter imageConverter) {
        this.imageConverter = imageConverter;
    }

    public synchronized void addImage(Image toAdd) {
//        System.out.println("Producer " + Thread.currentThread().getName() + " produced: " + toAdd);
        images.add(toAdd);

        notifyAll();
    }

    public synchronized void notifyIsNotEmpty() {
        notifyAll();
    }

    public synchronized Queue<Image> getImages() {
        return images;
    }

    public synchronized void getImage() throws InterruptedException {
//        System.out.println("Consumer " + Thread.currentThread().getName() + " tries to getImage");

        while (images.isEmpty() && !isProducerFinished) {
//            System.out.println("Consumer " + Thread.currentThread().getName() + " tries to consume");

            wait();
        }

        if (images.isEmpty() && isProducerFinished) {
//            System.out.println("Consumer " + Thread.currentThread().getName() + " finished");
            return;
        }

//        System.out.println("Consumer " + Thread.currentThread().getName() + " consumed: " + images.peek());
        Image imageToConvert = images.poll();
        if (imageToConvert != null) {
            Image convertedImage = imageConverter.convertToBlackAndWhite(imageToConvert);
            imageWriter.writeImage(convertedImage, convertedImage.getFormat());
        }


    }

    public synchronized void setProducerFinished() {
        isProducerFinished = true;
        // Notify all waiting consumers in case they are waiting
        notifyAll();
    }
}
