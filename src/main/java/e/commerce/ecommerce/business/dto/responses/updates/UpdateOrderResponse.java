package e.commerce.ecommerce.business.dto.responses.updates;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrderResponse {
    private int id;
    private String name;
    private int totalPrice;
    private Date orderDate;
    private String description;
}
