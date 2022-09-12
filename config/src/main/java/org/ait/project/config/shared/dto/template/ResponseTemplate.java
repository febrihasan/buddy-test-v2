package org.ait.project.config.shared.dto.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate<T> {
  @JsonProperty("response_schema")
  private ResponseSchema responseSchema;
  @JsonProperty("response_output")
  private T responseOutput;
}
