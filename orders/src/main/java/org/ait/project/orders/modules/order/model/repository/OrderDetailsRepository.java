package org.ait.project.orders.modules.order.model.repository;

import java.util.List;
import org.ait.project.orders.modules.order.model.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    @Query("select o from OrderDetails o where o.orderId = ?1")
    List<OrderDetails> findByOrderId(Long orderId);
}