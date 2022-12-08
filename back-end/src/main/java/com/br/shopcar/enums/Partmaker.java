package com.br.shopcar.enums;

import java.util.LinkedHashMap;

public enum Partmaker {
    BOSCH("Bosch"),
    SEG("Seg"),
    CONTINENTAL("Continental"),
    NYTRON("Nytron"),
    HALDEX("Haldex"),
    FREMAX("Fremax"),
    MAXGEAR("Maxgear"),
    YMAX("Ymax"),
    VALEO("Valeo"),
    OUTROS("Outros");

    private final String label;

    Partmaker(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

    public static LinkedHashMap<String, String> map() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        for(Partmaker partmaker: values()){
            map.put(partmaker.name(), partmaker.getLabel());
        }
        return map;
    }
}