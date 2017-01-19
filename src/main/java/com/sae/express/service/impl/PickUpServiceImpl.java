package com.sae.express.service.impl;

import com.sae.express.dao.iface.PickUpInfoModelMapper;
import com.sae.express.dao.iface.PickUpModelMapper;
import com.sae.express.dao.model.PickUpInfoModel;
import com.sae.express.dao.model.PickUpInfoModelExample;
import com.sae.express.dao.model.PickUpModel;
import com.sae.express.dao.model.PickUpModelExample;
import com.sae.express.repository.DateRepository;
import com.sae.express.service.PickUpService;
import com.sae.express.util.tool.DateTool;
import com.sae.express.util.tool.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by luoqi on 2016-09-19.
 */
@Service
public class PickUpServiceImpl  implements PickUpService{

    @Autowired
    private PickUpModelMapper pickUpModelMapper;

    @Autowired
    private PickUpInfoModelMapper pickUpInfoModelMapper;

    @Autowired
    private DateRepository dateRepository;

    public List<PickUpModel> getPickUpModelPage(PickUpModelExample example){
        return pickUpModelMapper.selectByExample(example);
    }
    public PickUpModel insertPickUpModel(PickUpModel pickUpModel) {
        pickUpModel.setCreateTime(DateTool.parse(dateRepository.currentTime(),DateTool.YYYY_MM_DD_HH_MM_SS));
        pickUpModelMapper.insertSelective(pickUpModel);
        return pickUpModel;
    }

    public PickUpInfoModel insertPickUpInfoModel(PickUpInfoModel pickUpInfoModel){
        pickUpInfoModel.setCreateTime(DateTool.parse(dateRepository.currentTime(),DateTool.YYYY_MM_DD_HH_MM_SS));
        pickUpInfoModelMapper.insertSelective(pickUpInfoModel);
        return pickUpInfoModel;
    }


    public PickUpModel getPickUpModelById(Integer id) {
        return pickUpModelMapper.selectByPrimaryKey(id);
    }


    public List<PickUpInfoModel> getPickUpInfoModelList(Integer pickUpId) {
        PickUpInfoModelExample example = new PickUpInfoModelExample();
        PickUpInfoModelExample.Criteria criteria = example.createCriteria();

        criteria.andPickUpIdEqualTo(pickUpId);

        return pickUpInfoModelMapper.selectByExample(example);
    }


    public List<PickUpModel> getPickUpModel(String search) {
        PickUpModelExample example = new PickUpModelExample();

        if(StringTools.isNotBlank(search)){
            if(StringTools.isNumber(search)&&search.length()<6){
                PickUpModelExample.Criteria criteria = example.or();
                criteria.andIdEqualTo(Integer.valueOf(search));
            }else{
                PickUpModelExample.Criteria criteria = example.or();
                criteria.andUserNameEqualTo(search);
            }
        }


        return pickUpModelMapper.selectByExample(example);
    }

    public List<PickUpModel> getPickUpModelPage(Integer offset,Integer limit){
        PickUpModelExample example = new PickUpModelExample();
        PickUpModelExample.Criteria criteria = example.createCriteria();
        example.setOffset(offset);
        example.setLimit(limit);
        example.setOrderByClause("id desc");
        //支付成功
        criteria.andPayStatusEqualTo("1");
        return pickUpModelMapper.selectByExample(example);
    }


    public int updatePickUpStatus(Integer pickUpId, String status) {
        PickUpModel pickUpModel = new PickUpModel();
        pickUpModel.setPayStatus(status);
        pickUpModel.setId(pickUpId);
        return pickUpModelMapper.updateByPrimaryKeySelective(pickUpModel);
    }


    public List<PickUpModel> showPickUpModel(List<PickUpInfoModel> pickUpInfoModelList) {

        List<PickUpModel> pickUpModelList = null;
        if(pickUpInfoModelList != null && pickUpInfoModelList.size()>0){
            PickUpModelExample example = new PickUpModelExample();
            PickUpModelExample.Criteria criteria = example.createCriteria();
            example.setOrderByClause("id desc");
            //支付成功
            criteria.andPayStatusEqualTo("1");

            List<Integer> idList = new ArrayList<Integer>();
            for(PickUpInfoModel pickUpInfoModel:pickUpInfoModelList){
                idList.add(pickUpInfoModel.getPickUpId());
            }
            criteria.andIdIn(idList);
            pickUpModelList = pickUpModelMapper.selectByExample(example);

        }

        if(pickUpModelList == null)
            pickUpModelList =new ArrayList<PickUpModel>();

        return pickUpModelList;
    }

    public int updatePickUpOrderStatus(Integer pickUpId, String status) {
        PickUpModel pickUpModel = new PickUpModel();
        pickUpModel.setOrderStatus(status);
        pickUpModel.setId(pickUpId);
        return pickUpModelMapper.updateByPrimaryKeySelective(pickUpModel);
    }

    public List<PickUpModel> getPickUpModelByUserId(String userId) {
        PickUpModelExample example = new PickUpModelExample();
        PickUpModelExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return pickUpModelMapper.selectByExample(example);
    }

    public List<PickUpInfoModel> getPickUpInfoModelList(String date, String express) {
        PickUpInfoModelExample infoModelExample = new PickUpInfoModelExample();

        Date createDate = DateTool.parse(date,DateTool.YYYY_MM_DD);
        PickUpInfoModelExample.Criteria infoCriteria = infoModelExample.createCriteria();
        infoCriteria.andCreateTimeGreaterThanOrEqualTo(createDate);
        if(StringTools.isNotBlank(express))
            infoCriteria.andExpressEqualTo(express);
        return pickUpInfoModelMapper.selectByExample(infoModelExample);
    }
}
