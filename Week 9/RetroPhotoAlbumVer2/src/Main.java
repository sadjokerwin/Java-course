import bg.sofia.uni.fmi.mjt.photoalbum.ParallelMonochromeAlbumCreator;

public class Main {
    public static void main(String[] args) {

        String path = "D:/Photoshop/";

        try {
            ParallelMonochromeAlbumCreator par1 = new ParallelMonochromeAlbumCreator("D:/University/Test", path);
            par1.processImages("D:/Photoshop/", "D:/University/Test");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}