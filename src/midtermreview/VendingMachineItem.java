/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreview;

import java.util.Scanner;

public class VendingMachineItem {
    private double price;
    
    private static final String[] CANDIES = {"chocolate bar", "sour candy", "soft drink", "potato chips"};
    private static final double[] PRICES = {1.50, 1.20, 1.80, 2.00};
    private static final boolean[] ITEM_AVAILABILITY = {true, true, true, true}; // Initially all items are available

    public VendingMachineItem(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < CANDIES.length) {
            if (ITEM_AVAILABILITY[itemIndex]) {
                this.price = PRICES[itemIndex];
                System.out.println(CANDIES[itemIndex] + " is available for $" + this.price);
            } else {
                System.out.println(CANDIES[itemIndex] + " is not available.");
            }
        } else {
            System.out.println("Invalid item selection.");
        }
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double givenPrice) {
        this.price = givenPrice;
    }

    public static void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible candies:");
        for (int i = 0; i < CANDIES.length; i++) {
            System.out.println((i + 1) + ". " + CANDIES[i] + " - $" + PRICES[i] + (ITEM_AVAILABILITY[i] ? "" : " (Not available)"));
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