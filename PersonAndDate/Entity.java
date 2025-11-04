package PersonAndDate;

public abstract class Entity implements Cloneable {
    private String name;
    private Date born;
    private double difficulty;

    //Constructor
    public Entity(String name, Date born, double difficulty) {
        this.name = name;
        this.born = new Date(born);
        this.difficulty = difficulty;
    }

    //Copy Constructor
    public Entity(Entity other) {
        if (other == null) {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        this.name = other.name;
        this.born = new Date(other.born);
        this.difficulty = other.difficulty;
    }

    //Accessor methods
    public String getName() {
        return name;
    }

    public Date getBorn() {
        return new Date(born);
    }
    
    public double getDifficulty() {
        return difficulty;
    }

    //Mutator methods
    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(Date born) {
        this.born = new Date(born);
    }
    
    public void setDifficulty(double difficulty) {
        if (difficulty < 0 || difficulty > 1) {
            System.out.println("Invalid difficulty level. It must be between 0 and 1.");
            return;
        }
        this.difficulty = difficulty;
    }

    // Abstract Methods
    public abstract String entityType();
    public abstract Entity clone();

    //Ticket calculation
    public int getAwardedTicketNumber() {
        return (int) (difficulty * 100);
    }

    //Welcome and Closing Messages
    public String welcomeMessage() {
        return "Welcome! Let’s start the game! This entity is a " + entityType() + "!";
    }

    public String closingMessage() {
        return "Congratulations! The detailed information of the entity you guessed is: " + toString();
    }

    //toString method
    public String toString() {
        return name + ", born on " + born.toString();
    }

    //Equals method
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entity entity = (Entity) obj;
        return name.equals(entity.name) && born.equals(entity.born);
    }
}
