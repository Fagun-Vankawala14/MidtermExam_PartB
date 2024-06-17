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
    
    public static void selectItem() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of item from list: ");
        int number = scan.nextInt();
        
        if (number < 1 || number > candies.length) {
            System.out.println(" ");
        } else {
            int index = number- 1;
            if (itemAvailability[index]) {
                System.out.println("Candy is " + candies[index] + " having price" + prices[index]);
                System.out.println("Enter amount: ");
                double amount = scan.nextDouble();
                
                if (amount >= prices[index]) {
                    double change = amount - prices[index];
                    System.out.println("Thank you for your purchase! Your change is $" + change);
                    itemAvailability[index] = false; 
                } else {
                    System.out.println("Amount is not sufficient.");
                }
            } else {
                System.out.println("Item not available. Choose another one.");
            }
        }
    }
    
    
    public static void main(String[] args) {

        
       
            displayMenu();
            selectItem();
            
           System.out.println("Purchase done");

    
    }
}
