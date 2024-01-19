package com.example.talk.model.mapper;

import com.example.talk.model.Account;
import com.example.talk.model.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "userEmail", source = "accountDto.userEmail")
    @Mapping(target = "userName", source = "accountDto.userName")
    @Mapping(target = "userPw", source = "accountDto.userPw")
    Account toAccount(AccountDto accountDto);

    @Mapping(target = "userEmail", source = "account.userEmail")
    @Mapping(target = "userName", source = "account.userName")
    @Mapping(target = "userPw", source = "account.userPw")
    AccountDto toAccountDto(Account account);
}