package e.commerce.ecommerce.business.abstracts;

import e.commerce.ecommerce.business.dto.responses.gets.GetProductResponse;
import e.commerce.ecommerce.business.dto.requests.creates.CreateProductRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateProductRequest;
import e.commerce.ecommerce.business.dto.responses.gets.GetAllProductsResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateProductResponse;
import e.commerce.ecommerce.business.dto.responses.creates.CreateProductResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductsResponse> getAll();
    GetProductResponse getById(int id);
    CreateProductResponse add (CreateProductRequest request);
    UpdateProductResponse update (int id, UpdateProductRequest request);
    void delete (int id);
}