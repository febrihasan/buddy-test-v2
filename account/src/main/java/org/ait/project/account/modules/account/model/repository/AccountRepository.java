package org.ait.project.account.modules.account.model.repository;

import org.ait.project.account.modules.account.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**.
 *  Interface Account Repository
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**.
     * Find data account by customer id
     * @param accountNumber
     * @param customerId
     * @return data customer
     */
    @Query("select a from Account a where a.accountNumber = ?1 and a.customerId = ?2")
    Account findByAccountAndCustomerId(String accountNumber, Long customerId);


    /**.
     * Update available balance by customer id
     * @param availableBalance
     * @param accountNumber
     * @param customerId
     */
    @Transactional
    @Modifying
    @Query("update Account a set a.availableBalance = ?1 where a.accountNumber = ?2 and a.customerId = ?3")
    void updateBalance(BigDecimal availableBalance, String accountNumber, Long customerId);

}