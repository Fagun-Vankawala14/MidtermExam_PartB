/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreview;

import java.util.Scanner;

public class VendingMachineItem {
    

    // Enum for candies
    public enum Candies {
        CHOCOLATEBAR, SOURCANDY, SOFTDRINK, POTATOCHIPS
    }

    // Enum for prices
    public enum Prices {
        CHOCOLATEBAR(1.50), SOURCANDY(1.20), SOFTDRINK(1.80), POTATOCHIPS(2.00);

        private final double price;

        Prices(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }
    private double price;
    private Candies candies;
    private Prices enumprice;


    
    private static boolean[] itemAvailability = {true, true, true, true}; // Initially, all items are available

    public VendingMachineItem() {
        // Constructor left blank intentionally
    }

     public double getPrice() {
            return price;
        }

    public void setPrices(double givenPrices) {
        price = givenPrices;
    }

    public static void displayMenu() {
        System.out.println("list of the possible candies:");
        for (Candies candies : Candies.values()) {
            System.out.println(candies);
        }
    }

    public static void selectItem(int Number) {
        if (Number < 1 || Number > 4) {
            System.out.println("Invalid selection item number from(1 to4)");
            return;
        }
        if (itemAvailability[Number - 1]) {
            System.out.println("Candies are " + Candies.values()[Number - 1] + Prices.values()[Number - 1].getPrice());
            itemAvailability[Number - 1] = false; 
        } else {
            System.out.println("no candies"+ Candies.values()[Number - 1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();
        System.out.println("Please enter the number of the item(1to4):");
        int select = sc.nextInt();
        selectItem(select);
    }
}

