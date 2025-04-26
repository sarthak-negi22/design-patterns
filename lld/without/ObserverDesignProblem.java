class YoutubeChannel {
    public void uploadVideo(String video) {
        System.out.println("New video uploaded: "+video);
        sendNotification(video);
    }

    public void sendNotification(String video) {
        System.out.println("Notifying users about: "+video);
    }
}

public class ObserverDesignProblem {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel();
        channel.uploadVideo("System Design tutorial");      // subscribers need to be harcodes in client code. Adding/removing the subscribers require modifying the class
    }
}
