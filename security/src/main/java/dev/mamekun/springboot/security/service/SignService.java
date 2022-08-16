package dev.mamekun.springboot.security.service;

import dev.mamekun.springboot.security.data.dto.SignInResultDto;
import dev.mamekun.springboot.security.data.dto.SignUpResultDto;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;

}
