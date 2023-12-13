import bg.sofia.uni.fmi.mjt.photoalbum.image.Image;
import bg.sofia.uni.fmi.mjt.photoalbum.image.ImageConverter;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path path = new File("images/photo.jpeg").toPath();

        ImageConverter imageConverter = new ImageConverter(path);
        Image loadedImage = imageConverter.loadImage(path);
        Image processedImage = imageConverter.convertToBlackAndWhite(loadedImage);

        File outputPath = new File("images/out/" + processedImage.getName());

        try {
            Files.createDirectories(Path.of("images/out"));

            ImageIO.write(processedImage.getData(), "jpeg", outputPath);
        } catch (IOException e) {
            System.out.println("Failed to save image");
        }
    }
}