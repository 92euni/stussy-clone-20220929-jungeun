package com.stussy.stussyclone20220929jungeun.controller.api;

import com.stussy.stussyclone20220929jungeun.aop.annotation.LogAspect;
import com.stussy.stussyclone20220929jungeun.aop.annotation.ValidAspect;
import com.stussy.stussyclone20220929jungeun.dto.CMRespDto;
import com.stussy.stussyclone20220929jungeun.dto.account.RegisterReqDto;
import com.stussy.stussyclone20220929jungeun.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220929jungeun.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @LogAspect
    @ValidAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception{

    accountService.checkDuplicateEmail(registerReqDto.getEmail());
    accountService.register(registerReqDto);


    // @RequestBody : json으로 날릴려고
    // @Valid : 유효성 체크를 해준다
    // @Valid를 주고 Dto에 사용하면 BindingResult 객체가 따라온다

//[1번유형]
//            bindingResult.getFieldErrors().forEach(error -> {
//                log.info("Error: 코드({}), 필드명({}) , 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
//                if(!error.getCode().equals("NotBlank")){
//
//                    //error 메세지 날려주는 기능
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                }
//            });
//            bindingResult.getFieldErrors().forEach(error -> {
//                log.info("Error: 코드({}), 필드명({}) , 메세지({})", error.getCode(), error.getField(), error.getDefaultMessage());
//                if(error.getCode().equals("NotBlank")){
//
//                    //error 메세지 날려주는 기능
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                }
//            });




//        StopWatch stopWathch = new StopWatch();

//     [시작]
//        stopWathch.start();


//[ValidAspect를 달면 여기서 부터 없어져야 함]
//        if(bindingResult.hasErrors()){
//            log.error("유효성 검사 오류가 발생");
//
//            Map<String, String> errorMap = new HashMap<String, String>();
//
//            List<List<FieldError>> codeList = new ArrayList<List<FieldError>>();
//            codeList.add(new ArrayList<FieldError>());  //Pattern
//            codeList.add(new ArrayList<FieldError>());  //NotBlank
//
//            bindingResult.getFieldErrors().forEach(error -> {
//                errorMap.put(error.getField(), error.getDefaultMessage());
//
//                if(error.getCode().equals("Pattern")) {
//                    codeList.get(0).add(error);
//                }else if(error.getCode().equals("NotBlank")) {
//                    codeList.get(1).add(error);
//                }
//            });
//            log.info("codeList: {}", codeList);
//
//            codeList.forEach(errorMapList -> {
//                errorMapList.forEach(error ->{
//                    errorMap.put(error.getField(), error.getDefaultMessage());
//                });
//                log.info("error: {}", errorMap);
//            });
//
//            return ResponseEntity.badRequest().body(new CMRespDto<>(-1 , "유효성 검사 실패", errorMap));
//        }
//[여기까지 없어져야 함]


//     [멈춤]
//        stopWathch.stop();

//        log.info("메소드 실행시간 >>> {}", stopWathch.getTotalTimeSeconds());

//        log.info("{}", registerReqDto);

           return ResponseEntity.ok().body(new CMRespDto<>(1,"Successfully registered", registerReqDto));
    }

}
