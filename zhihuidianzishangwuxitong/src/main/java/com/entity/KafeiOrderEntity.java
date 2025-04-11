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
 * 商品订单
 *
 * @author 
 * @email
 */
@TableName("kafei_order")
public class KafeiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KafeiOrderEntity() {

	}

	public KafeiOrderEntity(T t) {
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
     * 订单号
     */
    @TableField(value = "kafei_order_uuid_number")

    private String kafeiOrderUuidNumber;


    /**
     * 收货地址
     */
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 商品
     */
    @TableField(value = "kafei_id")

    private Integer kafeiId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买数量
     */
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @TableField(value = "kafei_order_true_price")

    private Double kafeiOrderTruePrice;


    /**
     * 订单类型
     */
    @TableField(value = "kafei_order_types")

    private Integer kafeiOrderTypes;


    /**
     * 支付类型
     */
    @TableField(value = "kafei_order_payment_types")

    private Integer kafeiOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：订单号
	 */
    public String getKafeiOrderUuidNumber() {
        return kafeiOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setKafeiOrderUuidNumber(String kafeiOrderUuidNumber) {
        this.kafeiOrderUuidNumber = kafeiOrderUuidNumber;
    }
    /**
	 * 设置：收货地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：商品
	 */
    public Integer getKafeiId() {
        return kafeiId;
    }


    /**
	 * 获取：商品
	 */

    public void setKafeiId(Integer kafeiId) {
        this.kafeiId = kafeiId;
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
	 * 设置：购买数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getKafeiOrderTruePrice() {
        return kafeiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setKafeiOrderTruePrice(Double kafeiOrderTruePrice) {
        this.kafeiOrderTruePrice = kafeiOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getKafeiOrderTypes() {
        return kafeiOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setKafeiOrderTypes(Integer kafeiOrderTypes) {
        this.kafeiOrderTypes = kafeiOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getKafeiOrderPaymentTypes() {
        return kafeiOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setKafeiOrderPaymentTypes(Integer kafeiOrderPaymentTypes) {
        this.kafeiOrderPaymentTypes = kafeiOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "KafeiOrder{" +
            "id=" + id +
            ", kafeiOrderUuidNumber=" + kafeiOrderUuidNumber +
            ", addressId=" + addressId +
            ", kafeiId=" + kafeiId +
            ", yonghuId=" + yonghuId +
            ", buyNumber=" + buyNumber +
            ", kafeiOrderTruePrice=" + kafeiOrderTruePrice +
            ", kafeiOrderTypes=" + kafeiOrderTypes +
            ", kafeiOrderPaymentTypes=" + kafeiOrderPaymentTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
