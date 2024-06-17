/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public static void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible candies:");
        for (int i = 0; i < 4; i++) {
            System.out.println((i+1) + ". " + candies[i] + " - $" + prices[i]);
        }
    }
    public static void selectItem(int itemnumber){
        if (itemnumber < 1 || itemnumber > 4) {
            System.out.println("The selection is invalid.Please select a valid item number.");
            return;
        }
       
        int index = itemnumber - 1;
        if (itemAvailability[index]) {
            System.out.println("You selected: " + candies[index] + " -: $" + prices[index]);
            System.out.println("Thank you for purchasing the item!");
            itemAvailability[index] = false; 
        } else {
            System.out.println("Sorry, " + candies[index] + " this is sold out.");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();
         System.out.println("Enter the number of items you want to purchase:");
        int itemnumber = sc.nextInt();
        selectItem(itemnumber);      

      }
}
