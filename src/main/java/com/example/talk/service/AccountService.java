package com.example.talk.service;

import com.example.talk.model.Account;
import com.example.talk.model.dto.AccountDto;
import com.example.talk.model.mapper.AccountMapper;
import com.example.talk.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<AccountDto> getAllList(String email) {
        List<AccountDto> result = new ArrayList<>();
        
        for (Account account : this.accountRepository.findAll()) {
            if (!account.getUserEmail().equals(email)) {
                result.add(AccountMapper.MAPPER.toAccountDto(account));
            }
        }

        return result;
    }
}
