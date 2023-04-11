package e.commerce.ecommerce.business.dto.responses.gets;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductsResponse {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
}