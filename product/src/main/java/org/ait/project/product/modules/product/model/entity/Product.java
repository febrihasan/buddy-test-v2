package org.ait.project.product.modules.product.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ait.project.product.shared.constant.entities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**.
 * Class Entity Product
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", length = 20)
    private String type;

    @Column(name = "seri_name", length = 50)
    private String seriName;

    @Column(name = "price", length = 20)
    private BigDecimal price;

    @Column(name = "is_stock")
    private Boolean isStock;

}