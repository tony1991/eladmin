package me.zhengjie.modules.order.service;

import me.zhengjie.modules.order.domain.TPayOrder;
import me.zhengjie.modules.order.service.dto.TPayOrderDTO;
import me.zhengjie.modules.order.service.dto.TPayOrderQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author tony
* @date 2019-08-07
*/
//@CacheConfig(cacheNames = "tPayOrder")
public interface TPayOrderService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(TPayOrderQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(TPayOrderQueryCriteria criteria);

    /**
     * findById
     * @param payOrderId
     * @return
     */
    //@Cacheable(key = "#p0")
    TPayOrderDTO findById(String payOrderId);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    TPayOrderDTO create(TPayOrder resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(TPayOrder resources);

    /**
     * delete
     * @param payOrderId
     */
    //@CacheEvict(allEntries = true)
    void delete(String payOrderId);
}