package com.dao;

import com.entity.KafeiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KafeiOrderView;

/**
 * 商品订单 Dao 接口
 *
 * @author 
 */
public interface KafeiOrderDao extends BaseMapper<KafeiOrderEntity> {

   List<KafeiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
