package e.commerce.ecommerce.business.dto.requests.updates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoiceRequest {
    private int saleId;
    private String productName;
    private String productDescription;
    private double price;
    private int quantity;
    private LocalDateTime saleTime;
}