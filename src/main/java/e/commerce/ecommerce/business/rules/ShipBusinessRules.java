package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.repository.ShipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShipBusinessRules {
    ShipRepository repository;

    public void checkIfShipExists(int id)
    { if (!repository.existsById(id)) throw new RuntimeException("Kargo Bulunamadı"); }

    public void checkIfShipNoLength(String shipNo)
    { if (shipNo.length() <= 0) throw new RuntimeException("Kargo Numarası boş olamaz!"); }
}
