package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.common.constants.Messages;
import e.commerce.ecommerce.core.exceptions.BusinessException;
import e.commerce.ecommerce.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderBusinessRules {
    private final OrderRepository repository;

    public void checkIfOrderExists (int id)
    { if (!repository.existsById(id)) throw new BusinessException(Messages.Order.NotExists); }

    public void checkIfNameLength (String name)
    { if (name.length() <= 0) throw new BusinessException(Messages.Order.NameLength); }

    public void checkIfDescriptionLength (String description)
    { if (description.length() <= 0) throw new BusinessException(Messages.Order.DescriptionLength); }
}