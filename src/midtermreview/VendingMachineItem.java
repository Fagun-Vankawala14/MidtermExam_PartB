package midtermreview;

import java.util.Scanner;

public class VendingMachineItem {
    private static final String CURRENCY = "$";
    private double priceInDollars;

    private static final String[] SNACKS = {"Chocolate Bar", "Sour Candy", "Soft Drink", "Potato Chips"};
    private static final double[] PRICES_IN_DOLLARS = {1.5, 1.2, 1.8, 2.0};
    private static boolean[] ITEM_AVAILABILITY = {true, true, true, true}; // Initially all items are available

    public VendingMachineItem(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < SNACKS.length) {
            if (ITEM_AVAILABILITY[itemIndex]) {
                this.priceInDollars = PRICES_IN_DOLLARS[itemIndex];
                System.out.println(SNACKS[itemIndex] + " is available for " + CURRENCY + this.priceInDollars);
            } else {
                System.out.println(SNACKS[itemIndex] + " is not available.");
            }
        } else {
            System.out.println("Invalid item selection.");
        }
    }

    public double getPriceInDollars() {
        return this.priceInDollars;
    }

    public void setPriceInDollars(double givenPrice) {
        this.priceInDollars = givenPrice;
    }

    public static void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible snacks:");
        for (int i = 0; i < SNACKS.length; i++) {
            System.out.println((i + 1) + ". " + SNACKS[i] + " - " + CURRENCY + PRICES_IN_DOLLARS[i] + (ITEM_AVAILABILITY[i] ? "" : " (Not available)"));
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