package com.stussy.stussyclone20220929jungeun.dto.validation;

//클래스 안에 클래스 -> 이너클래스
//어노테이션 같은 느낌

public interface ValidationGroups {
    public interface NotBlankGroup {};
    public interface SizeCheckGroup {};
    public interface PatternCheckGroup {};

}
