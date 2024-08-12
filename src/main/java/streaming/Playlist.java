package streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Note : J'ai préfére utiliser les streams pour les méthodes dans cette classe, mais vous pouvez
 * très bien utiliser des boucles standards pour les faire.
 */
public class Playlist {
    private String id;
    private List<Song> songs;
    private User author;
    private List<User> likes;

    public Playlist(String id, List<Song> songs, User author, List<User> likes) {
        this.id = id;
        this.songs = songs;
        this.author = author;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public void addToPlaylist(Song song){
        this.songs.add(song);
    }

    public void addToPlaylist(Album album){
        this.songs.addAll(album.getSongs());
    }

    public void removeById(String id){
        this.songs.removeIf(song -> song.getId().equals(id));
    }

    public Playlist exclude(List<Genre> toExclude){
        List<Song> remainingSongs = this.songs
                .stream()
                .filter(song -> song.getGenres().stream().noneMatch(toExclude::contains))
                .collect(Collectors.toList());

        return new Playlist(this.id, remainingSongs, this.author, this.likes);
    }

    public int getTotalLikes(){
        return this.likes.size();
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "songs=" + songs +
                ", author=" + author +
                ", likes=" + likes +
                '}';
    }
}
