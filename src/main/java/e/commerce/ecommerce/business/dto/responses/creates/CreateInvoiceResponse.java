package e.commerce.ecommerce.business.dto.responses.creates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceResponse {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private double totalPrice;
    private LocalDateTime saleTime;
}
