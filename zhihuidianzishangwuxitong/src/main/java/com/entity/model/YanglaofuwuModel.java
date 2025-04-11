package com.entity.model;

import com.entity.YanglaofuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 智慧养老服务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YanglaofuwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 服务类型
     */
    private Integer yanglaofuwuTypes;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yanglaofuwuTime;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 状态
     */
    private Integer yanglaofuwuyuyueStatusTypes;


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
	 * 获取：服务类型
	 */
    public Integer getYanglaofuwuTypes() {
        return yanglaofuwuTypes;
    }


    /**
	 * 设置：服务类型
	 */
    public void setYanglaofuwuTypes(Integer yanglaofuwuTypes) {
        this.yanglaofuwuTypes = yanglaofuwuTypes;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getYanglaofuwuTime() {
        return yanglaofuwuTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setYanglaofuwuTime(Date yanglaofuwuTime) {
        this.yanglaofuwuTime = yanglaofuwuTime;
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
	 * 获取：状态
	 */
    public Integer getYanglaofuwuyuyueStatusTypes() {
        return yanglaofuwuyuyueStatusTypes;
    }


    /**
	 * 设置：状态
	 */
    public void setYanglaofuwuyuyueStatusTypes(Integer yanglaofuwuyuyueStatusTypes) {
        this.yanglaofuwuyuyueStatusTypes = yanglaofuwuyuyueStatusTypes;
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
