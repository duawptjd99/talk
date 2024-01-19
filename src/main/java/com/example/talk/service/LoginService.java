package com.example.talk.service;

import com.example.talk.model.Account;
import com.example.talk.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> account = accountRepository.findByUserEmail(email);
        if (!account.isPresent()) {
            log.info("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new User(account.get().getUserEmail(), account.get().getUserPw(), new ArrayList<>());
    }
}
