package org.ait.project.product.modules.product.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**.
 * Class Product Request DTO
 */
@Data
public class ProductResponseDto {
    @JsonProperty("id")
    private final Long id;
    @JsonProperty("type")
    private final String type;
    @JsonProperty("seriName")
    private final String seriName;
    @JsonProperty("price")
    private final BigDecimal price;
    @JsonProperty("is_stock")
    private final Boolean isStock;
}
