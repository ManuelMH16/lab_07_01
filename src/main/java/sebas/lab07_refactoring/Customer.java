/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sebas.lab07_refactoring;

/**
 *
 * @author jacks
 */
public class Customer {

    private String name;
    private String phone;  // Almacenado como String simple

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean hasValidPhone() {
        return phone != null && phone.matches("\\d{9}");
    }

    public String getFormattedPhone() {
        if (phone == null || phone.length() != 9) {
            return phone;
        }
        return phone.substring(0, 3) + "-"
                + phone.substring(3, 6) + "-"
                + phone.substring(6);
    }
}
