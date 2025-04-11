package com.dao;

import com.entity.YanglaofuwuyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YanglaofuwuyuyueView;

/**
 * 服务预约 Dao 接口
 *
 * @author 
 */
public interface YanglaofuwuyuyueDao extends BaseMapper<YanglaofuwuyuyueEntity> {

   List<YanglaofuwuyuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
