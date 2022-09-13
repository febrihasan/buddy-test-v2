package org.ait.project.payment.shared.openfeign.payment;

import org.ait.project.payment.config.openfeign.OpenFeignConfig;
import org.ait.project.payment.shared.openfeign.payment.common.PathPaymentClientAPIs;
import org.ait.project.payment.shared.openfeign.payment.request.PostingPaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    value = "payment-client",
    url = "${restclient.url.payment-client}",
    configuration = OpenFeignConfig.class,
    fallback = PaymentClientFallback.class
)
public interface PaymentClient {

  /**.
   * Api external for posting payment
   * @param paymentRequest
   * @return response payment
   */
  @PostMapping(PathPaymentClientAPIs.POSTING)
  String postingPayment(@RequestBody PostingPaymentRequest paymentRequest);

  /**.
   * Api external for preview / check status payment
   * @param referenceNumber
   * @return response payment
   */
  @PostMapping(value = PathPaymentClientAPIs.PREVIEW)
  String previewPayment(@PathVariable String referenceNumber);

  /**.
   * Api external for cancel payment
   * @param referenceNumber
   * @return response payment
   */
  @DeleteMapping(PathPaymentClientAPIs.CANCEL)
  String cancelPayment(@PathVariable String referenceNumber);
}
