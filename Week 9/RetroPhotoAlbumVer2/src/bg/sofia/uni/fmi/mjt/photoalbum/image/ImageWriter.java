package bg.sofia.uni.fmi.mjt.photoalbum.image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ImageWriter {
    private final File destinDir;

    public ImageWriter(File destinDir) {
        this.destinDir = destinDir;
    }

    public synchronized void writeImage(Image processedImage, String format) {
        try {
            ImageIO.write(processedImage.getData(), format,
                Paths.get(destinDir.toString(), processedImage.getName()).toFile());
        } catch (IOException e) {
            System.out.println("Image couldn't be written");
        }
    }
}