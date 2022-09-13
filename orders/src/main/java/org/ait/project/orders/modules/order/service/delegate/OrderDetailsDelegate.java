package org.ait.project.orders.modules.order.service.delegate;

import java.util.List;
import org.ait.project.orders.modules.order.model.entity.OrderDetails;

public interface OrderDetailsDelegate {

  List<OrderDetails> getAllOrderDetails(Long orderId);

  OrderDetails getOrderDetailById(Long id);

  List<OrderDetails> getOrderDetailByOrderId(Long id);

  List<OrderDetails> saveAll(List<OrderDetails> orderDetails);

  OrderDetails save(OrderDetails orderDetail);

  void deleteById(Long id);

}
