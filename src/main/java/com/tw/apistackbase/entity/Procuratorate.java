package com.tw.apistackbase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Procuratorate {


  @Id
  @GeneratedValue
  private Integer id;

  @Column(name="procuratorate_name",length = 50,unique = true)
  private String procuratorateName;

  public Procuratorate(String procuratorateName) {
    this.procuratorateName = procuratorateName;
  }
  public Procuratorate(){}

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
}
