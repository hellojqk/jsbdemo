package com.hellojqk.jsbdemo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TAccountCart")
public class AccountCart {

  @Id
  @GeneratedValue
  private int basketCartId;
  @Column
  private int accountId;
  @Column
  private int itemSkuId;
  @Column
  private int qty;

}