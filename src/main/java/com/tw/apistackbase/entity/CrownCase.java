package com.tw.apistackbase.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CrownCase {
  @Id
  @GeneratedValue
  private Integer id;

  private Long caseTime;

  private String caseName;

  public CrownCase() {
  }

  public CrownCase(Long caseTime, String caseName) {
    this.caseTime = caseTime;
    this.caseName = caseName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Long getCaseTime() {
    return caseTime;
  }

  public void setCaseTime(Long caseTime) {
    this.caseTime = caseTime;
  }

  public String getCaseName() {
    return caseName;
  }

  public void setCaseName(String caseName) {
    this.caseName = caseName;
  }
}

