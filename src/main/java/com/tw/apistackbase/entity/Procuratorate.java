package com.tw.apistackbase.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Procuratorate {


  @Id
  @GeneratedValue
  private Integer id;

  @Column(name="procuratorate_name",length = 50,unique = true)
  private String procuratorateName;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  private List<Inspector> inspectors;

  public Procuratorate(String procuratorateName) {
    this.procuratorateName = procuratorateName;
  }
  public Procuratorate(){}

  public Procuratorate(String procuratorateName,
      List<Inspector> inspectors) {
    this.procuratorateName = procuratorateName;
    this.inspectors = inspectors;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProcuratorateName() {
    return procuratorateName;
  }

  public void setProcuratorateName(String procuratorateName) {
    this.procuratorateName = procuratorateName;
  }

  public List<Inspector> getInspectors() {
    return inspectors;
  }

  public void setInspectors(List<Inspector> inspectors) {
    this.inspectors = inspectors;
  }
}
