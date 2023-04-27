package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderBusinessRules {
    private final OrderRepository repository;

    public void checkIfOrderExists (int id)
    { if (!repository.existsById(id)) throw new RuntimeException("Order is not exist!"); }

    public void checkIfNameLength (String name)
    { if (name.length() <= 0) throw new RuntimeException("İsim alanı boş bırakılamaz."); }

    public void checkIfDescriptionLength (String description)
    { if (description.length() <= 0) throw new RuntimeException("Açıklama alanı boş bırakılamaz."); }
}