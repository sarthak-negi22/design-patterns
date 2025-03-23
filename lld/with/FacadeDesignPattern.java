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

class HometheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector proj;

    public HometheaterFacade(Amplifier amp, DVDPlayer dvd, Projector proj) {
        this.amp = amp;
        this.dvd = dvd;
        this.proj = proj;
    }

    public void watchMovie() {
        System.out.println("Preparing for movie...");
        amp.on();
        amp.setFrequency(156);
        dvd.on();
        dvd.setVolume(15);
        proj.on();
        proj.setWideScreenMode(true);
        System.out.println("Enjoy the show!");
    }
}

public class FacadeDesignPattern {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector proj = new Projector();
        HometheaterFacade facade = new HometheaterFacade(amp, dvd, proj);
        facade.watchMovie();
    }
}
