/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermreview;

/**
 *
 * @author sim20
 */

 public enum ItemType {
    CHOCOLATE_BAR("chocolate bar", 1.50, true),
    SOUR_CANDY("sour candy", 1.20, true),
    SOFT_DRINK("soft drink", 1.80, true),
    POTATO_CHIPS("potato chips", 2.00, true);

    private final String name;
    private final double price;
    private boolean isAvailable;

    ItemType(String name, double price, boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        isAvailable = availability;
    }
}     
    

