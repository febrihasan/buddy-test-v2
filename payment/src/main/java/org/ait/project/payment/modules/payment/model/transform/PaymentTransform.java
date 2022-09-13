package org.ait.project.payment.modules.payment.model.transform;

import java.util.List;
import org.ait.project.payment.modules.payment.dto.request.PaymentRequestDto;
import org.ait.project.payment.modules.payment.dto.response.PaymentResponseDto;
import org.ait.project.payment.modules.payment.model.entity.Payment;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PaymentTransform {
    Payment paymentDtoToPayment(PaymentRequestDto paymentDto);

    PaymentResponseDto paymentToPaymentDto(Payment payment);

    List<PaymentResponseDto> paymentListToPaymentDtoList(List<Payment> paymentList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment updatePaymentFromPaymentDto(PaymentRequestDto paymentDto, @MappingTarget Payment payment);
}
