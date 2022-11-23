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
    private String nome;
    private String descricao;
    private double preco;
    private Integer year;
    private Automaker automaker;
    private String modelo;
    private String category;

    public <T extends ProductDto> T convertToDto(T productDTO){

        productDTO.setId(this.getId());
        productDTO.setNome(this.getNome());
        productDTO.setDescricao(this.getDescricao());
        productDTO.setPreco(this.getPreco());
        productDTO.setYear(this.getYear());
        productDTO.setAutomaker(this.getAutomaker());
        productDTO.setModelo(getModelo());
        productDTO.setCategory(this.getCategory());

        return productDTO;
    }

}
