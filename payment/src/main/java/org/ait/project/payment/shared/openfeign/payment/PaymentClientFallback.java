package org.ait.project.payment.shared.openfeign.payment;

import org.ait.project.payment.shared.openfeign.payment.request.PostingPaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentClientFallback implements PaymentClient {

  /**.
   * When Openfeign Call failed, then do this
   */

  /**.
   * Posting payment to api external
   * @param paymentRequest
   * @return data payment
   */
  @Override
  public String postingPayment(final PostingPaymentRequest paymentRequest) {
    return new String();
  }

  /**.
   * Preview payment to api external
   * @param referenceNumber
   * @return data payment
   */
  @Override
  public String previewPayment(final String referenceNumber) {
    return new String();
  }

  /**.
   * Cancel payment to api external
   * @param referenceNumber
   * @return data payment
   */
  @Override
  public String cancelPayment(final String referenceNumber) {
    return new String();
  }
}
