package bg.sofia.uni.fmi.mjt.photoalbum;

import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Queue;

public abstract class ParallelMonochromeAlbumCreator implements MonochromeAlbumCreator {
    private final int imageProcessorsCount;
    private Queue<Image> notProcessedImages;
    private final ImageConverter imageConverter;
    private Path destination;
    private int currentNumberOfThreads;
    final int DEFAULT_NUMBER_ACTIVE_THREADS = 0;

    public ParallelMonochromeAlbumCreator(int imageProcessorsCount, String destination) {
        this.imageProcessorsCount = imageProcessorsCount;
        this.notProcessedImages = new ArrayDeque<>();
        this.imageConverter = new ImageConverter();
        this.currentNumberOfThreads = DEFAULT_NUMBER_ACTIVE_THREADS;

        try {
            this.destination = Files.createDirectories(Path.of(destination));
        } catch (IOException e) {

            System.out.println("The directory couldn't be created");
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
