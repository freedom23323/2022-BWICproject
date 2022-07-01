package com.ebidding.BWIC.repository;

import com.ebidding.BWIC.domain.BWIC;
import com.ebidding.bwic.BWICDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BWICRepository extends JpaRepository<BWIC, String> {

    // SELECT * FROM Account WHERE NAME = ${name}
    Optional<BWICDto> findByCusip(String Cusip);

    Optional<BWIC> findById(Integer id);
    @Query(value = "select * from BWIC where duedate>now()",nativeQuery = true)
    List<BWIC> findBWICActive();

    @Query(value = "select * from BWIC where cusip=Cusip",nativeQuery = true)
    List<BWIC>findAllByCusip(String Cusip);

    @Query(value = "select * from BWIC",nativeQuery = true)
    List<BWIC> findAllBWIC();

    @Query(value = "select * from BWIC where id==bwic_id and duedate>now()",nativeQuery = true)
    BWIC findBWICcable(Integer bwic_id);

}
