package com.myspring.boot.controller;

import com.myspring.boot.domain.MonitorAlarmVo;
import com.myspring.boot.mapper.MonitorAlarmRepository;
import com.myspring.boot.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * es版本6.8.8
 * es测试controller
 * @author hitopei
 */
@RestController
@RequestMapping("/es")
public class TestController {

    @Autowired
    private ElasticService elasticService;

    @PostMapping("/insert")
    public MonitorAlarmVo insert(@RequestBody MonitorAlarmVo monitorAlarmVo){
        return elasticService.save(monitorAlarmVo);
    }

    @GetMapping("/get")
    public MonitorAlarmVo getById(){
        long id = 123456789L;
        return elasticService.getById(id);
    }
}
