package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CrownCase;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CrownCaseRepository extends JpaRepository<CrownCase,Integer> {

  @Query(" select cc from CrownCase cc order by cc.caseTime desc ")
  List<CrownCase> findAllOrderByCaseTime();

  List<CrownCase> findAllByCaseName(String caseName);
}
