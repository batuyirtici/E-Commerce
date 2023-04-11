package e.commerce.ecommerce.api.controller;

import e.commerce.ecommerce.business.abstracts.ProductService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateProductRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateProductRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateProductResponse;
import e.commerce.ecommerce.business.dto.responses.gets.GetAllProductsResponse;
import e.commerce.ecommerce.business.dto.responses.gets.GetProductResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateProductResponse;
import e.commerce.ecommerce.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService service;

    @GetMapping
    public List<GetAllProductsResponse> getAll()
    { return service.getAll(); }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable int id)
    { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request)
    { return service.add(request); }

    @PutMapping ("/{id}")
    public UpdateProductResponse update(@PathVariable int id, @RequestBody UpdateProductRequest request)
    { return service.update(id, request); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable int id)
    { service.delete(id); }
}