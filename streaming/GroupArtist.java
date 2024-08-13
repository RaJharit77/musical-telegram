package streaming.streaming;

import java.util.ArrayList;
import java.util.List;

/**
 * Note : pas grand chose en fait... juste un ensemble d'artistes solo, c'est tout.
 */
public class GroupArtist extends Artist {
    private List<SoloArtist> members;

    public GroupArtist(
            String id,
            int creationYear,
            String artistName,
            String nationality,
            List<SoloArtist> members
    ) {
        super(id, creationYear, artistName, nationality);
        this.members = members;
    }

    public GroupArtist(
            String id,
            int creationYear,
            String artistName,
            String nationality
    ) {
        super(id, creationYear, artistName, nationality);
        this.members = new ArrayList<>();
    }

    public List<SoloArtist> getMembers() {
        return members;
    }

    public void setMembers(List<SoloArtist> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "GroupArtist{" +
                "name=" + this.getArtistName() +
                '}';
    }
}
