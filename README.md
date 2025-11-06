# LABORATORIO: REFACTORIZACIÓN Y CODE SMELLS
**Ingeniería de Software 2 - Universidad de Lima**  
**Curso: Ingeniería de Software 2 (2025-2)**  
**Jefe de Prácticas: Sebastián Chávarry**




## PARTE 1: IDENTIFICACIÓN DE CODE SMELLS

Para cada uno de los siguientes fragmentos de código, identifica el **code smell** que presenta. En un archivo Markdown indicar tu respuesta explicando por qué

### Pregunta 1.1 

```java
public class ReportGenerator {
    public void generateReport(String customerName, String customerEmail, 
    String customerPhone, String customerAddress,
    String customerCity, String customerCountry,
    String customerZipCode, String customerTaxId,
    Date startDate, Date endDate,
    String reportType,
    String format, boolean includeDetails, 
    boolean includeGraphs) {

        System.out.println("Generating report for: " + customerName);
    
    }
}
```

**¿Qué code smell presenta este código?**

- A) Duplicate Code
- B) Long Method
- C) Long Parameter List
- D) Large Class
- E) Data Clumps

---

### Pregunta 1.2

```java
public class OrderProcessor {
    public double calculateTotal(Order order) {
        double total = 0;
        
        if (order.getType() == 1) {
            total = order.getAmount() * 0.9; // Descuento estándar
        } else if (order.getType() == 2) {
            total = order.getAmount() * 0.85; // Descuento VIP
        } else if (order.getType() == 3) {
            total = order.getAmount() * 0.8; // Descuento Premium
        } else if (order.getType() == 4) {
            total = order.getAmount() * 0.75; // Descuento Corporativo
        } else {
            total = order.getAmount();
        }
        
        return total;
    }
}
```

**¿Qué code smell presenta este código?**

- A) Primitive Obsession
- B) Switch Statements
- C) Feature Envy
- D) Shotgun Surgery
- E) Lazy Class

---

### Pregunta 1.3

```java
public class Invoice {
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String productCategory;
    
    private Date invoiceDate;
    private String invoiceNumber;
    private double invoiceTotal;
    private String invoiceStatus;
    
    private String paymentMethod;
    private Date paymentDate;
    private String paymentReference;
    
    private String shippingAddress;
    private String shippingMethod;
    private Date shippingDate;
    private String trackingNumber;
    
    // 30+ métodos que manejan cliente, producto, factura, pago y envío
    public void processCustomer() { /* ... */ }
    public void processProduct() { /* ... */ }
    public void processPayment() { /* ... */ }
    public void processShipping() { /* ... */ }
}
```

**¿Qué code smell presenta este código?**

- A) Large Class (God Class)
- B) Data Clumps
- C) Lazy Class
- D) Duplicate Code
- E) Middle Man

---

### Pregunta 1.4

```java
public class Employee {
    public void printEmployeeInfo(String name, String address, String phone) {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }
    
    public void saveEmployee(String name, String address, String phone) {
        System.out.println("Saving to DB: " + name + ", " + address + ", " + phone);
    }
    
    public void sendEmail(String name, String address, String phone) {
        System.out.println("Sending email to: " + name);
    }
    
    public void generateReport(String name, String address, String phone) {
        System.out.println("Report for: " + name + " at " + address);
    }
}
```

**¿Qué code smell presenta este código?**

- A) Long Parameter List
- B) Data Clumps
- C) Duplicate Code
- D) Primitive Obsession
- E) Feature Envy

---

### Pregunta 1.5

```java
public class Customer {
    private int status; // 0=Normal, 1=VIP, 2=Premium
    private int type;   // 0=Individual, 1=Empresa
    private int level;  // 0=Bronce, 1=Plata, 2=Oro
    
    public double getDiscount() {
        if (status == 0) return 0.0;
        if (status == 1) return 0.1;
        if (status == 2) return 0.2;
        return 0.0;
    }
    
    public String getStatusName() {
        if (status == 0) return "Normal";
        if (status == 1) return "VIP";
        if (status == 2) return "Premium";
        return "Unknown";
    }
}
```

**¿Qué code smell presenta este código?**

- A) Switch Statements
- B) Primitive Obsession
- C) Data Class
- D) Lazy Class
- E) Speculative Generality

---

## PARTE 2: APLICACIÓN DE TÉCNICAS DE REFACTORIZACIÓN

### Ejercicio 2.1: Extract Method

**Código Original (OrderService.java):**

```java
package sebas.lab07_refactoring;

public class OrderService {
    public void processOrder(Order order) {
        // Validar orden
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have items");
        }
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }
        
        // Calcular total
        double subtotal = 0;
        for (OrderItem item : order.getItems()) {
            subtotal += item.getPrice() * item.getQuantity();
        }
        double tax = subtotal * 0.18;
        double total = subtotal + tax;
        order.setTotal(total);
        
        // Guardar orden
        System.out.println("Saving order to database...");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Total: " + total);
        
        // Enviar confirmación
        System.out.println("Sending confirmation message to: "
                + order.getCustomer().getFormattedPhone());
        System.out.println("Dear " + order.getCustomer().getName());
        System.out.println("Your order #" + order.getId()
                + " has been confirmed.");
        System.out.println("Total: $" + total);
    }
}
```

**Instrucciones:**
Aplica **Extract Method** para separar las responsabilidades en métodos individuales. Crea al menos 4 métodos específicos.

### Ejercicio 2.2: Replace Data Value with Object

**Código Original (Customer.java):**

```java
package sebas.lab07_refactoring;

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
```

**Instrucciones:**
Aplica **Replace Data Value with Object** para crear una clase `PhoneNumber` que encapsule el número de teléfono y su comportamiento.


### Ejercicio 2.3: Replace Temp with Query

**Código Original (PriceCalculator.java):**

```java
package sebas.lab07_refactoring;

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
```

**Instrucciones:**
Aplica **Replace Temp with Query** para eliminar las variables temporales (`price`, `discount`, `subtotal`, `tax`), reemplazándolas con métodos que calculen estos valores.



