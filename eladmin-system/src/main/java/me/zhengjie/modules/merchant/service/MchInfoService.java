package me.zhengjie.modules.merchant.service;

import me.zhengjie.modules.merchant.domain.MchInfo;
import me.zhengjie.modules.merchant.service.dto.MchInfoDTO;
import me.zhengjie.modules.merchant.service.dto.MchInfoQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author tony
* @date 2019-08-07
*/
//@CacheConfig(cacheNames = "mchInfo")
public interface MchInfoService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(MchInfoQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(MchInfoQueryCriteria criteria);

    /**
     * findById
     * @param mchId
     * @return
     */
    //@Cacheable(key = "#p0")
    MchInfoDTO findById(String mchId);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    MchInfoDTO create(MchInfo resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(MchInfo resources);

    /**
     * delete
     * @param mchId
     */
    //@CacheEvict(allEntries = true)
    void delete(String mchId);
}