package com.example.Repository;

import com.example.Entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select balance from Account where id = ?1")
    public Double getBalanceById(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Account set balance = balance + ?2 where id = ?1")
    public void depositToAccountById(Long id, Double amount);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Account set balance = balance - ?2 where id = ?1")
    public void withdrawFromAccountById(Long id, Double amount);

}
