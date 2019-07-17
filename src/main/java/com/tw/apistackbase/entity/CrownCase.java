package com.tw.apistackbase.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CrownCase {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(name="case_time",nullable = false)
  private Long caseTime;

  @Column(name="case_name",nullable = false)
  private String caseName;

  @OneToOne(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
  @JoinColumn(name="crownCaseDetailId",referencedColumnName = "id")
  private CrownCaseDetail crownCaseDetail;

  @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  @JoinColumn(name="procuratorateId",referencedColumnName = "id")
  @NotNull
  private Procuratorate procuratorate;
  public CrownCase() {
  }

  public CrownCase(Long caseTime, String caseName,
      CrownCaseDetail crownCaseDetail) {
    this.caseTime = caseTime;
    this.caseName = caseName;
    this.crownCaseDetail = crownCaseDetail;
  }

  public CrownCase(Long caseTime, String caseName) {
    this.caseTime = caseTime;
    this.caseName = caseName;
  }

  public CrownCase(Long caseTime, String caseName,
      CrownCaseDetail crownCaseDetail, Procuratorate procuratorate) {
    this.caseTime = caseTime;
    this.caseName = caseName;
    this.crownCaseDetail = crownCaseDetail;
    this.procuratorate = procuratorate;
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

  public CrownCaseDetail getCrownCaseDetail() {
    return crownCaseDetail;
  }

  public void setCrownCaseDetail(CrownCaseDetail crownCaseDetail) {
    this.crownCaseDetail = crownCaseDetail;
  }

  public Procuratorate getProcuratorate() {
    return procuratorate;
  }

  public void setProcuratorate(Procuratorate procuratorate) {
    this.procuratorate = procuratorate;
  }
}

