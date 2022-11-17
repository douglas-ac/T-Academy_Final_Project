package com.br.shopcar.Model;

import com.br.shopcar.enums.Automaker;
import com.br.shopcar.enums.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "auto_part")
public class PartModel extends ProductModel {
    private Condition condition;
    private String category;
    private Automaker automaker;

}
