import java.io.*;
import java.util.Scanner;

/**
 * 
 * COP 3530: Project 3 – Linked lists
 * 
 * Main class that prompts user for file name entry, displays options, prompts user for option input,
 * and displays respective methods and operations
 * 
 * @author Leila Lokman
 * @version 10/27/2023
 */

public class Project3 {
	public static Country[] countries = new Country[128];
    private Stack stack;
    private PriorityQ priorityQueue;
    public static void main(String[] args) {
    	int choice;
        Scanner scanner = new Scanner(System.in);
        Project3 project = new Project3();
        System.out.println("COP3530 Project 3");
		System.out.println("Instructor: Xudong Liu");
		System.out.println("");
		System.out.println("Linked Lists");

        System.out.print("Enter the name of the CSV file: ");
        String fileName = scanner.nextLine();

        // Create a stack
        Stack countryStack = new Stack();
        
        // Create a priority queue
        PriorityQ priorityQueue = new PriorityQ();

        loadDataFromFile(fileName, countryStack, priorityQueue);

        System.out.println("");
        System.out.println("Stack Contents:");

       	System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Name", "Capital", "GDPPC", "APC", "HappinessIndex");
   		System.out.println("---------------------------------------------------------------------------------");
        countryStack.recursivePrintStack();

        System.out.println("");
        System.out.println("\nPriority Queue Contents:");
        //System.out.println("Name\tCapitol\tGDPPC\tAPC\tHappinessIndex");
       // System.out.println("-------------------------------------------------------");
      
       	System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Name", "Capital", "GDPPC", "APC", "HappinessIndex");
   		System.out.println("---------------------------------------------------------------------------------");
        priorityQueue.recursivePrintPriorityQ();
        
        //list options in a loop
        do {
        	displayMenu();
        
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Invalid choice, enter 1-3");
            displayMenu();
        }
            choice = scanner.nextInt();
            
            //switch statement for user input
            switch(choice) {
            
            case 1:
                System.out.print("Enter a happiness interval in the format [x,y]: ");
                String inputLine = scanner.next();

                try {
                    String[] intervalParts = inputLine.replaceAll("\\[|\\]", "").split(",");
                    if (intervalParts.length == 2) {
                        double start = Double.parseDouble(intervalParts[0]);
                        double end = Double.parseDouble(intervalParts[1]);

                        if (start <= end) {
                            boolean deleted = priorityQueue.intervalDelete(start, end);
                            if (deleted) {
                            	System.out.println("");
                                System.out.println("Countries in the interval [" + start + ", " + end + "] have been deleted.");
                            } else {
                            	System.out.println("");
                                System.out.println("No countries in the specified interval found and deleted.");
                            }
                        } else {
                            System.out.println("Invalid interval, first number must be no bigger than the second.");
                            
                        }
                    } else {
                        System.out.println("Invalid format. Please use [x,y] format");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid format. Please enter valid numeric values.");
                }
                break;
            case 2:
            	System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Name", "Capital", "GDPPC", "APC", "HappinessIndex");
           		System.out.println("---------------------------------------------------------------------------------");
                priorityQueue.recursivePrintPriorityQ();
            	break;
            case 3:
            	System.out.println("");
                System.out.println("Have a good day!");
                break;
            default:
                System.out.println("Invalid choice, enter 1-3");
            }
        } while (choice != 3);
        
        	//System.out.println("\nHave a good day!\n");
        	scanner.close();
    }
    
/**
 * method that loads data from file entered by user
 *      
 * @param fileName file from userinput
 * @param stack saving data into the stack class
 * @param priorityQueue saving data into the priorityqueue class
 * @return void
 */
    public static void loadDataFromFile(String fileName, Stack stack, PriorityQ priorityQueue) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            String line;

            // Skip the header line
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                String[] countryData = line.split(",");
                if (countryData.length == 8) {
                    String name = countryData[0];
                    String capital = countryData[1];
                    long population = Long.parseLong(countryData[2]);
                    double GDP = Double.parseDouble(countryData[3]);
                    long area = Long.parseLong(countryData[4]);
                    double happinessIndex = Double.parseDouble(countryData[5]);
                    //double GDPPC = Double.parseDouble(countryData[6]);
                    //double APC = Double.parseDouble(countryData[7]);

                    Country country = new Country(name, capital, population, GDP, area, happinessIndex);
                    stack.push(country);
                    priorityQueue.insert(country);
                }
            }
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        }
    }
 /**
  * Displays menu options to user
  */
    public static void displayMenu() {
    	System.out.println("");
        System.out.println("1) Enter a happiness interval for deletions on priority queue");
        System.out.println("2) Print the priority queue");
        System.out.println("3) Exit program");
        System.out.print("Enter your choice: ");
    }
}



