package PersonAndDate;
import java.util.Scanner;

public class Date
{
    private String month;
    private int day;
    private int year; 

    //Default constructor to initialize at 01/01/1000
    public Date( ){
        month = "January";
        day = 1;
        year = 1000;
    }

    //Constructor accepting month as String
    public Date(String monthString, int day, int year){
        setDate(monthString, day, year);
    }

    //Constructor accepting month as integer
    public Date(int monthInt, int day, int year){
        setDate(monthInt, day, year);
    }

    //Constructor that only takes year, defaults to January 1st
    public Date(int year){
        setDate(1, 1, year);
    }

    //Copy constructor for copy of another Date object
    public Date(Date aDate){
        if (aDate == null)
        {
             System.out.println("Fatal Error.");
             System.exit(0);
        }

        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }
    
    //Constructor to parse string in mm/dd/yyyy format
    public Date(String strDate) {
        String[] parts = strDate.split("/");
        if (parts.length != 3 || !isNumeric(parts[0]) || !isNumeric(parts[1]) || !isNumeric(parts[2])) {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        int month = Integer.parseInt(parts[0]);
        int day = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        setDate(month, day, year);
    }

    //Method to check for only digits
    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    //Mutator method to initialize integer month
    public void setDate(int monthInt, int day, int year){
        if (dateOK(monthInt, day, year)){
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else{
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    //Mutator method to initialize string month
    public void setDate(String monthString, int day, int year)
    {
        if (dateOK(monthString, day, year)){
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else{
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }

    //Mutator to update year only
    public void setDate(int year){
        setDate(1, 1, year);
    }

    public void setYear(int year){
        if ( (year < 1000) || (year > 9999) ){
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.year = year;
    }
    public void setMonth(int monthNumber)
    {
        if ((monthNumber <= 0) || (monthNumber > 12))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            month = monthString(monthNumber);
    }

    public void setDay(int day)
    {
        if ((day <= 0) || (day > 31))
        {
            System.out.println("Fatal Error");
            System.exit(0);
        }
        else
            this.day = day;
    }

    public int getMonth( )
    {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equals("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equals("November"))
            return 11;
        else if (month.equals("December"))
            return 12;
        else
        {
            System.out.println("Fatal Error");
            System.exit(0);
            return 0; //Needed to keep the compiler happy
        }
    }

    public int getDay( )
    {
        return day;
    }

    public int getYear( )
    {
        return year;
    }

    public String toString( )
    {
        return (month + " " + day + ", " + year);
        //value will be shown when debugging
        //a very useful feature for dubugging
        //also useful in println(), which
        //automatically call toString();
    }

    public boolean equals(Date otherDate) {
        return ( (getMonth() == otherDate.getMonth()) // Compare numerical values
                  && (day == otherDate.day) && (year == otherDate.year) );
    }


    public boolean precedes(Date otherDate)
    {
        return ( (year < otherDate.year) ||
           (year == otherDate.year && getMonth( ) < otherDate.getMonth( )) ||
           (year == otherDate.year && month.equals(otherDate.month)
                                         && day < otherDate.day) );
    }

    //Method to for user to input date through console (Not used)
    public void readInput( )
    {
        boolean tryAgain = true;
        Scanner keyboard = new Scanner(System.in);
        while (tryAgain)
        {
            System.out.println("Enter month, day, and year.");
              System.out.println("Do not use a comma.");
            String monthInput = keyboard.next( );
            int dayInput = keyboard.nextInt( );
            int yearInput = keyboard.nextInt( );
            if (dateOK(monthInput, dayInput, yearInput) )
            {
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }
            else
                System.out.println("Illegal date. Reenter input.");
         }
    }

  //Ensuring integer month date fits calendar format
    private boolean dateOK(int monthInt, int dayInt, int yearInt)
    {
        return ( (monthInt >= 1) && (monthInt <= 12) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    //Ensuring string month date fits calendar format
    private boolean dateOK(String monthString, int dayInt, int yearInt)
    {
        return ( monthOK(monthString) &&
                 (dayInt >= 1) && (dayInt <= 31) &&
                 (yearInt >= 1000) && (yearInt <= 9999) );
    }

    //Ensures month string is written correctly
    private boolean monthOK(String month)
    {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December") );
    }

    //Converting month integer to string
    private String monthString(int monthNumber)
    {
        switch (monthNumber)
        {
        case 1:
            return "January";
        case 2:
            return "February";
        case 3:
            return "March";
        case 4:
            return "April";
        case 5:
            return "May";
        case 6:
            return "June";
        case 7:
            return "July";
        case 8:
            return "August";
        case 9:
            return "September";
        case 10:
            return "October";
        case 11:
            return "November";
        case 12:
            return "December";
        default:
            System.out.println("Fatal Error");
            System.exit(0);
            return "Error"; //to keep the compiler happy
        }
    }
}
