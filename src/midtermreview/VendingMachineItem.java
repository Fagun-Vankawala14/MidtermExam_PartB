/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreview;

import java.util.Scanner;

public class VendingMachineItem {
    public double price;
    
    private enum Candies{
        CHOCOLATE BARS, SOUR CANDY, SOFT DRINKS, POTATO CHIPS
    }
    
    private enum Prices{
        1.50,1.20,1.80,2.00
    }
    
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
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of the item you wish to purchase: ");
        int itemNumber = sc.nextInt();
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();
        selectItem();
        
                

      }
}
