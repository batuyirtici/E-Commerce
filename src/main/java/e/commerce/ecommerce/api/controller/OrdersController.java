package e.commerce.ecommerce.api.controller;

import e.commerce.ecommerce.business.abstracts.CategoryService;
import e.commerce.ecommerce.business.abstracts.OrderService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateCategoryRequest;
import e.commerce.ecommerce.business.dto.requests.creates.CreateOrderRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateCategoryRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateOrderRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateCategoryResponse;
import e.commerce.ecommerce.business.dto.responses.creates.CreateOrderResponse;
import e.commerce.ecommerce.business.dto.responses.gets.category.GetAllCategoriesResponse;
import e.commerce.ecommerce.business.dto.responses.gets.category.GetCategoryResponse;
import e.commerce.ecommerce.business.dto.responses.gets.order.GetAllOrdersResponse;
import e.commerce.ecommerce.business.dto.responses.gets.order.GetOrderResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateCategoryResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateOrderResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping ("/api/orders")
public class OrdersController {
    private final OrderService service;

    @GetMapping
    public List<GetAllOrdersResponse> getAll()
    { return service.getAll(); }

    @GetMapping ("/{id}")
    public GetOrderResponse getById (@PathVariable int id)
    { return service.getById(id); }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public CreateOrderResponse add (@Valid @RequestBody CreateOrderRequest request)
    { return service.add(request); }

    @PutMapping("/{id}")
    public UpdateOrderResponse update (@PathVariable int id, @Valid @RequestBody UpdateOrderRequest request)
    { return service.update(id, request); }

    @DeleteMapping ("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete (@PathVariable int id)
    { service.delete(id); }
}
