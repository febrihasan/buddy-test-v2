package org.ait.project.product.modules.product.model.transform;

import java.util.List;
import org.ait.project.product.modules.product.dto.request.ProductRequestDto;
import org.ait.project.product.modules.product.dto.response.ProductResponseDto;
import org.ait.project.product.modules.product.model.entity.Product;
import org.mapstruct.*;

/**.
 *  Interface Transform model to DTO or DTO to model
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductTransform {

    Product productDtoToProduct(ProductRequestDto productDto);

    ProductResponseDto productToProductDto(Product product);

    List<ProductResponseDto> productListToProductDtoList(List<Product> products);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product updateProductFromProductDto(
            ProductRequestDto productDto,
            @MappingTarget Product product);
}
