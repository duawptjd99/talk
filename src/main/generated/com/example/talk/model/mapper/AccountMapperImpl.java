package com.example.talk.model.mapper;

import com.example.talk.model.Account;
import com.example.talk.model.dto.AccountDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-05T14:29:11+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public Account toAccount(AccountDto accountDto) {
        if ( accountDto == null ) {
            return null;
        }

        Account account = new Account();

        account.setUserEmail( accountDto.getUserEmail() );
        account.setUserName( accountDto.getUserName() );
        account.setUserPw( accountDto.getUserPw() );

        return account;
    }

    @Override
    public AccountDto toAccountDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        accountDto.setUserEmail( account.getUserEmail() );
        accountDto.setUserName( account.getUserName() );
        accountDto.setUserPw( account.getUserPw() );

        return accountDto;
    }
}
