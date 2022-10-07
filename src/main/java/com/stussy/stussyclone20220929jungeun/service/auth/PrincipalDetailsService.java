package com.stussy.stussyclone20220929jungeun.service.auth;

import com.stussy.stussyclone20220929jungeun.domain.User;
import com.stussy.stussyclone20220929jungeun.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor

public class PrincipalDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = accountRepository.findUserByEmail(email);

        if(user == null){
            log.error("아이디를 찾지 못함");
            throw new UsernameNotFoundException("존재하지 않는 아이디 입니다");
        }
//    log.info("email >> {}", email);

        return new PrincipalDetails(user);
    }
}
