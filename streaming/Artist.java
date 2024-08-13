package streaming.streaming;

/**
 * Note : ceci est une classe abstraite parce qu'on ne veut pas l'instancier, il sert juste de
 * modèle commun pour les classes SoloArtist et GroupArtist.
 */
public abstract class Artist {
    private String id;
    private int creationYear;
    private String artistName;
    private String nationality;

    public Artist(String id, int creationYear, String artistName, String nationality) {
        this.id = id;
        this.creationYear = creationYear;
        this.artistName = artistName;
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
