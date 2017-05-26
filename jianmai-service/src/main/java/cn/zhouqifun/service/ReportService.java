package cn.zhouqifun.service;

import cn.zhouqifun.pojo.Report;

/**
 * Created by zhouqi on 2017/4/27.
 */
public interface ReportService {

    /**
     * 用户举报
     * @param report
     * @return
     */
    int insertForReport(Report report);
}
