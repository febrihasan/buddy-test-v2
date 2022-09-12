package org.ait.project.product.modules.product.exception;

import lombok.extern.slf4j.Slf4j;
import org.ait.project.product.config.exception.ModuleException;
import org.ait.project.product.shared.constant.enums.ResponseEnum;

@Slf4j
public class JPHProductNotFoundException extends ModuleException {

  public JPHProductNotFoundException() {
    super(ResponseEnum.JSON_PLACE_HOLDER_PRODUCT_NOT_FOUND);
    log.error("Product not found");
  }
}
