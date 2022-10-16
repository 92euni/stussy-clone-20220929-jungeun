package com.stussy.stussyclone20220929jungeun.service.admin;

import com.stussy.stussyclone20220929jungeun.dto.admin.ProductAdditionReqDto;

public interface ProductService {

    public boolean addProduct(ProductAdditionReqDto productAdditionReqDto) throws Exception;
}
