package streaming.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streaming.streaming.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StreamingTest {

    private User user1;
    private User user2;
    private SoloArtist soloArtist;
    private GroupArtist groupArtist;
    private Genre genre1;
    private Genre genre2;
    private Song song1;
    private Song song2;
    private Album album;
    private Playlist playlist;
    private StreamingApp app;

    @BeforeEach
    public void setUp() {
        genre1 = new Genre("1", "Rock");
        genre2 = new Genre("2", "Jazz");

        soloArtist = new SoloArtist("1", 1990, "John Doe", "USA", "John", "Doe", LocalDate.of(1990, 1, 1));
        groupArtist = new GroupArtist("2", 1985, "The Band", "UK");

        song1 = new Song("1", "Song One", Duration.ofMinutes(3), soloArtist, List.of(genre1));
        song2 = new Song("2", "Song Two", Duration.ofMinutes(4), groupArtist, List.of(genre2));

        album = new Album("1", "Greatest Hits", List.of(song1, song2));

        user1 = new User("1", "user1", new ArrayList<>());
        user2 = new User("2", "user2", new ArrayList<>());

        playlist = new Playlist("1", new ArrayList<>(List.of(song1)), user1, new ArrayList<>());

        app = new StreamingApp(new ArrayList<>(List.of(user1, user2)));
    }

    @Test
    public void testAddToPlaylist() {
        playlist.addToPlaylist(song2);
        assertTrue(playlist.getSongs().contains(song2));
    }

    @Test
    public void testAddAlbumToPlaylist() {
        playlist.addToPlaylist(album);
        assertTrue(playlist.getSongs().containsAll(album.getSongs()));
    }

    @Test
    public void testRemoveById() {
        playlist.removeById(song1.getId());
        assertFalse(playlist.getSongs().contains(song1));
    }

    @Test
    public void testExcludeGenre() {
        Playlist newPlaylist = playlist.exclude(List.of(genre1));
        assertFalse(newPlaylist.getSongs().contains(song1));
    }

    @Test
    public void testLikePlaylist() {
        user2.like(playlist);
        assertTrue(playlist.getLikes().contains(user2));

        user2.like(playlist);
        assertFalse(playlist.getLikes().contains(user2));
    }

    @Test
    public void testSongCountInPlaylists() {
        long count = song1.countPlaylists(List.of(playlist));
        assertEquals(1, count);
    }

    @Test
    public void testUserEquality() {
        User sameUser = new User("1", "user1", new ArrayList<>());
        assertEquals(user1, sameUser);
    }

    @Test
    public void testSongEquality() {
        Song sameSong = new Song("1", "Song One", Duration.ofMinutes(3), soloArtist, List.of(genre1));
        assertEquals(song1, sameSong);
    }

    @Test
    public void testGroupArtistToString() {
        assertEquals("GroupArtist{name=The Band}", groupArtist.toString());
    }

    @Test
    public void testSoloArtistToString() {
        assertEquals("SoloArtist{firstName='John', lastName='Doe'}", soloArtist.toString());
    }
}
