package bg.sofia.uni.fmi.mjt.photoalbum;

import bg.sofia.uni.fmi.mjt.photoalbum.album.Album;
import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageConverter;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageWriter;
import bg.sofia.uni.fmi.mjt.photoalbum.threads.Consumer;
import bg.sofia.uni.fmi.mjt.photoalbum.threads.Producer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Queue;

public class ParallelMonochromeAlbumCreator implements MonochromeAlbumCreator {

    Queue<Image> imagesToProcess = new LinkedList<>();
    Album album;
    ImageConverter imageConverter;

    public ParallelMonochromeAlbumCreator(String destiantion, String directoryOfFiles) {
        album = new Album(imagesToProcess);

        try {
            File destinationDir = Files.createDirectories(Path.of(destiantion)).toFile();
            this.imageConverter = new ImageConverter(destinationDir);
        } catch (Exception e) {
            System.out.println("The directory couldn't be created");
        }
    }

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

                    producer.join();
                }
            }
        }
    }

    @Override
    public void processImages(String source, String destination) {
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer(album);
            consumer.start();
        }

        imageConverter = new ImageConverter(new File(destination));
        album.setImageConverter(imageConverter);
        album.setImageWriter(new ImageWriter(new File(destination)));

        try {
            imageParser(new File(source));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        album.setProducerFinished();


    }
}
