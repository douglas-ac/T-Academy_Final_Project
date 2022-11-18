package com.br.shopcar.Model;

import com.br.shopcar.enums.Automaker;
import com.br.shopcar.enums.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "auto_part")
@DiscriminatorValue("2")
public class PartModel extends ProductModel {
    private Condition part_condition;
    private String category;
    private Automaker automaker;

}
