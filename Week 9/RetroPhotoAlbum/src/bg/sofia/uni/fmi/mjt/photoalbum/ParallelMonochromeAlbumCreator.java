package bg.sofia.uni.fmi.mjt.photoalbum;

import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Queue;

public class ParallelMonochromeAlbumCreator implements MonochromeAlbumCreator {
    private final int imageProcessorsCount;
    private Album album;
    private ImageConverter imageConverter;
    private int currentNumberOfThreads;
    private final int MAX_THREADS = 5;

    public void imageParser(File directoryOfFiles) throws InterruptedException {
        final String JPEG_SUFFIX = ".jpeg";
        final String PNG_SUFFIX = ".jpg";
        final String JPG_SUFFIX = ".png";

        File[] directoryListing = directoryOfFiles.listFiles();

        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.toString().endsWith(JPEG_SUFFIX)
                        || child.toString().endsWith(PNG_SUFFIX)
                        || child.toString().endsWith(JPG_SUFFIX)) {
                    Producer producer = new Producer(album, imageConverter.loadImage(child.toPath()));
                    producer.start();
                }
            }
        }
    }

    public ParallelMonochromeAlbumCreator(int imageProcessorsCount, String destination, String directoryOfFiles) throws InterruptedException {
        this.imageProcessorsCount = imageProcessorsCount;
        album = new Album(new ArrayDeque<>());


        try {
            File destinationDir = Files.createDirectories(Path.of(destination)).toFile();
            this.imageConverter = new ImageConverter(destinationDir);
        } catch (IOException e) {
            System.out.println("The directory couldn't be created");
        }


        File directory = new File(directoryOfFiles);
        imageParser(directory);


    }

    public void printImages() {
        Queue<Image> result = album.getImages();
//        System.out.println(result.size());
        for (Image image : result) {
            System.out.println(image.getName());
        }
    }

    @Override
    public void processImages(String sourceDirectory, String outputDirectory) {
        while (!album.getImages().isEmpty()) {
            // Check if a new consumer can be started
            if (Consumer.canStartNew()) {
                Consumer consumer = new Consumer(album, imageConverter);
                consumer.start();
            }
        }

    }

}
