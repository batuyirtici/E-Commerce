package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;

    public void checkIfProductExists(int id)
    { if (!repository.existsById(id)) throw new RuntimeException("Product is not exist!"); }

    public void checkIfPriceValue(double price)
    { if (price <= 0) throw new RuntimeException("Product price must be greater than 0."); }

    public void checkIfQuantityValue(int quantity)
    { if (quantity < 0 ) throw new RuntimeException("The quantity of products cannot be less than 0."); }

    public void checkIfDescriptionValue (String description)
    { if ((description.length() < 10) || (description.length() >50 ))
        throw new RuntimeException("The description must contain at least 10 characters and at most 50 characters."); }
}
