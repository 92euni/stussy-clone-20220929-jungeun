package com.stussy.stussyclone20220929jungeun.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Product {

    private int id;
    private String category;
    private int group_id;
    private String name;
    private int price;
    private String color;
    private String size;

    private String info_simple;
    private String info_detail;
    private String info_option;
    private String info_management;
    private String info_shipping;

    private List<ProductImgFile> product_img_files;

    private LocalDateTime create_date;
    private LocalDateTime update_date;

}
