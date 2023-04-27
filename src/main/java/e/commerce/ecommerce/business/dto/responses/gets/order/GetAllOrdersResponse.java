package e.commerce.ecommerce.business.dto.responses.gets.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllOrdersResponse {
    private int id;
    private String name;
    private int totalPrice;
    private Date orderDate;
    private String description;
}