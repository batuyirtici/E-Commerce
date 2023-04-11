package e.commerce.ecommerce.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import e.commerce.ecommerce.entities.Product;
import e.commerce.ecommerce.business.abstracts.ProductService;
import e.commerce.ecommerce.business.dto.responses.gets.GetProductResponse;
import e.commerce.ecommerce.business.dto.requests.creates.CreateProductRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateProductRequest;
import e.commerce.ecommerce.business.dto.responses.gets.GetAllProductsResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateProductResponse;
import e.commerce.ecommerce.business.dto.responses.creates.CreateProductResponse;

import org.modelmapper.ModelMapper;
import e.commerce.ecommerce.repository.ProductRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {
    private final ModelMapper mapper;
    private final ProductRepository repository;

    @Override
    public List<GetAllProductsResponse> getAll() {
        List<Product> products = repository.findAll();

        List<GetAllProductsResponse> response = products
                .stream()
                .map(product -> mapper.map(product, GetAllProductsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetProductResponse getById(int id) {
        checkIfProductExists(id);
        Product product = repository.findById(id).orElseThrow();

        GetProductResponse response = mapper.map(product, GetProductResponse.class);

        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        checkIfPriceValue(request.getPrice());
        checkIfQuantityValue(request.getQuantity());
        checkIfDescriptionValue(request.getDescription());
        Product product = mapper.map(request, Product.class);
        product.setId(0);
        repository.save(product);

        CreateProductResponse response = mapper.map(product, CreateProductResponse.class);

        return response;
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest request) {
        checkIfProductExists(id);
        checkIfPriceValue(request.getPrice());
        checkIfQuantityValue(request.getQuantity());
        checkIfDescriptionValue(request.getDescription());
        Product product = mapper.map(request, Product.class);
        product.setId(id);
        repository.save(product);

        UpdateProductResponse response = mapper.map(product, UpdateProductResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        checkIfProductExists(id);
        repository.deleteById(id);
    }

    // Business Rules

    private void checkIfProductExists(int id)
    { if (!repository.existsById(id)) throw new RuntimeException("Product is not exist!"); }

    private void checkIfPriceValue(double price)
    { if (price <= 0) throw new RuntimeException("Product price must be greater than 0."); }

    private void checkIfQuantityValue(int quantity)
    { if (quantity < 0 ) throw new RuntimeException("The quantity of products cannot be less than 0."); }

    private void checkIfDescriptionValue (String description)
    { if ((description.length() < 10) || (description.length() >50 ))
        throw new RuntimeException("The description must contain at least 10 characters and at most 50 characters."); }
}