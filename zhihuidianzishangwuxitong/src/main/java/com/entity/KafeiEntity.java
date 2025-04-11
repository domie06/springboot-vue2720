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
 * 商品
 *
 * @author 
 * @email
 */
@TableName("kafei")
public class KafeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KafeiEntity() {

	}

	public KafeiEntity(T t) {
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
     * 商家
     */
    @TableField(value = "shangjia_id")

    private Integer shangjiaId;


    /**
     * 商品名称
     */
    @TableField(value = "kafei_name")

    private String kafeiName;


    /**
     * 商品照片
     */
    @TableField(value = "kafei_photo")

    private String kafeiPhoto;


    /**
     * 商品类型
     */
    @TableField(value = "kafei_types")

    private Integer kafeiTypes;


    /**
     * 商品库存
     */
    @TableField(value = "kafei_kucun_number")

    private Integer kafeiKucunNumber;


    /**
     * 商品原价
     */
    @TableField(value = "kafei_old_money")

    private Double kafeiOldMoney;


    /**
     * 现价
     */
    @TableField(value = "kafei_new_money")

    private Double kafeiNewMoney;


    /**
     * 点击次数
     */
    @TableField(value = "kafei_clicknum")

    private Integer kafeiClicknum;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "kafei_delete")

    private Integer kafeiDelete;


    /**
     * 商品简介
     */
    @TableField(value = "kafei_content")

    private String kafeiContent;


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
	 * 设置：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：商品名称
	 */
    public String getKafeiName() {
        return kafeiName;
    }


    /**
	 * 获取：商品名称
	 */

    public void setKafeiName(String kafeiName) {
        this.kafeiName = kafeiName;
    }
    /**
	 * 设置：商品照片
	 */
    public String getKafeiPhoto() {
        return kafeiPhoto;
    }


    /**
	 * 获取：商品照片
	 */

    public void setKafeiPhoto(String kafeiPhoto) {
        this.kafeiPhoto = kafeiPhoto;
    }
    /**
	 * 设置：商品类型
	 */
    public Integer getKafeiTypes() {
        return kafeiTypes;
    }


    /**
	 * 获取：商品类型
	 */

    public void setKafeiTypes(Integer kafeiTypes) {
        this.kafeiTypes = kafeiTypes;
    }
    /**
	 * 设置：商品库存
	 */
    public Integer getKafeiKucunNumber() {
        return kafeiKucunNumber;
    }


    /**
	 * 获取：商品库存
	 */

    public void setKafeiKucunNumber(Integer kafeiKucunNumber) {
        this.kafeiKucunNumber = kafeiKucunNumber;
    }
    /**
	 * 设置：商品原价
	 */
    public Double getKafeiOldMoney() {
        return kafeiOldMoney;
    }


    /**
	 * 获取：商品原价
	 */

    public void setKafeiOldMoney(Double kafeiOldMoney) {
        this.kafeiOldMoney = kafeiOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getKafeiNewMoney() {
        return kafeiNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setKafeiNewMoney(Double kafeiNewMoney) {
        this.kafeiNewMoney = kafeiNewMoney;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getKafeiClicknum() {
        return kafeiClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setKafeiClicknum(Integer kafeiClicknum) {
        this.kafeiClicknum = kafeiClicknum;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getKafeiDelete() {
        return kafeiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setKafeiDelete(Integer kafeiDelete) {
        this.kafeiDelete = kafeiDelete;
    }
    /**
	 * 设置：商品简介
	 */
    public String getKafeiContent() {
        return kafeiContent;
    }


    /**
	 * 获取：商品简介
	 */

    public void setKafeiContent(String kafeiContent) {
        this.kafeiContent = kafeiContent;
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
        return "Kafei{" +
            "id=" + id +
            ", shangjiaId=" + shangjiaId +
            ", kafeiName=" + kafeiName +
            ", kafeiPhoto=" + kafeiPhoto +
            ", kafeiTypes=" + kafeiTypes +
            ", kafeiKucunNumber=" + kafeiKucunNumber +
            ", kafeiOldMoney=" + kafeiOldMoney +
            ", kafeiNewMoney=" + kafeiNewMoney +
            ", kafeiClicknum=" + kafeiClicknum +
            ", shangxiaTypes=" + shangxiaTypes +
            ", kafeiDelete=" + kafeiDelete +
            ", kafeiContent=" + kafeiContent +
            ", createTime=" + createTime +
        "}";
    }
}
