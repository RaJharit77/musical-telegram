package streaming.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streaming.streaming.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StreamingTest {
    private Genre rock;
    private Genre pop;
    private Genre jazz;
    private SoloArtist artist1;
    private SoloArtist artist2;
    private GroupArtist group1;
    private Song song1;
    private Song song2;
    private Song song3;
    private User user1;
    private User user2;
    private Playlist playlist1;
    private Playlist playlist2;

    @BeforeEach
    public void setUp() {
        // Create some genres
        rock = new Genre("1", "Rock");
        pop = new Genre("2", "Pop");
        jazz = new Genre("3", "Jazz");

        // Create some artists
        artist1 = new SoloArtist("1", 1990, "John Doe", "USA", "John", "Doe", LocalDate.of(1970, 5, 15));
        artist2 = new SoloArtist("2", 2000, "Jane Smith", "UK", "Jane", "Smith", LocalDate.of(1980, 3, 20));

        group1 = new GroupArtist("3", 2010, "The Rockers", "USA", Arrays.asList(artist1, artist2));

        // Create some songs
        song1 = new Song("1", "Rock Anthem", Duration.ofMinutes(4), artist1, Arrays.asList(rock, jazz));
        song2 = new Song("2", "Pop Hit", Duration.ofMinutes(3), artist2, List.of(pop));
        song3 = new Song("3", "Jazz Vibes", Duration.ofMinutes(5), artist1, List.of(jazz));

        // Create some users
        user1 = new User("1", "user1", new ArrayList<>());
        user2 = new User("2", "user2", new ArrayList<>());

        // Create some playlists
        playlist1 = new Playlist("1", new ArrayList<>(Arrays.asList(song1, song2)), user1, new ArrayList<>(Arrays.asList(user2, user1)));
        playlist2 = new Playlist("2", new ArrayList<>(Arrays.asList(song2, song3)), user2, new ArrayList<>());
    }

    @Test
    public void testGetTotalLikes() {
        // Test getTotalLikes method
        assertEquals(2, playlist1.getTotalLikes(), "Number of likes for playlist1 should be 2");
    }

    @Test
    public void testLikeUnlikeFunctionality() {
        user1.like(playlist1);
        assertEquals(1, playlist1.getTotalLikes(), "Total likes on playlist1 after user1 re-liked it should be 1");
        user1.like(playlist2);
        assertEquals(1, playlist2.getTotalLikes(), "Total likes on playlist2 after having its first like should be 1");
    }

    @Test
    public void testAddSongToPlaylist() {
        playlist1.addToPlaylist(song3);
        assertEquals(3, playlist1.getSongs().size(), "Songs in playlist1 after adding song3 should be 3");
    }

    @Test
    public void testCountPlaylistsMethod() {
        playlist1.addToPlaylist(song3);
        playlist2.addToPlaylist(song3);

        long song3PlaylistCount = song3.countPlaylists(Arrays.asList(playlist1, playlist2));
        assertEquals(2, song3PlaylistCount, "Song3 should be in 2 playlists");
    }

    @Test
    public void testRemoveSongById() {
        playlist1.removeById("2");
        assertEquals(1, playlist1.getSongs().size(), "Songs in playlist1 after removing song2 should be 1");
        assertFalse(playlist1.getSongs().contains(song2), "Playlist1 should not contain song2 after removal");
    }

    @Test
    public void testExcludeGenresFromPlaylist() {
        // Test excluding genres from a playlist: here we shall exclude `Rock` songs.
        Playlist filteredPlaylist = playlist1.exclude(List.of(rock));
        assertEquals(1, filteredPlaylist.getSongs().size(), "Songs in filtered playlist excluding rock should be 1");
        assertFalse(filteredPlaylist.getSongs().contains(song1), "Filtered playlist should not contain rock songs");
    }
}
