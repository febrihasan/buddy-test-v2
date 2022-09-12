package org.ait.project.customer.modules.customer.model.transform;

import java.util.List;
import org.ait.project.customer.modules.customer.dto.request.CustomerRequestDto;
import org.ait.project.customer.modules.customer.dto.response.CustomerResponseDto;
import org.ait.project.customer.modules.customer.model.entity.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerTransform {
    Customer customerDtoToCustomer(CustomerRequestDto customerDto);

    CustomerResponseDto customerToCustomerDto(Customer customer);

    List<CustomerResponseDto> customerListToCustomerDtoList(List<Customer> customers);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Customer updateCustomerFromCustomerDto(CustomerRequestDto customerDto, @MappingTarget Customer customer);
}
