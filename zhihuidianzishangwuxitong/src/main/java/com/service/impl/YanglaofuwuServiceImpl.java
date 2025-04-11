package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import com.dao.YanglaofuwuDao;
import com.entity.YanglaofuwuEntity;
import com.service.YanglaofuwuService;
import com.entity.view.YanglaofuwuView;

/**
 * 智慧养老服务 服务实现类
 */
@Service("yanglaofuwuService")
@Transactional
public class YanglaofuwuServiceImpl extends ServiceImpl<YanglaofuwuDao, YanglaofuwuEntity> implements YanglaofuwuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YanglaofuwuView> page =new Query<YanglaofuwuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
