package com.br.shopcar.enums;

import java.util.LinkedHashMap;

public enum Automaker {
    /* 01 */ BMW("BMW"),
    /* 02 */ FORD("FORD"),
    /* 03 */ HONDA("HONDA"),
    /* 04 */ AUDI("AUDI"),
    /* 05 */ FIAT("FIAT"),
    /* 06 */ VOLKSWAGEN("VOLKSWAGEN"),
    /* 07 */ CHEVROLET("CHEVROLET"),
    /* 08 */ OUTROS("OUTROS"),
    /* 09 */ MERCEDES_BENZ("MERCEDES BENZ"),
    /* 10 */ TESLA("TESLA"),
    /* 11 */ MITSUBISHI("MITSUBISHI"),
    /* 12 */ HYUNDAI("HYUNDAI"),
    /* 13 */ RENAULT("RENAULT"),
    /* 14 */ TOYOTA("TOYOTA"),
    /* 15 */ LAND_ROVER("LAND ROVER"),
    /* 16 */ PORSCHE("PORSCHE"),
    /* 17 */ VOLVO("VOLVO"),
    /* 18 */ PEUGEOT("PEUGEOT"),
    /* 19 */ NISSAN("NISSAN"),
    /* 20 */ JEEP("JEEP");

    private final String label;

    Automaker(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

    public static LinkedHashMap<String, String> map() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for(Automaker automaker: values()){
            map.put(automaker.name(), automaker.getLabel());
        }
        return map;
    }

}
