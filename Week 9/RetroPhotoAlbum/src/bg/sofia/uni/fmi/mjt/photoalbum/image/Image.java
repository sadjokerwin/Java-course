package bg.sofia.uni.fmi.mjt.photoalbum.image;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Image implements Serializable {
    String name;
    BufferedImage data;
    String imageFormat;

    public Image(String name, BufferedImage data) {
        this.name = name;
        this.data = data;
        this.imageFormat = "png";
    }

    public String getName() {
        return name;
    }

    public BufferedImage getData() {
        return data;
    }

    public String getFormat() {
        return imageFormat;
    }

}