package midtermreview;

import java.util.Scanner;

public class VendingMachineItem {
    private double price;
    
    private static String[] candies = {"chocolate bar", "sour candy", "soft drink", "potato chips"};
    private static double[] prices = {1.50, 1.20, 1.80, 2.00};
    private static boolean[] itemAvailability = {true, true, true, true}; // Initially all items are available
    
    public VendingMachineItem() {
        // Constructor left blank intentionally
    }
    
   
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double givenPrice) {
        price = givenPrice;
    }
    
  
    public static String[] getCandies() {
        return candies;
    }
    
    public static void setCandies(String[] newCandies) {
        candies = newCandies;
    }
    

    public static double[] getPrices() {
        return prices;
    }
    
    public static void setPrices(double[] newPrices) {
        prices = newPrices;
    }
    
   
    public static boolean[] getItemAvailability() {
        return itemAvailability;
    }
    
    public static void setItemAvailability(boolean[] newItemAvailability) {
        itemAvailability = newItemAvailability;
    }
    
    public static void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible candies:");
        for (int i = 0; i < 4; i++) {
            System.out.println((i+1) + ". " + candies[i] + " - $" + prices[i]);
        }
    }
    
    public static void selectItem(int itemNumber) {
        if (itemNumber < 1 || itemNumber > candies.length) {
            System.out.println("Invalid selection. Please select a valid item number.");
        } else {
            if (itemAvailability[itemNumber - 1]) {
                System.out.println("You have selected " + candies[itemNumber - 1] + " for $" + prices[itemNumber - 1] + ".");
            } else {
                System.out.println("Sorry, " + candies[itemNumber - 1] + " is not available.");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();
        System.out.print("Please enter the number of the item you wish to purchase: ");
        int itemNumber = sc.nextInt();
        selectItem(itemNumber);
    }
}
