package org.ait.project.orders.modules.order.service.internal.impl;

import lombok.RequiredArgsConstructor;
import org.ait.project.inventory.modules.inventory.model.entity.Inventory;
import org.ait.project.inventory.modules.inventory.service.delegate.InventoryDelegate;
import org.ait.project.orders.modules.order.dto.request.OrderDetailsRequestDto;
import org.ait.project.orders.modules.order.dto.request.OrdersRequestDto;
import org.ait.project.orders.modules.order.dto.response.OrdersResponseDto;
import org.ait.project.orders.modules.order.model.entity.Orders;
import org.ait.project.orders.modules.order.model.transform.OrderDetailsTransform;
import org.ait.project.orders.modules.order.model.transform.OrdersTransform;
import org.ait.project.orders.modules.order.service.delegate.OrderDetailsDelegate;
import org.ait.project.orders.modules.order.service.delegate.OrdersDelegate;
import org.ait.project.orders.modules.order.service.internal.OrderDetailsService;
import org.ait.project.orders.modules.order.service.internal.OrdersService;
import org.ait.project.orders.shared.constant.enums.ResponseEnum;
import org.ait.project.orders.shared.dto.template.ResponseDetail;
import org.ait.project.orders.shared.dto.template.ResponseList;
import org.ait.project.orders.shared.dto.template.ResponseTemplate;
import org.ait.project.orders.shared.utils.ResponseHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**.
 * class Orders Service Implements
 */
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    private static final Logger LOGGER = LogManager.getLogger(OrdersServiceImpl.class);

    /**.
     * Get function OrdersHelper
     */
    private final ResponseHelper responseHelper;

    /**.
     * Get function OrdersDelegate
     */
    private final OrdersDelegate ordersDelegate;

    /**.
     * Get function OrderDetailsDelegate
     */
    private final OrderDetailsDelegate orderDetailsDelegate;

    /**.
     * Get function InventoryDelegate
     */
    private InventoryDelegate inventoryDelegate;

    /**.
     * Get function OrderDetailsService
     */
    private final OrderDetailsService orderDetailsService;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final OrdersTransform ordersTransform;

    /**.
     * Transform model mapper from entity to DTO or DTO to entity
     */
    private final OrderDetailsTransform orderDetailsTransform;

    /**.
     * Get all data orders
     * @return all data orders
     */
    public ResponseEntity<ResponseTemplate<ResponseList<OrdersResponseDto>>>
    getAllOrders() {
        List<Orders> orders = ordersDelegate.getAllOrders();
        List<OrdersResponseDto> ordersDto = ordersTransform.ordersToOrdersDto(orders);
        ordersDto.forEach(order ->
            order.setOrderDetails(orderDetailsTransform
                    .orderDetailsToOrderDetailsDto(orderDetailsDelegate
                            .getAllOrderDetails(order.getId()))));
        return responseHelper
                .createResponseCollection(ResponseEnum.SUCCESS, null, ordersDto);
    }

    /**.
     * Get all data orders with page
     * @param page number
     * @return all data orders with pagination
     */
    public ResponseEntity<ResponseTemplate<ResponseList<OrdersResponseDto>>>
    getAllOrdersWithPage(final Pageable page) {
        Page<Orders> ordersWithPage = ordersDelegate
                .getAllOrdersWithPage(page);
        return responseHelper
                .createResponseCollection(
                        ResponseEnum.SUCCESS,
                        ordersWithPage,
                ordersTransform
                        .ordersToOrdersDto(
                                ordersWithPage.getContent()));
    }

    /**.
     * Get a data order
     * @param id
     * @return data order
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
    getOrderById(final Long id) {
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        ordersTransform
                                .orderToOrderDto(ordersDelegate.getOrderById(id)));
    }

    /**.
     * Create a new order
     * @param ordersDto
     * @return new data order
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
    createOrder(final OrdersRequestDto ordersDto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");

        Orders orders = ordersTransform.ordersDtoToOrders(ordersDto);
        orders.setOrderNumber("ORD-" + sdf.format(new Date()));

        boolean outOfStock = false;
        for (OrderDetailsRequestDto detail : ordersDto.getOrderDetails()) {
            Inventory inventory = inventoryDelegate.getInventoryByProductId(detail.getProductId());
            if (inventory.getAvailableQuantity() == 0) {
                outOfStock = true;
                break;
            }
        }

        Orders order;
        if (!outOfStock) {
            order = ordersDelegate.save(orders);
            ordersDto.getOrderDetails()
                    .forEach(detail ->
                            orderDetailsService
                                    .createOrderDetailByOrders(detail, order.getId()));
        } else {
            OrdersResponseDto responseDto = ordersTransform.orderToOrderDto(orders);
            responseDto.setOrderDetails(orderDetailsTransform
                    .createOrderDetailsDto(ordersDto.getOrderDetails()));
            return responseHelper.createResponseDetail(ResponseEnum.OUT_OF_STOCK,
                    responseDto);
        }

        OrdersResponseDto ordersResponseDto = ordersTransform.orderToOrderDto(orders);
        ordersResponseDto.setOrderDetails(orderDetailsTransform
                .orderDetailsToOrderDetailsDto(orderDetailsDelegate
                        .getAllOrderDetails(order.getId())));
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS, ordersResponseDto);
    }

    /**.
     * Update data order
     * @param id
     * @param orderDto
     * @return data order
     */
    public ResponseEntity<ResponseTemplate<ResponseDetail<OrdersResponseDto>>>
    updateOrder(final OrdersRequestDto orderDto,
                                            final Long id) {
        Orders order = ordersTransform
                .updateOrdersFromOrdersDto(
                        orderDto,
                        ordersDelegate.getOrderById(id));
        order.setId(id);
        return responseHelper
                .createResponseDetail(ResponseEnum.SUCCESS,
                        ordersTransform
                                .orderToOrderDto(ordersDelegate.save(order)));
    }

    /**.
     * Delete a data order
     * @param id order
     */
    public void deleteOrder(final Long id) {
        ordersDelegate.deleteById(id);
    }

}
