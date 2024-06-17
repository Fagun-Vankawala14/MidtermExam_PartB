package midtermreview;

import java.util.Scanner;

public class VendingMachineItem {
    private String name;
    private double price;
    private boolean availability;

    public VendingMachineItem(String name, double price, boolean availability) {
        this.name = name;
        this.price = price;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}

public class VendingMachine {
    private VendingMachineItem[] items;

    public VendingMachine(VendingMachineItem[] items) {
        this.items = items;
    }

    public void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible candies:");
        for (int i = 0; i < items.length; i++) {
            String availability = items[i].isAvailable()? "Available" : "Unavailable";
            System.out.println((i+1) + ". " + items[i].getName() + " - $" + items[i].getPrice() + " - " + availability);
        }
    }

    public void selectItem() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of the items you want to purchase:");
        int choice = sc.nextInt();
        
        if (choice < 1 || choice > items.length) {
            System.out.println("Invalid choice. Try again.");
        } else {
            int index = choice - 1;
            if (items[index].isAvailable()) {
                System.out.println("You have selected " + items[index].getName() + " which costs $" + items[index].getPrice());
                System.out.println("Please insert the amount: ");
                double amountInserted = sc.nextDouble();
                
                if (amountInserted >= items[index].getPrice()) {
                    double change = amountInserted - items[index].getPrice();
                    System.out.println("Thanks for your purchase! Your change is $" + change);
                    items[index].setAvailability(false); // Update the item as unavailable after purchase
                } else {
                    System.out.println("Not enough amount inserted. Transaction cancelled.");
                }
            } else {
                System.out.println("Item unavailable.choose another item.");
            }
        }
    }

    public static void main(String[] args) {
        VendingMachineItem[] items = new VendingMachineItem[] {
            new VendingMachineItem("chocolate bar", 1.50, true),
            new VendingMachineItem("sour candy", 1.20, true),
            new VendingMachineItem("soft drink", 1.80, true),
            new VendingMachineItem("potato chips", 2.00, true)
        };
        
        VendingMachine vendingMachine = new VendingMachine(items);
        Scanner sc = new Scanner(System.in);
        while (true) {
            vendingMachine.displayMenu();
            vendingMachine.selectItem();
            System.out.println("Do you want to purchase another item? (yes or no)");
            String continueChoice = sc.next();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("Thanks for using the vending machine!");
    }
}