package streaming;

import java.time.LocalDate;

/**
 * Note: Pas vraiment de note particulière ici... juste un héritage et c'est tout.
 */
public class SoloArtist extends Artist {
    private String firstName;
    private String lastName;
    private LocalDate birthdate;

    public SoloArtist(
            String id,
            int creationYear,
            String artistName,
            String nationality,
            String firstName,
            String lastName,
            LocalDate birthdate
    ) {
        super(id, creationYear, artistName, nationality);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "SoloArtist{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
