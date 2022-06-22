package com.ebidding.ebiddingsvc.repository;

import com.ebidding.ebiddingsvc.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    // SELECT * FROM Account WHERE NAME = ${name}
    Optional<Account> findByName(String name);
}
