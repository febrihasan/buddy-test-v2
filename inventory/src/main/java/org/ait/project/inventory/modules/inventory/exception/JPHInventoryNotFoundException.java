package org.ait.project.inventory.modules.inventory.exception;

import lombok.extern.slf4j.Slf4j;
import org.ait.project.inventory.config.exception.ModuleException;
import org.ait.project.inventory.shared.constant.enums.ResponseEnum;

@Slf4j
public class JPHInventoryNotFoundException extends ModuleException {

  public JPHInventoryNotFoundException() {
    super(ResponseEnum.JSON_PLACE_HOLDER_INVENTORY_NOT_FOUND);
    log.error("Inventory not found");
  }
}
