package com.tw.apistackbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CrownCaseDetail {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(name = "subjective_condition",nullable = false)
  private String subjectiveCondition;

  @Column(name = "objective_condition",nullable = false)
  private String objectiveCondition;

  public CrownCaseDetail() {

  }

  public CrownCaseDetail(String subjectiveCondition, String objectiveCondition) {
    this.subjectiveCondition = subjectiveCondition;
    this.objectiveCondition = objectiveCondition;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSubjectiveCondition() {
    return subjectiveCondition;
  }

  public void setSubjectiveCondition(String subjectiveCondition) {
    this.subjectiveCondition = subjectiveCondition;
  }

  public String getObjectiveCondition() {
    return objectiveCondition;
  }

  public void setObjectiveCondition(String objectiveCondition) {
    this.objectiveCondition = objectiveCondition;
  }
}
