package com.example.talk.service;

import com.example.talk.model.Account;
import com.example.talk.model.dto.AccountDto;
import com.example.talk.model.mapper.AccountMapper;
import com.example.talk.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder encoder;

    public boolean regist(AccountDto accountDto) {
        Account account = AccountMapper.MAPPER.toAccount(accountDto);
        System.out.println(account.getUserEmail() + " / " + account.getUserPw() + " / " + account.getUserName());
        if (!this.accountRepository.findByUserEmail(accountDto.getUserEmail()).isPresent()) {
            account.setUserPw(encoder.encode(account.getUserPw()));
            this.accountRepository.save(account);

            return true;
        }

        return false;
    }
}


