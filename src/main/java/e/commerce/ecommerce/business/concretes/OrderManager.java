package e.commerce.ecommerce.business.concretes;

import e.commerce.ecommerce.business.abstracts.OrderService;
import e.commerce.ecommerce.business.dto.requests.creates.CreateOrderRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateOrderRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateOrderResponse;
import e.commerce.ecommerce.business.dto.responses.gets.order.GetAllOrdersResponse;
import e.commerce.ecommerce.business.dto.responses.gets.order.GetOrderResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateOrderResponse;
import e.commerce.ecommerce.business.rules.OrderBusinessRules;
import e.commerce.ecommerce.entities.Order;
import e.commerce.ecommerce.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final ModelMapper mapper;
    private final OrderBusinessRules rules;
    private final OrderRepository repository;

    @Override
    public List<GetAllOrdersResponse> getAll() {
        List<Order> orders = repository.findAll();

        List<GetAllOrdersResponse> responses = orders
                .stream()
                .map(order -> mapper.map(order, GetAllOrdersResponse.class))
                .toList();

        return responses;
    }

    @Override
    public GetOrderResponse getById(int id) {
        rules.checkIfOrderExists(id);

        Order order = repository.findById(id).orElseThrow();

        GetOrderResponse response = mapper.map(order, GetOrderResponse.class);

        return response;
    }

    @Override
    public CreateOrderResponse add(CreateOrderRequest request) {
        rules.checkIfNameLength(request.getName());
        rules.checkIfDescriptionLength(request.getDescription());

        Order order = mapper.map(request, Order.class);

        order.setId(0);
        order.setOrderDate(new Date());
        repository.save(order);

        CreateOrderResponse response = mapper.map(order, CreateOrderResponse.class);

        return response;
    }

    @Override
    public UpdateOrderResponse update(int id, UpdateOrderRequest request) {
        rules.checkIfOrderExists(id);
        rules.checkIfNameLength(request.getName());
        rules.checkIfDescriptionLength(request.getDescription());

        Order order = mapper.map(request, Order.class);

        order.setId(id);
        repository.save(order);

        UpdateOrderResponse response = mapper.map(order, UpdateOrderResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfOrderExists(id);

        repository.deleteById(id); }
}