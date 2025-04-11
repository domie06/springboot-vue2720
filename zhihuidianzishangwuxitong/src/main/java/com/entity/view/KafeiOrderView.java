package com.entity.view;

import com.entity.KafeiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("kafei_order")
public class KafeiOrderView extends KafeiOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 订单类型的值
		*/
		private String kafeiOrderValue;
		/**
		* 支付类型的值
		*/
		private String kafeiOrderPaymentValue;



		//级联表 address
			/**
			* 收货地址 的 创建用户
			*/
			private Integer addressYonghuId;
			/**
			* 收货人
			*/
			private String addressName;
			/**
			* 电话
			*/
			private String addressPhone;
			/**
			* 地址
			*/
			private String addressDizhi;
			/**
			* 是否默认地址
			*/
			private Integer isdefaultTypes;
				/**
				* 是否默认地址的值
				*/
				private String isdefaultValue;

		//级联表 kafei
			/**
			* 商品 的 商家
			*/
			private Integer kafeiShangjiaId;
			/**
			* 商品名称
			*/
			private String kafeiName;
			/**
			* 商品照片
			*/
			private String kafeiPhoto;
			/**
			* 商品类型
			*/
			private Integer kafeiTypes;
				/**
				* 商品类型的值
				*/
				private String kafeiValue;
			/**
			* 商品库存
			*/
			private Integer kafeiKucunNumber;
			/**
			* 商品原价
			*/
			private Double kafeiOldMoney;
			/**
			* 现价
			*/
			private Double kafeiNewMoney;
			/**
			* 点击次数
			*/
			private Integer kafeiClicknum;
			/**
			* 是否上架
			*/
			private Integer shangxiaTypes;
				/**
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer kafeiDelete;
			/**
			* 商品简介
			*/
			private String kafeiContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public KafeiOrderView() {

	}

	public KafeiOrderView(KafeiOrderEntity kafeiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, kafeiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 订单类型的值
			*/
			public String getKafeiOrderValue() {
				return kafeiOrderValue;
			}
			/**
			* 设置： 订单类型的值
			*/
			public void setKafeiOrderValue(String kafeiOrderValue) {
				this.kafeiOrderValue = kafeiOrderValue;
			}
			/**
			* 获取： 支付类型的值
			*/
			public String getKafeiOrderPaymentValue() {
				return kafeiOrderPaymentValue;
			}
			/**
			* 设置： 支付类型的值
			*/
			public void setKafeiOrderPaymentValue(String kafeiOrderPaymentValue) {
				this.kafeiOrderPaymentValue = kafeiOrderPaymentValue;
			}




				//级联表的get和set address
					/**
					* 获取：收货地址 的 创建用户
					*/
					public Integer getAddressYonghuId() {
						return addressYonghuId;
					}
					/**
					* 设置：收货地址 的 创建用户
					*/
					public void setAddressYonghuId(Integer addressYonghuId) {
						this.addressYonghuId = addressYonghuId;
					}

					/**
					* 获取： 收货人
					*/
					public String getAddressName() {
						return addressName;
					}
					/**
					* 设置： 收货人
					*/
					public void setAddressName(String addressName) {
						this.addressName = addressName;
					}
					/**
					* 获取： 电话
					*/
					public String getAddressPhone() {
						return addressPhone;
					}
					/**
					* 设置： 电话
					*/
					public void setAddressPhone(String addressPhone) {
						this.addressPhone = addressPhone;
					}
					/**
					* 获取： 地址
					*/
					public String getAddressDizhi() {
						return addressDizhi;
					}
					/**
					* 设置： 地址
					*/
					public void setAddressDizhi(String addressDizhi) {
						this.addressDizhi = addressDizhi;
					}
					/**
					* 获取： 是否默认地址
					*/
					public Integer getIsdefaultTypes() {
						return isdefaultTypes;
					}
					/**
					* 设置： 是否默认地址
					*/
					public void setIsdefaultTypes(Integer isdefaultTypes) {
						this.isdefaultTypes = isdefaultTypes;
					}


						/**
						* 获取： 是否默认地址的值
						*/
						public String getIsdefaultValue() {
							return isdefaultValue;
						}
						/**
						* 设置： 是否默认地址的值
						*/
						public void setIsdefaultValue(String isdefaultValue) {
							this.isdefaultValue = isdefaultValue;
						}













				//级联表的get和set kafei
					/**
					* 获取：商品 的 商家
					*/
					public Integer getKafeiShangjiaId() {
						return kafeiShangjiaId;
					}
					/**
					* 设置：商品 的 商家
					*/
					public void setKafeiShangjiaId(Integer kafeiShangjiaId) {
						this.kafeiShangjiaId = kafeiShangjiaId;
					}

					/**
					* 获取： 商品名称
					*/
					public String getKafeiName() {
						return kafeiName;
					}
					/**
					* 设置： 商品名称
					*/
					public void setKafeiName(String kafeiName) {
						this.kafeiName = kafeiName;
					}
					/**
					* 获取： 商品照片
					*/
					public String getKafeiPhoto() {
						return kafeiPhoto;
					}
					/**
					* 设置： 商品照片
					*/
					public void setKafeiPhoto(String kafeiPhoto) {
						this.kafeiPhoto = kafeiPhoto;
					}
					/**
					* 获取： 商品类型
					*/
					public Integer getKafeiTypes() {
						return kafeiTypes;
					}
					/**
					* 设置： 商品类型
					*/
					public void setKafeiTypes(Integer kafeiTypes) {
						this.kafeiTypes = kafeiTypes;
					}


						/**
						* 获取： 商品类型的值
						*/
						public String getKafeiValue() {
							return kafeiValue;
						}
						/**
						* 设置： 商品类型的值
						*/
						public void setKafeiValue(String kafeiValue) {
							this.kafeiValue = kafeiValue;
						}
					/**
					* 获取： 商品库存
					*/
					public Integer getKafeiKucunNumber() {
						return kafeiKucunNumber;
					}
					/**
					* 设置： 商品库存
					*/
					public void setKafeiKucunNumber(Integer kafeiKucunNumber) {
						this.kafeiKucunNumber = kafeiKucunNumber;
					}
					/**
					* 获取： 商品原价
					*/
					public Double getKafeiOldMoney() {
						return kafeiOldMoney;
					}
					/**
					* 设置： 商品原价
					*/
					public void setKafeiOldMoney(Double kafeiOldMoney) {
						this.kafeiOldMoney = kafeiOldMoney;
					}
					/**
					* 获取： 现价
					*/
					public Double getKafeiNewMoney() {
						return kafeiNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setKafeiNewMoney(Double kafeiNewMoney) {
						this.kafeiNewMoney = kafeiNewMoney;
					}
					/**
					* 获取： 点击次数
					*/
					public Integer getKafeiClicknum() {
						return kafeiClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setKafeiClicknum(Integer kafeiClicknum) {
						this.kafeiClicknum = kafeiClicknum;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getKafeiDelete() {
						return kafeiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setKafeiDelete(Integer kafeiDelete) {
						this.kafeiDelete = kafeiDelete;
					}
					/**
					* 获取： 商品简介
					*/
					public String getKafeiContent() {
						return kafeiContent;
					}
					/**
					* 设置： 商品简介
					*/
					public void setKafeiContent(String kafeiContent) {
						this.kafeiContent = kafeiContent;
					}

























				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}












}
