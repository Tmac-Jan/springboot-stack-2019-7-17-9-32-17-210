package com.tw.apistackbase.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.tw.apistackbase.entity.CrownCase;
import com.tw.apistackbase.entity.Procuratorate;
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
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ProcuratorateRepositoryTest {

  @Autowired
  private ProcuratorateRepository procuratorateRepository;

  @Before
  public void setUp() {
    List<Procuratorate> Procuratorates = new ArrayList<Procuratorate>() {{
      add(new Procuratorate("Procuratorate1"));
      add(new Procuratorate("Procuratorate2"));
      add(new Procuratorate("Procuratorate3"));

    }};
    procuratorateRepository.saveAll(Procuratorates);
  }

  @Test
  @Transactional
  public void should_return_Procuratorate_when_call_save(){
    Procuratorate procuratorate = new Procuratorate("Procuratorate4");
    Procuratorate procuratorateResult = procuratorateRepository.save(procuratorate);
    Assert.assertNotEquals(null,procuratorateResult);
  }

  @Test
  public void should_return_Procuratorate_when_call_find_by_Id(){
    Optional<Procuratorate> procuratorateResult = procuratorateRepository.findById(1);
    Assert.assertNotEquals(null,procuratorateResult.get());
  }
}