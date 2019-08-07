package me.zhengjie.modules.order.service.impl;

import me.zhengjie.modules.order.domain.TPayOrder;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.order.repository.TPayOrderRepository;
import me.zhengjie.modules.order.service.TPayOrderService;
import me.zhengjie.modules.order.service.dto.TPayOrderDTO;
import me.zhengjie.modules.order.service.dto.TPayOrderQueryCriteria;
import me.zhengjie.modules.order.service.mapper.TPayOrderMapper;
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
public class TPayOrderServiceImpl implements TPayOrderService {

    @Autowired
    private TPayOrderRepository tPayOrderRepository;

    @Autowired
    private TPayOrderMapper tPayOrderMapper;

    @Override
    public Object queryAll(TPayOrderQueryCriteria criteria, Pageable pageable){
        Page<TPayOrder> page = tPayOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tPayOrderMapper::toDto));
    }

    @Override
    public Object queryAll(TPayOrderQueryCriteria criteria){
        return tPayOrderMapper.toDto(tPayOrderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public TPayOrderDTO findById(String payOrderId) {
        Optional<TPayOrder> tPayOrder = tPayOrderRepository.findById(payOrderId);
        ValidationUtil.isNull(tPayOrder,"TPayOrder","payOrderId",payOrderId);
        return tPayOrderMapper.toDto(tPayOrder.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TPayOrderDTO create(TPayOrder resources) {
        resources.setPayOrderId(IdUtil.simpleUUID()); 
        return tPayOrderMapper.toDto(tPayOrderRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TPayOrder resources) {
        Optional<TPayOrder> optionalTPayOrder = tPayOrderRepository.findById(resources.getPayOrderId());
        ValidationUtil.isNull( optionalTPayOrder,"TPayOrder","id",resources.getPayOrderId());
        TPayOrder tPayOrder = optionalTPayOrder.get();
        tPayOrder.copy(resources);
        tPayOrderRepository.save(tPayOrder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String payOrderId) {
        tPayOrderRepository.deleteById(payOrderId);
    }
}