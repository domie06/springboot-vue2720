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
 * 志愿者
 *
 * @author 
 * @email
 */
@TableName("zhiyuanzhe")
public class ZhiyuanzheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhiyuanzheEntity() {

	}

	public ZhiyuanzheEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 志愿者姓名
     */
    @TableField(value = "zhiyuanzhe_name")

    private String zhiyuanzheName;


    /**
     * 头像
     */
    @TableField(value = "zhiyuanzhe_photo")

    private String zhiyuanzhePhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 联系方式
     */
    @TableField(value = "zhiyuanzhe_phone")

    private String zhiyuanzhePhone;


    /**
     * 邮箱
     */
    @TableField(value = "zhiyuanzhe_email")

    private String zhiyuanzheEmail;


    /**
     * 假删
     */
    @TableField(value = "zhiyuanzhe_delete")

    private Integer zhiyuanzheDelete;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：志愿者姓名
	 */
    public String getZhiyuanzheName() {
        return zhiyuanzheName;
    }


    /**
	 * 获取：志愿者姓名
	 */

    public void setZhiyuanzheName(String zhiyuanzheName) {
        this.zhiyuanzheName = zhiyuanzheName;
    }
    /**
	 * 设置：头像
	 */
    public String getZhiyuanzhePhoto() {
        return zhiyuanzhePhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setZhiyuanzhePhoto(String zhiyuanzhePhoto) {
        this.zhiyuanzhePhoto = zhiyuanzhePhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getZhiyuanzhePhone() {
        return zhiyuanzhePhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setZhiyuanzhePhone(String zhiyuanzhePhone) {
        this.zhiyuanzhePhone = zhiyuanzhePhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getZhiyuanzheEmail() {
        return zhiyuanzheEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setZhiyuanzheEmail(String zhiyuanzheEmail) {
        this.zhiyuanzheEmail = zhiyuanzheEmail;
    }
    /**
	 * 设置：假删
	 */
    public Integer getZhiyuanzheDelete() {
        return zhiyuanzheDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setZhiyuanzheDelete(Integer zhiyuanzheDelete) {
        this.zhiyuanzheDelete = zhiyuanzheDelete;
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
        return "Zhiyuanzhe{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", zhiyuanzheName=" + zhiyuanzheName +
            ", zhiyuanzhePhoto=" + zhiyuanzhePhoto +
            ", sexTypes=" + sexTypes +
            ", zhiyuanzhePhone=" + zhiyuanzhePhone +
            ", zhiyuanzheEmail=" + zhiyuanzheEmail +
            ", zhiyuanzheDelete=" + zhiyuanzheDelete +
            ", createTime=" + createTime +
        "}";
    }
}
