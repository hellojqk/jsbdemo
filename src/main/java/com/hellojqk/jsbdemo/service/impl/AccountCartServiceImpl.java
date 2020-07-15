package com.hellojqk.jsbdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hellojqk.jsbdemo.domain.AccountCart;
import com.hellojqk.jsbdemo.mapper.AccountCartMapper;
import com.hellojqk.jsbdemo.repository.secdb.AccountCartRepository;
import com.hellojqk.jsbdemo.service.AccountCartService;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.OrderAdapter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountCartServiceImpl implements AccountCartService {

    @Autowired
    private AccountCartRepository accountCartRepository;

    @Autowired
    private AccountCartMapper accountCartMapper;

    @Override
    public Page<AccountCart> findByPageAndParams(int pageNumber, int pageSize) {
//       BasketCartId
        return accountCartRepository.findAll(PageRequest.of(1,10));
    }

    public int count(){
        QueryWrapper<AccountCart> query=new QueryWrapper<AccountCart>();
        return accountCartMapper.selectCount(query);
    }
}
