package com.hellojqk.jsbdemo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TAccountCart")
@TableName("TAccountCart")
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