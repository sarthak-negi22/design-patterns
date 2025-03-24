// observer interface

import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void notify(String video);
}

// concrete observer classes
class EmailSubscriber implements Subscriber {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    public void notify(String video) {
        System.out.println("Notifying user via email: "+email+" of the video: "+video);
    }
}

class SMSSubscriber implements Subscriber {
    private String phone;

    public SMSSubscriber(String phone) {
        this.phone = phone;
    }

    public void notify(String video) {
        System.out.println("Notifying user via phone number: "+phone+" of the video: "+video);
    }
}

// subject interface (Can be class too, and can be extended later on)
interface Channel {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String video);
}

class YoutubeChannel implements Channel {
    private String channelName;
    private List<Subscriber> subscribers = new ArrayList<>();

    public YoutubeChannel(String channelName) {
        this.channelName = channelName;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String video) {
        for(Subscriber subscriber : subscribers) {
            subscriber.notify(video);
        }
    }

    public void uploadVideo(String video) {
        System.out.println(channelName+" uploaded a new video about: "+video);
        notifySubscribers(video);
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel("LucaS");
        Subscriber emailSub = new EmailSubscriber("test123@gmail.com");
        Subscriber smsSub = new SMSSubscriber("9913456778");

        channel.subscribe(emailSub);
        channel.subscribe(smsSub);

        channel.uploadVideo("System Design Tutorial");

        channel.unsubscribe(smsSub);        // no need to change the class code for adding/removing subscribers
        channel.uploadVideo("Dev ops tutorial");
    }
}
