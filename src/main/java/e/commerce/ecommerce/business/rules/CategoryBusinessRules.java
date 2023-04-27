package e.commerce.ecommerce.business.rules;

import e.commerce.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository repository;

    public void checkIfCategoryExists(int id)
    { if (!repository.existsById(id)) throw new RuntimeException("Category is not exist!"); }

    public void CheckIfCategoryNameLength (String name){
        if (name.length() <= 0) throw new RuntimeException("Name field cannot be left blank!");
    }
}
