/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreview;

import java.util.Scanner;

public class VendingMachineItem {
    public double price;
    
    public static String[] candies = {"chocolate bar", "sour candy", "soft drink", "potato chips"};
    public static double[] prices = {1.50, 1.20, 1.80, 2.00};
    public static boolean[] itemAvailability = {true, true, true, true}; // Initially all items are available
    
    public VendingMachineItem() {
        // Constructor left blank intentionally
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double givenPrice) {
        price = givenPrice;
    }
    
    public static void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible candies:");
        for (int i = 0; i < 4; i++) {
            String availability = itemAvailability[i] ? "Available" : "Not Available";
            System.out.println((i+1) + ". " + candies[i] + " - $" + prices[i] + " (" + availability + ")");
        }
    }
    
    public static void selectItem(int itemNumber) {
        if (itemNumber < 1 || itemNumber > candies.length) {
            System.out.println("Invalid selection. Please choose a valid item number.");
            return;
        }
        
        int index = itemNumber - 1; // Array index starts from 0, so subtract 1 from itemNumber
        if (itemAvailability[index]) {
            System.out.println("Item " + candies[index] + " selected. Enjoy!");
            itemAvailability[index] = false; // Mark the item as no longer available
        } else {
            System.out.println("Sorry, " + candies[index] + " is not available.");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();
        
        System.out.println("Please enter the number of the item you want to select:");
        int itemNumber = sc.nextInt();
        selectItem(itemNumber);
        
        sc.close();
    }
}
