package PersonAndDate;

public class Singer extends Person {
    private String debutAlbum;
    private Date debutAlbumReleaseDate;

    //Constructor
    public Singer(String name, Date born, String gender, String debutAlbum, Date debutAlbumReleaseDate, double difficulty) {
        super(name, born, gender, difficulty);
        this.debutAlbum = debutAlbum;
        this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate);
    }

    //Copy Constructor
    public Singer(Singer other) {
        super(other);
        this.debutAlbum = other.debutAlbum;
        this.debutAlbumReleaseDate = new Date(other.debutAlbumReleaseDate);
    }

    //Accessor methods
    public String getDebutAlbum() {
        return debutAlbum;
    }

    public Date getDebutAlbumReleaseDate() {
        return new Date(debutAlbumReleaseDate);
    }

    //Mutator methods
    public void setDebutAlbum(String debutAlbum) {
        this.debutAlbum = debutAlbum;
    }

    public void setDebutAlbumReleaseDate(Date debutAlbumReleaseDate) {
        this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate);
    }

    //Abstract method implementation
    public String entityType() {
        return "This entity is a singer!";
    }

    //Cloning method
    public Singer clone() {
        return new Singer(this);
    }

    //Overriding toString method
    public String toString() {
        return super.toString() + ", \nDebut Album: " + debutAlbum + ", \nReleased on: " + debutAlbumReleaseDate.toString();
    }
}