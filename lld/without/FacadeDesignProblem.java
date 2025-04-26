class Amplifier {
    public void on() {
        System.out.println("Amplifier is turned on");
    }

    public void setFrequency(int freqeuncy) {
        System.out.println("Frequency set to: "+freqeuncy);
    }
}

class DVDPlayer {
    public void on() {
        System.out.println("DVD player is on");
    }

    public void setVolume(int volume) {
        System.out.println("Volume is set to: "+volume);
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void setWideScreenMode(boolean choice) {
        if(choice) 
        System.out.println("Wide screen mode is active");
    }
}

public class FacadeDesignProblem {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        amp.on();
        amp.setFrequency(125);

        DVDPlayer dvd = new DVDPlayer();
        dvd.on();
        dvd.setVolume(6);

        Projector proj = new Projector();
        proj.on();
        proj.setWideScreenMode(true);
    }
}
