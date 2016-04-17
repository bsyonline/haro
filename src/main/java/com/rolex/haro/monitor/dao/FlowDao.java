package com.rolex.haro.monitor.dao;

import com.rolex.haro.monitor.beans.Flow;
import com.rolex.haro.monitor.beans.Task;
import com.rolex.haro.monitor.util.SpringUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: rolex
 * Date: 2016/4/17
 * version: 1.0
 */
@Repository
public class FlowDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Flow findFlow(int flowId) {
        String sql = "select * from t_flow i where i.id = " + flowId;
        Flow flow = new Flow();
        jdbcTemplate.query(sql, new Object[]{}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                flow.setId(resultSet.getInt("id"));
                flow.setName(resultSet.getString("name"));
                flow.setDate(resultSet.getDate("date"));
                flow.setStatus(resultSet.getInt("status"));
                flow.setCurrentTask(new Task(resultSet.getInt("current_task")));
                flow.setCompleteTime(resultSet.getDate("complete_time"));
            }
        });
        return flow;
    }

    public List<Task> findAllTask(int flowId) {
        String sql = "select * from t_flow_item i where i.flow_id = " + flowId + "order by `order` asc";
        List<Task> list = new ArrayList<>();
        jdbcTemplate.query(sql, new Object[]{}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                Task task = new Task();
                task.setTaskId(resultSet.getInt("task_id"));
                task.setTaskName(resultSet.getString("task_name"));
                task.setFlow(new Flow(resultSet.getInt("flow_id")));
                task.setStatus(resultSet.getInt("status"));
                task.setNextTask(resultSet.getInt("next_task") == 0 ? null : new Task(resultSet.getInt("next_task")));
                task.setCompleteTime(resultSet.getDate("complete_time"));
                task.setOrder(resultSet.getInt("order"));
                list.add(task);
            }
        });
        return list;
    }

    public Task findTask(int taskId) {
        String sql = "select * from t_flow_item i where i.item_id = " + taskId;
        Task task = new Task();
        jdbcTemplate.query(sql, new Object[]{}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                task.setTaskId(resultSet.getInt("task_id"));
                task.setTaskName(resultSet.getString("task_name"));
                task.setFlow(new Flow(resultSet.getInt("flow_id")));
                task.setStatus(resultSet.getInt("status"));
                task.setNextTask(resultSet.getInt("next_task") == 0 ? null : new Task(resultSet.getInt("next_task")));
                task.setCompleteTime(resultSet.getDate("complete_time"));
                task.setOrder(resultSet.getInt("order"));
            }
        });
        return task;
    }

    public void startFlow(int flowId) {
        String sql = "update t_flow i set i.status = 1 where i.id = " + flowId;
        jdbcTemplate.execute(sql);
    }

    public Task startNext(int flowId, int itemId) {
        int nextId = findTask(itemId).getNextTask().getTaskId();
        updateCurrent(flowId, findTask(nextId).getTaskId());
        return startTask(flowId, nextId);
    }

    public Task startTask(int flowId, int itemId) {
        String sql = "update t_flow_item i set i.status = 1 where i.item_id = " + itemId + " and flow_id = " + flowId;
        jdbcTemplate.execute(sql);
        return findTask(itemId);
    }

    public void updateCurrent(int flowId, int nextId) {
        String sql = "update t_flow i set i.current_task = " + nextId + " where i.id = " + flowId;
        jdbcTemplate.execute(sql);
    }

    public void complete(int flowId, int flowItemId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());

        String sql = "update t_flow_item i set i.status = 2, i.complete_time = '" + date + "' where i.item_id = " + flowItemId + " and i.flow_id = " + flowId;
        jdbcTemplate.execute(sql);
        Task item = findTask(flowItemId);
        if (item.getNextTask() == null) {
            jdbcTemplate.execute("update t_flow i set i.status = 2,i.current_task = null ,i.complete_time = '" + date + "' where i.id = " + flowId);
        } else {
            jdbcTemplate.execute("update t_flow i set i.current_item = " + item.getNextTask().getTaskId() + " where i.id = " + flowId);
        }
    }


    public static void main(String[] args) {
        FlowDao dao = SpringUtil.getBean(FlowDao.class);
        dao.complete(1, 2);
    }
}
