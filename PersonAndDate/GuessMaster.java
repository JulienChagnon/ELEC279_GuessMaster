//Name: Julien Chagnon
//Student number: 20390465


package PersonAndDate;
import java.util.Scanner;
import java.util.Random;


public class GuessMaster {
    private int numMaxEntities;
    private Entity[] entities;
    private int totalTickets;

    //Constructor
    public GuessMaster() {
        this.numMaxEntities = 0;
        this.entities = new Entity[100];
        this.totalTickets = 0;
    }

    //Method to add cloned entity
    public void addEntity(Entity entity) {
        if (numMaxEntities < 100) {
            entities[numMaxEntities] = entity.clone(); 
            numMaxEntities++;
        } else {
            System.out.println("Error: Maximum entities reached.");
        }
    }

    //Generating random entity
    private int genRandomEntityInd() {
        Random rand = new Random();
        return rand.nextInt(numMaxEntities);
    }

    //Playing GuessMaster using specific entity
    public void playGame(Entity entity) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("****************************");
        System.out.println(entity.welcomeMessage());
        System.out.println("Guess " + entity.getName() + "'s birthday (format: mm/dd/yyyy)");

        while (true) {
            String userInput = scanner.nextLine().trim();

            //Checking for exit command
            if (userInput.equalsIgnoreCase("quit") || userInput.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing! Exiting...");
                System.exit(0);
            }

            //Parse the users input as a date
            try {
                Date userDate = new Date(userInput);
                if (userDate.equals(entity.getBorn())) {
                    int awardedTickets = entity.getAwardedTicketNumber();
                    totalTickets += awardedTickets;
                    System.out.println("************* Bingo! ***************");
                    System.out.println("You won " + awardedTickets + " tickets in this round.");
                    System.out.println("The total number of your tickets is " + totalTickets + ".");
                    System.out.println(entity.closingMessage());
                    break;
                } else if (userDate.precedes(entity.getBorn())) {
                    System.out.println("Incorrect. Try a later date.");
                } else {
                    System.out.println("Incorrect. Try an earlier date.");
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }
    }

    //Playing game for a specific entity index
    public void playGame(int entityInd) {
        if (entityInd >= 0 && entityInd < numMaxEntities) {
            playGame(entities[entityInd]);
        } else {
            System.out.println("Invalid entity index.");
        }
    }

    //Playing game with a randomly selected entity
    public void playGame() {
        if (numMaxEntities == 0) {
            System.out.println("No entities available to play.");
            return;
        }

        while (true) {
            int randomIndex = genRandomEntityInd();
            playGame(randomIndex);
        }
    }

    //Main method to initialize and start game
    public static void main(String[] args) {
        System.out.println("======================");
        System.out.println("GuessMaster 2.0");
        System.out.println("======================");
        System.out.println("Type 'quit' or 'exit' to end the game.");

        //Initialize entities
      
        Politician churchill = new Politician("Winston Churchill", new Date("November", 30, 1874), "Male", "Conservative", 0.25);
        Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);
        Person myCreator = new Person("myCreator", new Date("September", 1, 2000), "Female", 1.0);
        Country usa = new Country("United States", new Date("July", 4, 1776), "Washington D.C.", 0.1);

        GuessMaster gm = new GuessMaster();
        gm.addEntity(churchill);
        gm.addEntity(dion);
        gm.addEntity(myCreator);
        gm.addEntity(usa);

        gm.playGame();
    }
}
