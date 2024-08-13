package streaming.streaming;

import java.util.List;
import java.util.Objects;

/**
 * Note: une classe tout a fait ordinaire...
 */
public class User {
    private String id;
    private String username;
    private List<streaming.streaming.Playlist> playlists;

    public User(String id, String username, List<streaming.streaming.Playlist> playlists) {
        this.id = id;
        this.username = username;
        this.playlists = playlists;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<streaming.streaming.Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<streaming.streaming.Playlist> playlists) {
        this.playlists = playlists;
    }

    public void like(Playlist playlist){
        if (playlist.getLikes().contains(this)){
            playlist.getLikes().remove(this);
        }else {
            playlist.getLikes().add(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(playlists, user.playlists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, playlists);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", playlists=" + playlists +
                '}';
    }
}
