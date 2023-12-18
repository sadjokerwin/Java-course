package bg.sofia.uni.fmi.mjt.photoalbum.image;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Image implements Serializable {
    String name;
    BufferedImage data;
    String imageFormat;
    final int FORMAT_INDEX = 1;

    public Image(String name, BufferedImage data) {
        this.name = name;
        this.data = data;
//        String[] tokens = name.split(".");
//        this.imageFormat = tokens[FORMAT_INDEX];
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