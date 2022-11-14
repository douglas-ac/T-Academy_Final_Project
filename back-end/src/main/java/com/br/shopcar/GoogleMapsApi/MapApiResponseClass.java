package com.br.shopcar.GoogleMapsApi;

import lombok.Data;

import java.util.ArrayList;
@Data
public class MapApiResponseClass {

    public ArrayList<String> destination_addresses;
    public ArrayList<String> origin_addresses;
    public ArrayList<Row> rows;
    public String status;
    @Data
    public class Distance{
        public String text;
        public int value;
    }
    @Data
    public class Duration{
        public String text;
        public int value;
    }
    @Data
    public class Element{
        public Distance distance;
        public Duration duration;
        public String status;
    }
    @Data
    public class Row{
        public ArrayList<Element> elements;
    }
}
