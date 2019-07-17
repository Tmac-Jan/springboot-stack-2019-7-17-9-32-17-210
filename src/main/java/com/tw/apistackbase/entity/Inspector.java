package com.tw.apistackbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Inspector {

  @Id
  @GeneratedValue
  private Integer id;

  @NotEmpty
  private String InspectorName;

  public Inspector(@NotEmpty String inspectorName) {
    InspectorName = inspectorName;
  }

  public Inspector() {
  }

  public Integer getId() {
    return id;
  }

  public String getInspectorName() {
    return InspectorName;
  }

  public void setInspectorName(String inspectorName) {
    InspectorName = inspectorName;
  }
}
