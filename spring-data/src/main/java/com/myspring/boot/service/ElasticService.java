package com.myspring.boot.service;

import com.myspring.boot.domain.MonitorAlarmVo;
import com.myspring.boot.mapper.MonitorAlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * es Service
 * @author hitopei
 */
@Service
public class ElasticService {
    @Autowired
    private MonitorAlarmRepository monitorAlarmRepository;

    public MonitorAlarmVo save(MonitorAlarmVo monitorAlarmVo){

        return monitorAlarmRepository.save(monitorAlarmVo);
    }

    public MonitorAlarmVo getById(Long id){
        Optional<MonitorAlarmVo> result = monitorAlarmRepository.findById(id);
        return result.orElse(null);
    }

}
