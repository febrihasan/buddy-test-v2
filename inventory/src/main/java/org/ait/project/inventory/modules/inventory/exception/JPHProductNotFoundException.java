package org.ait.project.inventory.modules.inventory.exception;

import lombok.extern.slf4j.Slf4j;
import org.ait.project.inventory.config.exception.ModuleException;
import org.ait.project.inventory.shared.constant.enums.ResponseEnum;

@Slf4j
public class JPHProductNotFoundException extends ModuleException {

  public JPHProductNotFoundException() {
    super(ResponseEnum.JSON_PLACE_HOLDER_PRODUCT_NOT_FOUND);
    log.error("Product not found");
  }
}
