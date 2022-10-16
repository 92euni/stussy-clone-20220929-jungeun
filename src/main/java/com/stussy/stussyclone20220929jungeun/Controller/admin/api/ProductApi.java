package com.stussy.stussyclone20220929jungeun.controller.admin.api;


import com.stussy.stussyclone20220929jungeun.aop.annotation.LogAspect;
import com.stussy.stussyclone20220929jungeun.aop.annotation.ValidAspect;
import com.stussy.stussyclone20220929jungeun.dto.CMRespDto;
import com.stussy.stussyclone20220929jungeun.dto.admin.ProductAdditionReqDto;
import com.stussy.stussyclone20220929jungeun.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220929jungeun.exception.CustomInternalServerErrorException;
import com.stussy.stussyclone20220929jungeun.service.admin.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @ValidAspect
    @LogAspect
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@Validated(ValidationSequence.class) ProductAdditionReqDto productAdditionReqDto, BindingResult bindingResult) throws Exception {
        //Exception 달아서 try catch안해도 됨

//        String productName = productAdditionReqDto.getName();
//
//        for(int i =0; i < 200; i++){
//            if(i % 4 == 0){
//                productAdditionReqDto.setName( productName + "-" + (i + 1) );
//            }
//            productService.addProduct(productAdditionReqDto);
//        }


        return ResponseEntity
                .created(null)
                .body(new CMRespDto<>(1, "successfully", productService.addProduct(productAdditionReqDto)));
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProductList(@RequestParam int pageNumber,
                                            @RequestParam @Nullable String category,
                                            @RequestParam @Nullable String searchText) throws Exception {

        return ResponseEntity.ok(new CMRespDto<>(1, "Successfully", productService.getProductList(pageNumber, category, searchText)));
    }
}

