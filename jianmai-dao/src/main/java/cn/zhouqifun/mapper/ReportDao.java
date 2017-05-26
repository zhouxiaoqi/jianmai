package cn.zhouqifun.mapper;


import cn.zhouqifun.pojo.Report;

/**
 * 举报信息
 * Created by zhouqi on 2017/4/27.
 */

public interface ReportDao {

    /**
     * 用户举报
     * @param report
     * @return
     */
    int insertForReport(Report report);
}
