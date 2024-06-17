/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreview;

import java.util.Scanner;

public class VendingMachineItem {

    public String candy;
    public double price;

    /* we modify the candies to be an enum so that it is consistent */
    public static String[] candies = {"chocolate bar", "sour candy", "soft drink", "potato chips"};
    public static double[] prices = {1.50, 1.20, 1.80, 2.00};
    public static boolean[] itemAvailability = {true, false, true, true}; // Initially all items are available

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
            System.out.println((i + 1) + ". " + candies[i] + " - $" + prices[i]);
        }
    }

    public static void selectItem() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the candy you wish to purchase: ");
        String candy = sc.nextLine();

        for (int i = 0; i < itemAvailability.length; i++) {
            if (candy.equals(candies[0]) && itemAvailability[0] == true || candy.equals(candies[1]) && itemAvailability[1] == true
                    || candy.equals(candies[2]) && itemAvailability[2] == true || candy.equals(candies[3]) && itemAvailability[3] == true) {
                System.out.println("The candy you have chosen is available!");
                break;
            } else {
                System.out.println("The candy you have chosen is NOT available!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayMenu();
        selectItem();
    }
}
