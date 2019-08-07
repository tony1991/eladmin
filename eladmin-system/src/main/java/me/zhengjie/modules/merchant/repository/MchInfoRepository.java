package me.zhengjie.modules.merchant.repository;

import me.zhengjie.modules.merchant.domain.MchInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author tony
* @date 2019-08-07
*/
public interface MchInfoRepository extends JpaRepository<MchInfo, String>, JpaSpecificationExecutor {
}