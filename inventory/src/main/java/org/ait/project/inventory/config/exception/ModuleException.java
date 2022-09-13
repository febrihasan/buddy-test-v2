package org.ait.project.inventory.config.exception;

import lombok.Getter;
import org.ait.project.inventory.shared.constant.enums.ResponseEnum;

@Getter
public class ModuleException extends RuntimeException {

  private final ResponseEnum responseEnum;

  public ModuleException(ResponseEnum responseEnum) {
    super(responseEnum.getResponseCode());
    this.responseEnum = responseEnum;
  }
}
