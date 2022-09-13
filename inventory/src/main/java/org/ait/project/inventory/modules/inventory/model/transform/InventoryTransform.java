package org.ait.project.inventory.modules.inventory.model.transform;

import org.ait.project.inventory.modules.inventory.dto.request.InventoryRequestDto;
import org.ait.project.inventory.modules.inventory.dto.response.InventoryResponseDto;
import org.ait.project.inventory.modules.inventory.model.entity.Inventory;
import org.mapstruct.*;

import java.util.List;

/**.
 *  Interface Transform model to DTO or DTO to model
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InventoryTransform {
    Inventory inventoryDtoToInventory(InventoryRequestDto inventoryRequestDto);

    InventoryResponseDto inventoryToInventoryDto(Inventory inventory);

    List<InventoryResponseDto> inventoriesToInventoriesDto(List<Inventory> inventories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Inventory updateInventoryFromInventoryDto(InventoryRequestDto inventoryDto,
                                              @MappingTarget Inventory inventory);
}
