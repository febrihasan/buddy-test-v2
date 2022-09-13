package org.ait.project.inventory.modules.inventory.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ait.project.inventory.shared.constant.entities.BaseEntity;

import javax.persistence.*;

/**.
 * Class Entity Inventory
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "available_quantity", precision = 15, scale = 2)
    private Long availableQuantity;

}