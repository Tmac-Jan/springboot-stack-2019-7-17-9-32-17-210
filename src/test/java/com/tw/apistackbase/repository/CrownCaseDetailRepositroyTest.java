package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CrownCase;
import com.tw.apistackbase.entity.CrownCaseDetail;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class CrownCaseDetailRepositroyTest {

  @Autowired
  private CrownCaseDetailRepositroy crownCaseDetailRepositroy;

  @Before
  public void setUp(){
    List<CrownCaseDetail> crownCases = new ArrayList<CrownCaseDetail>() {{
      add(new CrownCaseDetail("caseDetail1", "case1"));
      add(new CrownCaseDetail("caseDetail2", "case2"));
      add(new CrownCaseDetail("caseDetail3", "case3"));
    }};
    crownCaseDetailRepositroy.saveAll(crownCases);
  }

  @Test
  public void should_return_CrownCases_when_call_save_with_not_null(){
    CrownCaseDetail result = new CrownCaseDetail("dsad","asda");
    Assert.assertNotEquals(null,result);
  }
  @Test
  public void should_return_CrownCase_when_call_find_by_id(){
    Optional<CrownCaseDetail> result = crownCaseDetailRepositroy.findById(1);
    Assert.assertNotEquals(null,result.get());
  }
}