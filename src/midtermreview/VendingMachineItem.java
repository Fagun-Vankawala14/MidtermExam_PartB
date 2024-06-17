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
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Select a number for selecting the items from vending machine(1-4): ");
        
        int selectedItem = sc.nextInt();

        if (selectedItem < 1 || selectedItem > candies.length) 
        {
            System.out.println("Number is not in list. Please try again");
        } 
        else 
        {
            int indexOfItem = selectedItem - 1;
            
            if (itemAvailability[indexOfItem]) 
            {
                System.out.println("Here is your purchased item which is " + candies[indexOfItem]);
                
                itemAvailability[indexOfItem] = false; 
                
                System.out.println("Thank you for purchasing the item from vending machine.");
            } 
            else 
            {
                System.out.println("Sorry the item is not available at the moment.");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();
        selectItem();      

      }
}
