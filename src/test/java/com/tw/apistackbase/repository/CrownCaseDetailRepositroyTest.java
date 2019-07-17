package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CrownCase;
import com.tw.apistackbase.entity.CrownCaseDetail;
import org.junit.Assert;
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


  @Test
  public void should_return_CrownCases_when_call_save_with_not_null(){
    CrownCaseDetail result = new CrownCaseDetail("dsad","asda");
    Assert.assertNotEquals(null,result);
  }

}