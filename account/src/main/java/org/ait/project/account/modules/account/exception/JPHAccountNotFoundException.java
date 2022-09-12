package org.ait.project.account.modules.account.exception;

import lombok.extern.slf4j.Slf4j;
import org.ait.project.account.config.exception.ModuleException;
import org.ait.project.account.shared.constant.enums.ResponseEnum;

@Slf4j
public class JPHAccountNotFoundException extends ModuleException {

  public JPHAccountNotFoundException() {
    super(ResponseEnum.JSON_PLACE_HOLDER_ACCOUNT_NOT_FOUND);
    log.error("Account not found");
  }
}
