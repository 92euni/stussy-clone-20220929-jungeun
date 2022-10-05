package com.stussy.stussyclone20220929jungeun.repository;

import com.stussy.stussyclone20220929jungeun.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {
    public int save(User user);

    //User 찾기
    public User findUserByEmail(String Email);
}
