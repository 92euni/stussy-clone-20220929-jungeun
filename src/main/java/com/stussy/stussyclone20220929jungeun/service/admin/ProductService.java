package com.stussy.stussyclone20220929jungeun.service.admin;

import com.stussy.stussyclone20220929jungeun.domain.Product;
import com.stussy.stussyclone20220929jungeun.dto.admin.ProductAdditionReqDto;

import java.util.List;

public interface ProductService {


    public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception;

    public List<Product> getProductList(int pageNumber, String category, String searchText) throws Exception;
}