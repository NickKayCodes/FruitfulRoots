package com.krath.fruitfulroots.conf.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class FRPwEncoder {
    private final BCryptPasswordEncoder passwordEncoder;

    public FRPwEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encodePassword(String plainText){
        return passwordEncoder.encode(plainText);
    }
    public boolean matchPassword(String plainText, String encodedPw){
        return passwordEncoder.matches(plainText, encodedPw);
    }
}
