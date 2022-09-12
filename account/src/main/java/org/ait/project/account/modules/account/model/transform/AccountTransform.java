package org.ait.project.account.modules.account.model.transform;

import org.ait.project.account.modules.account.dto.request.AccountRequestDto;
import org.ait.project.account.modules.account.dto.response.AccountResponseDto;
import org.ait.project.account.modules.account.model.entity.Account;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountTransform {
    Account accountDtoToAccount(AccountRequestDto accountDto);

    AccountResponseDto accountToAccountDto(Account account);

    List<AccountResponseDto> accountsToAccountsDto(List<Account> account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account updateAccountFromAccountDto(AccountRequestDto accountDto, @MappingTarget Account account);
}
