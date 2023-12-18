import bg.sofia.uni.fmi.mjt.photoalbum.ParallelMonochromeAlbumCreator;

public class Main {
    public static void main(String[] args) {
//        Path path = new File("D:/Photoshop/539966.jpg").toPath();
//
//        ImageConverter imageConverter = new ImageConverter(path);
//        ImageConverter imageConverter = new ImageConverter();
//
//        Image loadedImage = imageConverter.loadImage(path);
//        Image processedImage = imageConverter.convertToBlackAndWhite(loadedImage);
//
//        File outputPath = new File("images/out/" + processedImage.getName());
//
//        try {
//            Files.createDirectories(Path.of("images/out"));
//
//            ImageIO.write(processedImage.getData(), "jpeg", outputPath);
//        } catch (IOException e) {
//            System.out.println("Failed to save image");
//        }

        String path = "D:/Photoshop/";

        try {
            ParallelMonochromeAlbumCreator par1 = new ParallelMonochromeAlbumCreator(5, "D:/University/Test", path);
//            par1.printImages();
            par1.processImages("D:/Photoshop/", "D:/University/Test");
        } catch (Exception e) {
            System.out.println(e);
        }

//
//        String test1 = "D:\\Photoshop\\539966.jpg";
//        System.out.println(test1.endsWith(".jpg"));
    }
}