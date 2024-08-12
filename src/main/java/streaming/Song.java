package streaming;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

/**
 * Note : La classe `Song` est vraiment la pièce centrale de cette application. La plupart d'entre
 * vous a oublié que ça prend 1 à plusieurs genres, et non pas un seul. La classe Duration peut
 * être assimilé à deux int, mais vu que je ne veux pas m'embêter à faire les vérifications que
 * c'est bel et bien entre 0 et 23 pour l'heure et 0 et 59 pour les minutes, je préfère utiliser
 * Duration.
 */
public class Song {
    private String id;
    private String title;
    private Duration duration;
    private Artist artist;
    private List<Genre> genres;


    public Song(String id, String title, Duration duration, Artist artist, List<Genre> genres) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.artist = artist;
        this.genres = genres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public long countPlaylists(List<Playlist> allPlaylists){
        return (int) allPlaylists
                .stream()
                .filter(playlist -> playlist.getSongs().contains(this))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(title, song.title) && Objects.equals(duration, song.duration) && Objects.equals(artist, song.artist) && Objects.equals(genres, song.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, duration, artist, genres);
    }

    @Override
    public String toString() {
        return "\nSong{" +
                "title='" + title + '\'' +
                "(" + duration.toMinutesPart() +
                ":" + duration.toSecondsPart() +
                ") by " + artist +
                '}';
    }
}
