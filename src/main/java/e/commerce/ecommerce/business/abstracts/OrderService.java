package e.commerce.ecommerce.business.abstracts;

import e.commerce.ecommerce.business.dto.requests.creates.CreateOrderRequest;
import e.commerce.ecommerce.business.dto.requests.updates.UpdateOrderRequest;
import e.commerce.ecommerce.business.dto.responses.creates.CreateOrderResponse;
import e.commerce.ecommerce.business.dto.responses.gets.order.GetAllOrdersResponse;
import e.commerce.ecommerce.business.dto.responses.gets.order.GetOrderResponse;
import e.commerce.ecommerce.business.dto.responses.updates.UpdateOrderResponse;

import java.util.List;

public interface OrderService {
    List<GetAllOrdersResponse> getAll();
    GetOrderResponse getById(int id);
    CreateOrderResponse add(CreateOrderRequest request);
    UpdateOrderResponse update(int id, UpdateOrderRequest request);
    void delete(int id);
}