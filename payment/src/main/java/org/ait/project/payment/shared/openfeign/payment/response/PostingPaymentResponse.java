package org.ait.project.payment.shared.openfeign.payment.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostingPaymentResponse {

  @JsonProperty("referenceNumber")
  private String referenceNumber;
  @JsonProperty("transactionDate")
  private ZonedDateTime transactionDate;

  /*
   * Information Source Fund
   */
  @JsonProperty("sourceAccount")
  private String sourceAccount;
  @JsonProperty("senderName")
  private String senderName;
  @JsonProperty("senderBankCode")
  private String senderBankCode;
  @JsonProperty("senderBankName")
  private String senderBankName;

  /*
   * Information Source Fund
   */
  @JsonProperty("targetAccount")
  private String targetAccount;
  @JsonProperty("receiverName")
  private String receiverName;
  @JsonProperty("receiverBankCode")
  private String receiverBankCode;
  @JsonProperty("receiverBankName")
  private String receiverBankName;

  @JsonProperty("amount")
  private BigDecimal amount;
  @JsonProperty("status")
  private String status;
}
