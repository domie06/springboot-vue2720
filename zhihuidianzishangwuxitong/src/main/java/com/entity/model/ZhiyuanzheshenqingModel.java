package com.entity.model;

import com.entity.ZhiyuanzheshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 志愿者申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhiyuanzheshenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 志愿者
     */
    private Integer zhiyuanzheId;


    /**
     * 申请审核
     */
    private Integer zhiyuanzheshenqingYesnoTypes;


    /**
     * 审核结果
     */
    private String zhiyuanzheshenqingYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }


    /**
	 * 设置：志愿者
	 */
    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 获取：申请审核
	 */
    public Integer getZhiyuanzheshenqingYesnoTypes() {
        return zhiyuanzheshenqingYesnoTypes;
    }


    /**
	 * 设置：申请审核
	 */
    public void setZhiyuanzheshenqingYesnoTypes(Integer zhiyuanzheshenqingYesnoTypes) {
        this.zhiyuanzheshenqingYesnoTypes = zhiyuanzheshenqingYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getZhiyuanzheshenqingYesnoText() {
        return zhiyuanzheshenqingYesnoText;
    }


    /**
	 * 设置：审核结果
	 */
    public void setZhiyuanzheshenqingYesnoText(String zhiyuanzheshenqingYesnoText) {
        this.zhiyuanzheshenqingYesnoText = zhiyuanzheshenqingYesnoText;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
