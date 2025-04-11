package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 志愿者申请
 *
 * @author 
 * @email
 */
@TableName("zhiyuanzheshenqing")
public class ZhiyuanzheshenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhiyuanzheshenqingEntity() {

	}

	public ZhiyuanzheshenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 志愿者
     */
    @TableField(value = "zhiyuanzhe_id")

    private Integer zhiyuanzheId;


    /**
     * 申请审核
     */
    @TableField(value = "zhiyuanzheshenqing_yesno_types")

    private Integer zhiyuanzheshenqingYesnoTypes;


    /**
     * 审核结果
     */
    @TableField(value = "zhiyuanzheshenqing_yesno_text")

    private String zhiyuanzheshenqingYesnoText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }


    /**
	 * 获取：志愿者
	 */

    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 设置：申请审核
	 */
    public Integer getZhiyuanzheshenqingYesnoTypes() {
        return zhiyuanzheshenqingYesnoTypes;
    }


    /**
	 * 获取：申请审核
	 */

    public void setZhiyuanzheshenqingYesnoTypes(Integer zhiyuanzheshenqingYesnoTypes) {
        this.zhiyuanzheshenqingYesnoTypes = zhiyuanzheshenqingYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getZhiyuanzheshenqingYesnoText() {
        return zhiyuanzheshenqingYesnoText;
    }


    /**
	 * 获取：审核结果
	 */

    public void setZhiyuanzheshenqingYesnoText(String zhiyuanzheshenqingYesnoText) {
        this.zhiyuanzheshenqingYesnoText = zhiyuanzheshenqingYesnoText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Zhiyuanzheshenqing{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", zhiyuanzheshenqingYesnoTypes=" + zhiyuanzheshenqingYesnoTypes +
            ", zhiyuanzheshenqingYesnoText=" + zhiyuanzheshenqingYesnoText +
            ", createTime=" + createTime +
        "}";
    }
}
