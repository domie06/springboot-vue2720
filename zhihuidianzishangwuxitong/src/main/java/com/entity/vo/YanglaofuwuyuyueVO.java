package com.entity.vo;

import com.entity.YanglaofuwuyuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 服务预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yanglaofuwuyuyue")
public class YanglaofuwuyuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 服务
     */

    @TableField(value = "yanglaofuwu_id")
    private Integer yanglaofuwuId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 状态
     */

    @TableField(value = "yanglaofuwuyuyue_status_types")
    private Integer yanglaofuwuyuyueStatusTypes;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：服务
	 */
    public Integer getYanglaofuwuId() {
        return yanglaofuwuId;
    }


    /**
	 * 获取：服务
	 */

    public void setYanglaofuwuId(Integer yanglaofuwuId) {
        this.yanglaofuwuId = yanglaofuwuId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：状态
	 */
    public Integer getYanglaofuwuyuyueStatusTypes() {
        return yanglaofuwuyuyueStatusTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setYanglaofuwuyuyueStatusTypes(Integer yanglaofuwuyuyueStatusTypes) {
        this.yanglaofuwuyuyueStatusTypes = yanglaofuwuyuyueStatusTypes;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
