package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceBusinessRules {
    private final InvoiceRepository repository;

    public void checkIfInvoiceExists(int id)
    { if (!repository.existsById(id)) throw new RuntimeException("Fatura Bulunamadı!"); }
}
