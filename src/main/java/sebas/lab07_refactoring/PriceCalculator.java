/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sebas.lab07_refactoring;

/**
 *
 * @author jacks
 */
public class PriceCalculator {

    private double basePrice;
    private int quantity;

    public PriceCalculator(double basePrice, int quantity) {
        this.basePrice = basePrice;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        double price = this.basePrice * this.quantity;
        double discount;

        if (price > 1000) {
            discount = price * 0.15;
        } else if (price > 500) {
            discount = price * 0.10;
        } else {
            discount = price * 0.05;
        }

        double subtotal = price - discount;
        double tax = subtotal * 0.18;

        return subtotal + tax;
    }
}
