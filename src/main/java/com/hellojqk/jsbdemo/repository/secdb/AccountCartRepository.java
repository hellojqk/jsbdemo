package com.hellojqk.jsbdemo.repository.secdb;

import com.hellojqk.jsbdemo.domain.AccountCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface AccountCartRepository extends JpaSpecificationExecutor<AccountCart>,JpaRepository<AccountCart, Integer> {

}
