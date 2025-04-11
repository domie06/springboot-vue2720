package com.entity.model;

import com.entity.YanglaofuwuyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 服务预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YanglaofuwuyuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 服务
     */
    private Integer yanglaofuwuId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 状态
     */
    private Integer yanglaofuwuyuyueStatusTypes;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：服务
	 */
    public Integer getYanglaofuwuId() {
        return yanglaofuwuId;
    }


    /**
	 * 设置：服务
	 */
    public void setYanglaofuwuId(Integer yanglaofuwuId) {
        this.yanglaofuwuId = yanglaofuwuId;
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
