package com.tw.apistackbase.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.tw.apistackbase.entity.CrownCase;
import java.util.ArrayList;
import java.util.List;
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
public class CrownCaseRepositoryTest {

  @Autowired
  private CrownCaseRepository crownCaseRepository;

  @Before
  public void setUp() {
    List<CrownCase> crownCases = new ArrayList<CrownCase>() {{
      add(new CrownCase(System.currentTimeMillis(), "case1"));
      add(new CrownCase(System.currentTimeMillis(), "case2"));
    }};

  }

  @Test
  public void should_return_CrownCase_when_call_save(){
    CrownCase crownCase = new CrownCase(System.currentTimeMillis(),"case3");
    CrownCase result = crownCaseRepository.save(crownCase);
    Assert.assertNotEquals(null,result);
  }
}