interface MovieStreamingService {
    void watchMovie(String movie);
}

class RealMovieStreamingPlatform implements MovieStreamingService {
    public void watchMovie(String movie) {
        System.out.println("Watching movie: "+movie);
    }
}

// proxy class
class MovieStreamingPlatformProxy implements MovieStreamingService {
    private RealMovieStreamingPlatform realMovieStreamingPlatform;
    private String user;

    public MovieStreamingPlatformProxy(String user) {
        this.user = user;
    }

    private boolean authenticate() {
        return user.equalsIgnoreCase("lucas");
    }

    public void watchMovie(String movie) {
        if(!authenticate()) {
            System.out.println("Invalid User! Access is denied");       // adding authentication
            return;
        }
        System.out.println("Loading movie....");

        if(realMovieStreamingPlatform == null) {        // lazy initialization
            realMovieStreamingPlatform = new RealMovieStreamingPlatform();
        }
        realMovieStreamingPlatform.watchMovie(movie);
    } 

}

public class ProxyDesignPattern {
    public static void main(String[] args) {
        MovieStreamingPlatformProxy proxy = new MovieStreamingPlatformProxy("lucas");
        proxy.watchMovie("The Walking Dead");

        MovieStreamingPlatformProxy proxy2 = new MovieStreamingPlatformProxy("test");
        proxy2.watchMovie("Avatar");
    }
}
