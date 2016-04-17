package com.rolex.haro.monitor.task;

import com.rolex.haro.monitor.dao.FlowDao;
import com.rolex.haro.monitor.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created with IntelliJ IDEA.
 * User: rolex
 * Date: 2016/4/17
 * version: 1.0
 */
public class Push {
    private int count = 0;
    Logger logger = LoggerFactory.getLogger(getClass());

    public void execute() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        logger.info("task push 正在执行......");
                        while (count < 10) {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            count++;
                        }
                        logger.info("task push 完成，正在保存配置......");
                        SpringUtil.getBean(FlowDao.class).complete(1, 2);
                    }
                }).start();
    }

}
