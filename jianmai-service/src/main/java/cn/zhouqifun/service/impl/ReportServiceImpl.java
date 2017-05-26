package cn.zhouqifun.service.impl;

import cn.zhouqifun.mapper.ReportDao;
import cn.zhouqifun.pojo.Report;
import cn.zhouqifun.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhouqi on 2017/4/27.
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService{


    @Autowired
    private ReportDao reportDao;


    @Override
    public int insertForReport(Report report) {
        return reportDao.insertForReport(report);
    }
}
