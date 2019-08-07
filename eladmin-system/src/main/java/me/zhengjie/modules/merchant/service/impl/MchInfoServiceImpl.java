package me.zhengjie.modules.merchant.service.impl;

import me.zhengjie.modules.merchant.domain.MchInfo;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.merchant.repository.MchInfoRepository;
import me.zhengjie.modules.merchant.service.MchInfoService;
import me.zhengjie.modules.merchant.service.dto.MchInfoDTO;
import me.zhengjie.modules.merchant.service.dto.MchInfoQueryCriteria;
import me.zhengjie.modules.merchant.service.mapper.MchInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import cn.hutool.core.util.IdUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;

/**
* @author tony
* @date 2019-08-07
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MchInfoServiceImpl implements MchInfoService {

    @Autowired
    private MchInfoRepository mchInfoRepository;

    @Autowired
    private MchInfoMapper mchInfoMapper;

    @Override
    public Object queryAll(MchInfoQueryCriteria criteria, Pageable pageable){
        Page<MchInfo> page = mchInfoRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(mchInfoMapper::toDto));
    }

    @Override
    public Object queryAll(MchInfoQueryCriteria criteria){
        return mchInfoMapper.toDto(mchInfoRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public MchInfoDTO findById(String mchId) {
        Optional<MchInfo> mchInfo = mchInfoRepository.findById(mchId);
        ValidationUtil.isNull(mchInfo,"MchInfo","mchId",mchId);
        return mchInfoMapper.toDto(mchInfo.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MchInfoDTO create(MchInfo resources) {
        resources.setMchId(IdUtil.simpleUUID()); 
        return mchInfoMapper.toDto(mchInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(MchInfo resources) {
        Optional<MchInfo> optionalMchInfo = mchInfoRepository.findById(resources.getMchId());
        ValidationUtil.isNull( optionalMchInfo,"MchInfo","id",resources.getMchId());
        MchInfo mchInfo = optionalMchInfo.get();
        mchInfo.copy(resources);
        mchInfoRepository.save(mchInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String mchId) {
        mchInfoRepository.deleteById(mchId);
    }
}