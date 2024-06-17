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
    
    public VendingMachineItem(int itemIndex) {
       if (itemIndex >= 0 && itemIndex < candies.length) {
            if (itemAvailability[itemIndex]) {
                price = prices[itemIndex];
                System.out.println(candies[itemIndex] + " is available for $" + price);
            } else {
                System.out.println(candies[itemIndex] + " is not available.");
            }
        } else {
            System.out.println("Invalid item selection.");
        }
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
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();
                
        System.out.println("Please enter the number of the item you wish to purchase:");
        int choice = sc.nextInt() - 1;

        VendingMachineItem item = new VendingMachineItem(choice);
      }
}
