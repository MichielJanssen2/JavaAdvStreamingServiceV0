package be.pxl.ja.streamingservice.model;
import java.time.LocalDate;

public class Movie extends Content implements Playable{
    public static final int LONG_PLAYING_TIME = 135;
    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;

    public Movie(String title,Rating maturityRating){
        super(title,maturityRating);
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isLongPlayingTime () {
        return duration > LONG_PLAYING_TIME;
    }

    public String getPlayingTime () {
        return "2 u 30 min";

    }
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void play() {
        System.out.println("Playing " + this);
    }

    @Override
    public void pause() {
        System.out.println("Pausing " + this);
    }
}
