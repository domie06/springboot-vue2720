package com.entity.view;

import com.entity.ZhiyuanzheshenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 志愿者申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhiyuanzheshenqing")
public class ZhiyuanzheshenqingView extends ZhiyuanzheshenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请审核的值
		*/
		private String zhiyuanzheshenqingYesnoValue;



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

		//级联表 zhiyuanzhe
			/**
			* 志愿者姓名
			*/
			private String zhiyuanzheName;
			/**
			* 头像
			*/
			private String zhiyuanzhePhoto;
			/**
			* 联系方式
			*/
			private String zhiyuanzhePhone;
			/**
			* 邮箱
			*/
			private String zhiyuanzheEmail;
			/**
			* 假删
			*/
			private Integer zhiyuanzheDelete;

	public ZhiyuanzheshenqingView() {

	}

	public ZhiyuanzheshenqingView(ZhiyuanzheshenqingEntity zhiyuanzheshenqingEntity) {
		try {
			BeanUtils.copyProperties(this, zhiyuanzheshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 申请审核的值
			*/
			public String getZhiyuanzheshenqingYesnoValue() {
				return zhiyuanzheshenqingYesnoValue;
			}
			/**
			* 设置： 申请审核的值
			*/
			public void setZhiyuanzheshenqingYesnoValue(String zhiyuanzheshenqingYesnoValue) {
				this.zhiyuanzheshenqingYesnoValue = zhiyuanzheshenqingYesnoValue;
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




				//级联表的get和set zhiyuanzhe
					/**
					* 获取： 志愿者姓名
					*/
					public String getZhiyuanzheName() {
						return zhiyuanzheName;
					}
					/**
					* 设置： 志愿者姓名
					*/
					public void setZhiyuanzheName(String zhiyuanzheName) {
						this.zhiyuanzheName = zhiyuanzheName;
					}
					/**
					* 获取： 头像
					*/
					public String getZhiyuanzhePhoto() {
						return zhiyuanzhePhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setZhiyuanzhePhoto(String zhiyuanzhePhoto) {
						this.zhiyuanzhePhoto = zhiyuanzhePhoto;
					}
					/**
					* 获取： 联系方式
					*/
					public String getZhiyuanzhePhone() {
						return zhiyuanzhePhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setZhiyuanzhePhone(String zhiyuanzhePhone) {
						this.zhiyuanzhePhone = zhiyuanzhePhone;
					}
					/**
					* 获取： 邮箱
					*/
					public String getZhiyuanzheEmail() {
						return zhiyuanzheEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setZhiyuanzheEmail(String zhiyuanzheEmail) {
						this.zhiyuanzheEmail = zhiyuanzheEmail;
					}
					/**
					* 获取： 假删
					*/
					public Integer getZhiyuanzheDelete() {
						return zhiyuanzheDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setZhiyuanzheDelete(Integer zhiyuanzheDelete) {
						this.zhiyuanzheDelete = zhiyuanzheDelete;
					}






}
