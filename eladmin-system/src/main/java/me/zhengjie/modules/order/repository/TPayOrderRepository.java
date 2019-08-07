package me.zhengjie.modules.order.repository;

import me.zhengjie.modules.order.domain.TPayOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author tony
* @date 2019-08-07
*/
public interface TPayOrderRepository extends JpaRepository<TPayOrder, String>, JpaSpecificationExecutor {
}