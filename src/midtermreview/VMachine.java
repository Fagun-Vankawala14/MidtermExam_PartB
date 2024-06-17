/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermreview;

import java.util.Scanner;

public class VMachine {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VMachine machine = new VMachine();
        
            machine.displayMenu();
            machine.selectItem(scanner);
            
           
        System.out.println("Purchase complete");
        scanner.close();
    }

    private VendingMachineItem[] items;

    public VMachine() {
        items = new VendingMachineItem[]{
            new VendingMachineItem("chocolate bar", 1.50),
            new VendingMachineItem("sour candy", 1.20),
            new VendingMachineItem("soft drink", 1.80),
            new VendingMachineItem("potato chips", 2.00)
        };
    }

    public void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of candies.");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i].getName() + " - $" + items[i].getPrice());
        }
    }

    public void selectItem(Scanner scanner) {
        System.out.println("Enter the number of the item from the list: ");
        int number = scanner.nextInt();
        
        if (number < 1 || number > items.length) {
            System.out.println("Invalid selection. Please try again.");
        } else {
            VendingMachineItem selectedItem = items[number - 1];
            if (selectedItem.isAvailable()) {
                System.out.println("Candy is: " + selectedItem.getName() + " having Price: $" + selectedItem.getPrice());
                System.out.println("Enter amount: ");
                double amount = scanner.nextDouble();
                
                if (amount >= selectedItem.getPrice()) {
                    double change = amount - selectedItem.getPrice();
                    System.out.println("Your change is $" + change);
                    selectedItem.setAvailable(false);
                } else {
                    System.out.println("Amount is not sufficient.");
                }
            } else {
                System.out.println("Item not available. Choose another.");
            }
        }
    }
}



   

