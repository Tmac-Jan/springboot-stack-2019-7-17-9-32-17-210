package com.tw.apistackbase.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.tw.apistackbase.entity.CrownCase;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class CrownCaseRepositoryTest {

  @Autowired
  private CrownCaseRepository crownCaseRepository;

  @Before
  public void setUp() {
    List<CrownCase> crownCases = new ArrayList<CrownCase>() {{
      add(new CrownCase(new Long(1001), "case1"));
      add(new CrownCase(new Long(1002), "case2"));
      add(new CrownCase(new Long(1003), "case2"));
    }};
       crownCaseRepository.saveAll(crownCases);
  }

  @Test
  @Transactional
  public void should_return_CrownCases_when_call_save_with_not_null(){
    CrownCase crownCase = new CrownCase(System.currentTimeMillis(),"case4");
    CrownCase result = crownCaseRepository.save(crownCase);
    Assert.assertNotEquals(null,result);
  }

  @Test
  public void should_return_CrownCase_when_call_find_by_Id(){
    CrownCase crownCase = crownCaseRepository
        .findAll()
        .stream()
        .findFirst()
        .orElse(null);
    Optional<CrownCase> result = crownCaseRepository.findById(crownCase.getId());
    Assert.assertNotEquals(null,result.get());
  }
  @Test
  public void should_return_CrownCase_when_call_find_all_order_by_caseTime_desc(){
    List<CrownCase> result = crownCaseRepository.findAllOrderByCaseTime();
    System.out.println("0:"+result.get(0).getCaseTime());
    System.out.println("1:"+result.get(1).getCaseTime());
    Assert.assertEquals(true,result.get(0).getCaseTime()>=result.get(1).getCaseTime());
  }
  @Test
  public void should_return_CrownCases_when_call_find_all_by_caseName(){
    List<CrownCase> result = crownCaseRepository.findAllByCaseName("case2");
    Assert.assertEquals(2,result.size());
  }
  @Test
  @Transactional
  public void should_return_1_when_call_delete_CrownCase_by_id(){
    crownCaseRepository.deleteById(1);
    Assert.assertEquals(2,crownCaseRepository.findAll().size());
  }
}