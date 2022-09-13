package org.ait.project.orders.modules.order.service.internal;

import org.ait.project.orders.modules.order.dto.request.OrderDetailsRequestDto;
import org.ait.project.orders.modules.order.dto.response.OrderDetailsResponseDto;
import org.ait.project.orders.shared.dto.template.ResponseDetail;
import org.ait.project.orders.shared.dto.template.ResponseList;
import org.ait.project.orders.shared.dto.template.ResponseTemplate;
import org.springframework.http.ResponseEntity;

/**.
 * Interface Order Details Service
 */
public interface OrderDetailsService {

    public ResponseEntity<ResponseTemplate<ResponseList<OrderDetailsResponseDto>>>
    getAllOrderDetails(Long orderId);

    public ResponseEntity<ResponseTemplate<ResponseDetail<OrderDetailsResponseDto>>>
    getOrderDetailById(Long orderId, Long id);

    public ResponseEntity<ResponseTemplate<ResponseDetail<OrderDetailsResponseDto>>>
    createOrderDetail(OrderDetailsRequestDto orderDetailDto, Long orderId);

    public ResponseEntity<ResponseTemplate<ResponseDetail<OrderDetailsResponseDto>>>
    createOrderDetailByOrders(OrderDetailsRequestDto orderDetailDto, Long orderId);

    public ResponseEntity<ResponseTemplate<ResponseDetail<OrderDetailsResponseDto>>>
    updateOrderDetail(OrderDetailsRequestDto orderDetailDto, Long orderId, Long id);

    public void deleteOrderDetail(Long orderId, Long id);

}
