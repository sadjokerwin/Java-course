package bg.sofia.uni.fmi.mjt.photoalbum.image;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Image implements Serializable {
    String name;
    BufferedImage data;

    public Image(String name, BufferedImage data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getData() {
        return data;
    }

}