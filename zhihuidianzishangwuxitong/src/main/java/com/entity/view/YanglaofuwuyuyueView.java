package com.entity.view;

import com.entity.YanglaofuwuyuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 服务预约
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("yanglaofuwuyuyue")
public class YanglaofuwuyuyueView extends YanglaofuwuyuyueEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 状态的值
		*/
		private String yanglaofuwuyuyueStatusValue;



		//级联表 yanglaofuwu
			/**
			* 服务名称
			*/
			private String yanglaofuwuName;
			/**
			* 服务图片
			*/
			private String yanglaofuwuPhoto;
			/**
			* 服务类型
			*/
			private Integer yanglaofuwuTypes;
				/**
				* 服务类型的值
				*/
				private String yanglaofuwuValue;
			/**
			* 智慧养老服务 的 用户
			*/
			private Integer yanglaofuwuYonghuId;
			/**
			* 服务详情
			*/
			private String yanglaofuwuContent;

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

	public YanglaofuwuyuyueView() {

	}

	public YanglaofuwuyuyueView(YanglaofuwuyuyueEntity yanglaofuwuyuyueEntity) {
		try {
			BeanUtils.copyProperties(this, yanglaofuwuyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 状态的值
			*/
			public String getYanglaofuwuyuyueStatusValue() {
				return yanglaofuwuyuyueStatusValue;
			}
			/**
			* 设置： 状态的值
			*/
			public void setYanglaofuwuyuyueStatusValue(String yanglaofuwuyuyueStatusValue) {
				this.yanglaofuwuyuyueStatusValue = yanglaofuwuyuyueStatusValue;
			}




























				//级联表的get和set yanglaofuwu
					/**
					* 获取： 服务名称
					*/
					public String getYanglaofuwuName() {
						return yanglaofuwuName;
					}
					/**
					* 设置： 服务名称
					*/
					public void setYanglaofuwuName(String yanglaofuwuName) {
						this.yanglaofuwuName = yanglaofuwuName;
					}
					/**
					* 获取： 服务图片
					*/
					public String getYanglaofuwuPhoto() {
						return yanglaofuwuPhoto;
					}
					/**
					* 设置： 服务图片
					*/
					public void setYanglaofuwuPhoto(String yanglaofuwuPhoto) {
						this.yanglaofuwuPhoto = yanglaofuwuPhoto;
					}
					/**
					* 获取： 服务类型
					*/
					public Integer getYanglaofuwuTypes() {
						return yanglaofuwuTypes;
					}
					/**
					* 设置： 服务类型
					*/
					public void setYanglaofuwuTypes(Integer yanglaofuwuTypes) {
						this.yanglaofuwuTypes = yanglaofuwuTypes;
					}


						/**
						* 获取： 服务类型的值
						*/
						public String getYanglaofuwuValue() {
							return yanglaofuwuValue;
						}
						/**
						* 设置： 服务类型的值
						*/
						public void setYanglaofuwuValue(String yanglaofuwuValue) {
							this.yanglaofuwuValue = yanglaofuwuValue;
						}
					/**
					* 获取：智慧养老服务 的 用户
					*/
					public Integer getYanglaofuwuYonghuId() {
						return yanglaofuwuYonghuId;
					}
					/**
					* 设置：智慧养老服务 的 用户
					*/
					public void setYanglaofuwuYonghuId(Integer yanglaofuwuYonghuId) {
						this.yanglaofuwuYonghuId = yanglaofuwuYonghuId;
					}

					/**
					* 获取： 服务详情
					*/
					public String getYanglaofuwuContent() {
						return yanglaofuwuContent;
					}
					/**
					* 设置： 服务详情
					*/
					public void setYanglaofuwuContent(String yanglaofuwuContent) {
						this.yanglaofuwuContent = yanglaofuwuContent;
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
