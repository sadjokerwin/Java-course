import bg.sofia.uni.fmi.mjt.photoalbum.ParallelMonochromeAlbumCreator;
import bg.sofia.uni.fmi.mjt.photoalbum.album.Album;
import bg.sofia.uni.fmi.mjt.photoalbum.threads.Consumer;
import bg.sofia.uni.fmi.mjt.photoalbum.threads.Producer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        String path = "D:/Photoshop/";

        try {
            ParallelMonochromeAlbumCreator par1 = new ParallelMonochromeAlbumCreator("D:/University/Test", path);
            par1.processImages("D:/Photoshop/", "D:/University/Test");
        } catch (Exception e) {
            System.out.println(e);
        }

//        List<Producer> producerList = new ArrayList<>();
//        List<Consumer> consumerList = new ArrayList<>();
//
//        Queue<String> imagesToProcess = new LinkedList<>() {{
//            add("Image1");
//            add("Image2");
//            add("Image3");
//            add("Image4");
//            add("Image5");
//            add("Image6");
//            add("Image7");
//            add("Image8");
//            add("Image9");
//            add("Image10");
//        }};
//
//        Queue<String> images = new LinkedList<>();
//        Album album = new Album(images);
//
//        for (int i = 0; i < 2; i++) {
//            Consumer consumer = new Consumer(album);
//            consumerList.add(consumer);
//            consumer.start();
//        }
//
//        while (!imagesToProcess.isEmpty()) {
//            Producer producer = new Producer(album, imagesToProcess.poll());
//            producerList.add(producer);
//            producer.start();
//        }
//
//        producerList.forEach(producer -> {
//            try {
//                producer.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        album.setProducerFinished();


//        if (album.getImages().isEmpty()) {
//            consumerList.forEach(Consumer::stopConsuming);
//
//        }

    }
}