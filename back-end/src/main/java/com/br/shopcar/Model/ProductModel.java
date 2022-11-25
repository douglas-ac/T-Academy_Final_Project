package com.br.shopcar.Model;

import com.br.shopcar.Dto.GET.ProductDto;
import com.br.shopcar.enums.Automaker;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type",
        discriminatorType = DiscriminatorType.INTEGER)
@NoArgsConstructor
@Data
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private Integer year;
    private Automaker automaker;
    private String model;
    private String category;

    public <T extends ProductDto> T convertToDto(T productDTO){

        productDTO.setId(this.getId());
        productDTO.setName(this.getName());
        productDTO.setDescription(this.getDescription());
        productDTO.setPrice(this.getPrice());
        productDTO.setYear(this.getYear());
        productDTO.setAutomaker(this.getAutomaker());
        productDTO.setModel(getModel());
        productDTO.setCategory(this.getCategory());

        return productDTO;
    }

}
