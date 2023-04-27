package e.commerce.ecommerce.business.dto.requests.creates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInvoiceRequest {
    private int productId;
    private String name;
    private int quantity;
    private String description;
    private LocalDateTime saleTime;
}