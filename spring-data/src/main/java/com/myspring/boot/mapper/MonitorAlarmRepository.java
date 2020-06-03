package com.myspring.boot.mapper;


import com.myspring.boot.domain.MonitorAlarmVo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author hitopei
 * es操作接口
 */
//Repository
public interface MonitorAlarmRepository extends ElasticsearchRepository<MonitorAlarmVo, Long> {
}
