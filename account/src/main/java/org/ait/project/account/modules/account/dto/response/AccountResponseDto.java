package org.ait.project.account.modules.account.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountResponseDto {
    @JsonProperty("id")
    private final Long id;
    @JsonProperty("customer_id")
    private final Long customerId;
    @JsonProperty("accountNumber")
    private final String accountNumber;
    @JsonProperty("accountName")
    private final String accountName;
    @JsonProperty("bankCode")
    private final String bankCode;
    @JsonProperty("bankName")
    private final String bankName;
    @JsonProperty("available_balance")
    private final BigDecimal availableBalance;
}
