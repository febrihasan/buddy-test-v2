package org.ait.project.customer.modules.customer.exception;

import lombok.extern.slf4j.Slf4j;
import org.ait.project.customer.config.exception.ModuleException;
import org.ait.project.customer.shared.constant.enums.ResponseEnum;

@Slf4j
public class JPHCustomerNotFoundException extends ModuleException {

  public JPHCustomerNotFoundException() {
    super(ResponseEnum.JSON_PLACE_HOLDER_CUSTOMER_NOT_FOUND);
    log.error("Customer not found");
  }
}
