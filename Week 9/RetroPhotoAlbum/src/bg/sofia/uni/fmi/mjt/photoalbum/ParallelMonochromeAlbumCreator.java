package bg.sofia.uni.fmi.mjt.photoalbum;

import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class ParallelMonochromeAlbumCreator implements MonochromeAlbumCreator {
    private final int imageProcessorsCount;
    private Album album;
    private final ImageConverter imageConverter;
    private File destination;
    private int currentNumberOfThreads;

    public ParallelMonochromeAlbumCreator(int imageProcessorsCount, String destination) {
        this.imageProcessorsCount = imageProcessorsCount;
        this.imageConverter = new ImageConverter();
        
        try {
            this.destination = Files.createDirectories(Path.of(destination));
        } catch (IOException e) {

            System.out.println("The directory couldn't be created");
        }
    }

    public void imageParser() {
        File[] directoryListing = destination.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.toString().endsWith(JPEG_SUFFIX)
                    || child.toString().endsWith(PNG_SUFFIX)
                    || child.toString().endsWith(JPG_SUFFIX)) {
                    Producer producer = new Producer(this);
                    producer.start();
                }
            }
        }
    }

    public synchronized void processImage() throws InterruptedException {
        if (!notProcessedImages.isEmpty()) {
            Image current = notProcessedImages.poll();

            imageConverter.convertToBlackAndWhite(current);

            imageConverter.writeImage(current, current.getFormat(), destination.toString());
        } else {
            wait();
        }
    }

    public synchronized void addImage(Image toAdd) {
        notProcessedImages.add(toAdd);
        notifyAll();
    }
}
