package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Inspector;
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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class InspectorRepositoryTest {

  @Autowired
  private InspectorRepository inspectorRepository;

  @Before
  public void setUp() {
    List<Inspector> Inspectors = new ArrayList<Inspector>() {{
      add(new Inspector("Inspector1"));
      add(new Inspector("Inspector2"));
      add(new Inspector("Inspector3"));

    }};
    inspectorRepository.saveAll(Inspectors);
  }

  @Test
  @Transactional
  public void should_return_Inspector_when_call_save() {
    Inspector inspector = new Inspector("Inspector4");
    Inspector inspectorResult = inspectorRepository.save(inspector);
    Assert.assertNotEquals(null, inspectorResult);
  }

  @Test
  @Transactional
  public void should_return_Inspector_when_call_save_with_null_InspectorName() {
    Inspector inspector = new Inspector(null);
    Assertions.assertThrows(javax.validation.ConstraintViolationException.class, () ->
        inspectorRepository.saveAndFlush(inspector));
  }

  @Test
  @Transactional
  public void should_return_Inspectors_when_call_find_by_id() {
    Optional<Inspector> inspector =  inspectorRepository.findById(1);
    Assert.assertNotEquals(null,inspector.get());
  }
}