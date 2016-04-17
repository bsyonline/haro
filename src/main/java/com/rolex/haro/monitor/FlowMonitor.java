package com.rolex.haro.monitor;

import com.rolex.haro.monitor.beans.Flow;
import com.rolex.haro.monitor.beans.Task;
import com.rolex.haro.monitor.dao.FlowDao;
import com.rolex.haro.monitor.task.Change;
import com.rolex.haro.monitor.task.Push;
import com.rolex.haro.monitor.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: rolex
 * Date: 2016/4/17
 * version: 1.0
 */
public class FlowMonitor extends Thread {

    Logger logger = LoggerFactory.getLogger(getClass());

    private String currentItem;

    @Override
    public void run() {
        FlowDao flowDao = SpringUtil.getBean(FlowDao.class);

        while (true) {
            logger.info("检查流程执行进度......");
            Flow flow = flowDao.findFlow(1);
            if (flow.getStatus() == 0) {
                logger.info("{} 未启动，执行启动程序......", flow.getName());
                flowDao.startFlow(1);
                logger.info("{} 已启动，正在读取配置信息......", flow.getName());
                Task item = flowDao.findTask(flow.getCurrentTask().getTaskId());
                if (item.getStatus() == 0) {
                    new Change().execute();
                    flowDao.startTask(item.getTaskId(), item.getFlow().getId());
                    logger.info("task {} 已启动，下一个任务： {}......", item.getTaskName(), item.getNextTask().getTaskId());
                }
            } else if (flow.getStatus() == 1) {
                logger.info("{} 正在执行中, 当前任务： {}.", flow.getName(), flow.getCurrentTask().getTaskId());

                Task task = flowDao.findTask(flow.getCurrentTask().getTaskId());
                if (task.getStatus() == 1) {
                    logger.info("task {} 正在执行......", task.getTaskName());
                } else if (task.getStatus() == 2) {

                    if (task.getNextTask() == null) {
                        logger.info("task {} 已执行完成，没有后续任务.", task.getTaskName());
                    } else {
                        Task item = flowDao.startNext(flow.getId(), task.getTaskId());
                        logger.info("task {} 已执行完成，启动下一个task {}.", task.getTaskName(), task.getNextTask().getTaskId());
                        new Push().execute();
                        logger.info("task {} 已执行完成，启动下一个task {}.", task.getTaskName(), item.getTaskName());
                    }
                }


            } else if (flow.getStatus() == 2) {
                logger.info("{} 执行完成, 完成时间{}.", flow.getName(), flow.getCompleteTime());
                break;
            }

            try {
                logger.info("等待5秒.");
                Thread.sleep(5000);
                logger.info("重新执行监控.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new FlowMonitor().start();
    }
}
