package com.myspring.boot.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * es 包装实体
 * @author hitopei
 */
@Data
@Document(indexName = "monitoralarm", type = "monitorAlarms")
public class MonitorAlarmVo implements Serializable {
    private static final long serialVersionUID = 6320548148250372657L;

    @Id
    private Long id;
    private String uniqueKey;
    private Long monitoryPointId;
    private int modelDivisionType;
    private Long groupId;
    private int type;
    private int status;
    private String serverHost;
    private String data;
    private int picWidth;
    private int picHeight;
    private String objects;
    private Date alarmTime;
    private Date createTime;
    private boolean isRemove;
    private Date removeTime;
}
