package org.ait.project.inventory.modules.inventory.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**.
 * Class Inventory Request DTO
 */
@Data
public class InventoryRequestDto {
    @JsonProperty("id")
    private final Long id;
    @JsonProperty("product_id")
    private final Long productId;
    @JsonProperty("available_quantity")
    private final Long availableQuantity;
}
