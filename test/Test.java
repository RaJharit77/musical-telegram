package streaming.test;

import streaming.streaming.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Note: ce sont les tests pour voir que ça marche. C'est bien bien moche ici... Si tu lis ceci,
 * Transformes tout ça en tests unitaires, et envoies le moi par mail à toky@mail.hei.school,
 * pour peut être décrocher un petit bonus allant jusqu'à deux points avant Mercredi 14 Aout.
 */
public class Test {
    public static void main(String[] args) {
        // Create some genres
        streaming.streaming.Genre rock = new streaming.streaming.Genre("1", "Rock");
        streaming.streaming.Genre pop = new streaming.streaming.Genre("2", "Pop");
        streaming.streaming.Genre jazz = new Genre("3", "Jazz");

        // Create some artists
        streaming.streaming.SoloArtist artist1 = new streaming.streaming.SoloArtist("1", 1990, "John Doe", "USA", "John", "Doe", LocalDate.of(1970, 5, 15));
        streaming.streaming.SoloArtist artist2 = new SoloArtist("2", 2000, "Jane Smith", "UK", "Jane", "Smith", LocalDate.of(1980, 3, 20));

        streaming.streaming.GroupArtist group1 = new GroupArtist("3", 2010, "The Rockers", "USA", Arrays.asList(artist1, artist2));

        // Create some songs
        streaming.streaming.Song song1 = new streaming.streaming.Song("1", "Rock Anthem", Duration.ofMinutes(4), artist1, Arrays.asList(rock, jazz));
        streaming.streaming.Song song2 = new streaming.streaming.Song("2", "Pop Hit", Duration.ofMinutes(3), artist2, List.of(pop));
        streaming.streaming.Song song3 = new Song("3", "Jazz Vibes", Duration.ofMinutes(5), artist1, List.of(jazz));

        // Create some users
        User user1 = new User("1", "user1", new ArrayList<>());
        User user2 = new User("2", "user2", new ArrayList<>());

        // Create some playlists
        streaming.streaming.Playlist playlist1 = new streaming.streaming.Playlist("1", new ArrayList<>(Arrays.asList(song1, song2)), user1, new ArrayList<>(Arrays.asList(user2, user1)));
        streaming.streaming.Playlist playlist2 = new streaming.streaming.Playlist("2", new ArrayList<>(Arrays.asList(song2, song3)), user2, new ArrayList<>());

        // Add playlists to users
        user1.getPlaylists().add(playlist1);
        user2.getPlaylists().add(playlist2);


        // METHOD TESTING
        // Test getTotalLikes method
        System.out.println("Number of likes for playlist1 is : " + playlist1.getTotalLikes()); // should output 2

        // Test like/unlike functionality
        user1.like(playlist1);
        System.out.println("Total likes on playlist1 after user1 re-liked it : " + playlist1.getTotalLikes()); // Expected output: 1 (user1 no longer likes it, just user2)

        user1.like(playlist2);
        System.out.println("Total likes on playlist2 after having its first like: " + playlist2.getTotalLikes()); // Expected output: 1 (user1 only)

        // Test adding a song to a playlist
        playlist1.addToPlaylist(song3);
        System.out.println("Songs in playlist1 after adding song3: " + playlist1.getSongs().size()); // Expected output: 3

        // Test countPlaylists method in Song class by adding it to both playlists
        long song3PlaylistCount = song3.countPlaylists(Arrays.asList(playlist1, playlist2));
        System.out.println("Song3 is in " + song3PlaylistCount + " playlists."); // Expected output: 2

        // Test removing a song by id
        playlist1.removeById("2");
        System.out.println("Songs in playlist1 after removing song2: " + playlist1.getSongs().size() + " with " + playlist1.getSongs()); // Expected output: 2

        // Test excluding genres from a playlist : here we shall exclude `Rock` songs.
        Playlist filteredPlaylist = playlist1.exclude(List.of(rock));
        System.out.println("Songs in filtered playlist excluding rock: " + filteredPlaylist.getSongs().size()); // Expected output: 1
    }
}

