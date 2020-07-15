package com.hellojqk.jsbdemo.service;

import com.hellojqk.jsbdemo.domain.AccountCart;
import org.springframework.data.domain.Page;

public interface AccountCartService {
     Page<AccountCart> findByPageAndParams(int pageNumber, int pageSize);
     int count();
}
