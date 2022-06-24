package com.ebidding.BWIC.repository;

import com.ebidding.BWIC.domain.BWIC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BWICRepository extends JpaRepository<BWIC, String> {

    // SELECT * FROM Account WHERE NAME = ${name}
    Optional<BWIC> findByCusip(String Cusip);
    @Query(value = "select * from BWIC where duedate>now()",nativeQuery = true)
    List<BWIC> findBWICActive();

}
