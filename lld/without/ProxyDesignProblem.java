class MovieStreamingService {
    public void watchMovie(String movie) {
        System.out.println("Loading movie...");
        try {
            Thread.sleep(3000);     // simulating resource-extensive process
        } catch (Exception e) {
            System.out.println("Error!");
        }
        System.out.println("Watching movie: "+movie);
    }
}

// direct access
public class ProxyDesignProblem {
    public static void main(String[] args) {
        MovieStreamingService movie = new MovieStreamingService();
        movie.watchMovie("The Walking dead");
    }
}
