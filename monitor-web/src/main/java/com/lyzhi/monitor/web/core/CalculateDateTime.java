package com.lyzhi.monitor.web.core;

import com.lyzhi.monitor.web.constant.TimeSelectConstants;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * <p>
 * 计算日期时间
 * </p>
 *
 */
@Data
public class CalculateDateTime {

    /**
     * 时间类型
     */
    private String timeType;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * <p>
     * 构造方法
     * </p>
     *
     * @param timeType 时间类型
     *
     */
    public CalculateDateTime(String timeType) {
        this.timeType = timeType;
    }

    /**
     * <p>
     * 计算日期时间
     * </p>
     *
     * @return {@link CalculateDateTime}
     *
     */
    public CalculateDateTime invoke() {
        switch (timeType) {
            case TimeSelectConstants.HOUR:
                startTime = new DateTime().plusHours(-1).toDate();
                endTime = new Date();
                break;
            case TimeSelectConstants.DAY:
                startTime = new DateTime().plusDays(-1).toDate();
                endTime = new Date();
                break;
            case TimeSelectConstants.WEEK:
                startTime = new DateTime().plusWeeks(-1).toDate();
                endTime = new Date();
                break;
            case TimeSelectConstants.MONTH:
                startTime = new DateTime().plusMonths(-1).toDate();
                endTime = new Date();
                break;
            case TimeSelectConstants.HALF_YEAR:
                startTime = new DateTime().plusMonths(-6).toDate();
                endTime = new Date();
                break;
            case TimeSelectConstants.YEAR:
                startTime = new DateTime().plusYears(-1).toDate();
                endTime = new Date();
                break;
            default:
                break;
        }
        return this;
    }
}
