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
            System.out.println((i+1) + ". " + candies[i] + " - $" + prices[i]);
        }
    }
    
    public void selectItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the item number: ");
        int itemNumber = scanner.nextInt();
        
        if (itemNumber < 1 || itemNumber > candies.length) {
            System.out.println("Error: Invalid item number.");
            return;
        }
        
        int index = itemNumber - 1;
        
        if (!itemAvailability[index]) {
            System.out.println("Error: " + candies[index] + " is out of stock.");
            return;
        }
        
        System.out.println("Selected Item: " + candies[index]);
        System.out.println("Price: $" + prices[index]);
        
        // Perform any other operations related to the selected item
        // ...
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();
                

      }
}
