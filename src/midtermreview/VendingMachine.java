/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermreview;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author sneh
 */
public class VendingMachine {
    private List<VendingMachineItem> items;
    private Scanner scanner;

    public VendingMachine() {
        items = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeItems();
    }

    private void initializeItems() {
        items.add(new VendingMachineItem("Chocolate Bar", 1.50, true));
        items.add(new VendingMachineItem("Sour Candy", 1.20, true));
        items.add(new VendingMachineItem("Soft Drink", 1.80, true));
        items.add(new VendingMachineItem("Potato Chips", 2.00, true));
    }
    
    public void displayMenu() {
        System.out.println("Welcome to the vending machine, here is a list of the possible candies:");
        for (int i = 0; i < items.size(); i++) {
            VendingMachineItem item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - $" + item.getPrice() + " (Stock: " + (item.isIsAvailable() ? "Available" : "Out of Stock"));
        }
    }
    
    public void selectItem() {
        System.out.print("Enter the item number: ");
        int itemNumber = scanner.nextInt();

        if (itemNumber < 1 || itemNumber > items.size()) {
            System.out.println("Error: Invalid item number.");
            return;
        }
        
        VendingMachineItem selectedItem = items.get(itemNumber - 1);

        if (!selectedItem.isIsAvailable()) {
            System.out.println("Error: " + selectedItem.getName() + " is out of stock.");
            return;
        }

        System.out.println("Selected Item: " + selectedItem.getName());
        System.out.println("Price: $" + selectedItem.getPrice());
    }
}
