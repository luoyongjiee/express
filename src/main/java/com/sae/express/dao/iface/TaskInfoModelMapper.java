package com.sae.express.dao.iface;

import com.sae.express.dao.model.TaskInfoModel;
import com.sae.express.dao.model.TaskInfoModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskInfoModelMapper {
    int countByExample(TaskInfoModelExample example);

    int deleteByExample(TaskInfoModelExample example);

    int deleteByPrimaryKey(Integer taskId);

    int insert(TaskInfoModel record);

    int insertSelective(TaskInfoModel record);

    List<TaskInfoModel> selectByExample(TaskInfoModelExample example);

    TaskInfoModel selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("record") TaskInfoModel record, @Param("example") TaskInfoModelExample example);

    int updateByExample(@Param("record") TaskInfoModel record, @Param("example") TaskInfoModelExample example);

    int updateByPrimaryKeySelective(TaskInfoModel record);

    int updateByPrimaryKey(TaskInfoModel record);
}