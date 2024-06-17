/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package midtermreview;

/**
 *
 * @author sauravbedi
 */

public class Candies {
    private String name;
    private double price;
    private boolean available;

    public Candies(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true; // By default, candies are available
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}


