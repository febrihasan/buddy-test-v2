package org.ait.project.inventory.shared.utils;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.ait.project.inventory.shared.constant.enums.ResponseEnum;
import org.ait.project.inventory.shared.dto.template.ResponseSchema;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseMessageHelper {

  private final MessageSource responseMessageSource;

  public ResponseSchema getResponseSchema(ResponseEnum responseEnum) {
    return new ResponseSchema(responseEnum.getResponseCode(),
        getMessage(responseEnum.getResponseMessage()));
  }

  private String getMessage(String code) {
    return responseMessageSource.getMessage(code, null, Locale.getDefault());
  }
}
