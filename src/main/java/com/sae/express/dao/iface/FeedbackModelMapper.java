package com.sae.express.dao.iface;

import com.sae.express.dao.model.FeedbackModel;
import com.sae.express.dao.model.FeedbackModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackModelMapper {
    int countByExample(FeedbackModelExample example);

    int deleteByExample(FeedbackModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FeedbackModel record);

    int insertSelective(FeedbackModel record);

    List<FeedbackModel> selectByExample(FeedbackModelExample example);

    FeedbackModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FeedbackModel record, @Param("example") FeedbackModelExample example);

    int updateByExample(@Param("record") FeedbackModel record, @Param("example") FeedbackModelExample example);

    int updateByPrimaryKeySelective(FeedbackModel record);

    int updateByPrimaryKey(FeedbackModel record);
}