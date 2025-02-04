package com.tw.apistackbase.repository;


import com.tw.apistackbase.entity.CrownCase;
import com.tw.apistackbase.entity.CrownCaseDetail;
import com.tw.apistackbase.entity.Procuratorate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
      add(new CrownCase(new Long(1001), "case1",null,new Procuratorate("procuratorate1")));
      add(new CrownCase(new Long(1002), "case2",null,new Procuratorate("procuratorate2")));
      add(new CrownCase(new Long(1003), "case2",null,new Procuratorate("procuratorate3")));
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
  @Transactional
  public void should_return_CrownCases_when_call_save_with_null_caseTime_and_not_null_caseName(){
    CrownCase crownCase = new CrownCase(null,"case4");
    Assertions.assertThrows(javax.validation.ConstraintViolationException.class, () ->
        crownCaseRepository.saveAndFlush(crownCase));
  }

  @Test
  @Transactional
  public void should_return_CrownCases_when_call_save_with_not_null_caseTime_and_null_caseName(){
    CrownCase crownCase = new CrownCase((long) 1000557,null);
    Assertions.assertThrows(javax.validation.ConstraintViolationException.class, () ->
        crownCaseRepository.saveAndFlush(crownCase));
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

  @Test
  public void should_return_CrownCases_when_call_save_CrownCase_with_CrownCaseDetail(){
    CrownCase crownCase = new CrownCase((long) 10000001,"testCase");
    CrownCaseDetail crownCaseDetail = new CrownCaseDetail("test1","test2");
    crownCase.setCrownCaseDetail(crownCaseDetail);
    CrownCase result= crownCaseRepository.save(crownCase);
    Assert.assertEquals(true,crownCaseDetail.getObjectiveCondition()
        .equals(result.getCrownCaseDetail().getObjectiveCondition()));
  }
  @Test
  public void should_return_CrownCase_when_call_save_CrownCase_with_Procuratorate_not_null(){
    CrownCase crownCase = new CrownCase((long) 10000001,"testCase");
    Procuratorate procuratorate = new Procuratorate("test");
    crownCase.setProcuratorate(procuratorate);
    CrownCase result= crownCaseRepository.save(crownCase);
    Assert.assertEquals(true,procuratorate.getProcuratorateName()
        .equals(result.getProcuratorate().getProcuratorateName()));
  }

}