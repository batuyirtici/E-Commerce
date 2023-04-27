package e.commerce.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "orders")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int totalPrice;
    private Date orderDate;
    private String description;

    @ManyToMany (mappedBy = "orders")
    private List<Product> products;
}