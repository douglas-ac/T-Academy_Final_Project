package com.br.shopcar.Dto.GET;

import com.br.shopcar.Model.Announcement.Adress;
import lombok.Data;

@Data
public class AdressDto {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;

    public Adress convertToModel(){
        Adress adress = new Adress();
        adress.setCep(this.getCep());
        adress.setLogradouro(this.getLogradouro());
        adress.setComplemento(this.getComplemento());
        adress.setBairro(this.getBairro());
        adress.setLocalidade(this.getLocalidade());
        adress.setUf(this.getUf());
        adress.setDdd(this.getDdd());
        return adress;
    }

}
