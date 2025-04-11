package com.entity.model;

import com.entity.KafeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class KafeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 商家
     */
    private Integer shangjiaId;


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
     * 逻辑删除
     */
    private Integer kafeiDelete;


    /**
     * 商品简介
     */
    private String kafeiContent;


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
	 * 获取：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 设置：商家
	 */
    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 获取：商品名称
	 */
    public String getKafeiName() {
        return kafeiName;
    }


    /**
	 * 设置：商品名称
	 */
    public void setKafeiName(String kafeiName) {
        this.kafeiName = kafeiName;
    }
    /**
	 * 获取：商品照片
	 */
    public String getKafeiPhoto() {
        return kafeiPhoto;
    }


    /**
	 * 设置：商品照片
	 */
    public void setKafeiPhoto(String kafeiPhoto) {
        this.kafeiPhoto = kafeiPhoto;
    }
    /**
	 * 获取：商品类型
	 */
    public Integer getKafeiTypes() {
        return kafeiTypes;
    }


    /**
	 * 设置：商品类型
	 */
    public void setKafeiTypes(Integer kafeiTypes) {
        this.kafeiTypes = kafeiTypes;
    }
    /**
	 * 获取：商品库存
	 */
    public Integer getKafeiKucunNumber() {
        return kafeiKucunNumber;
    }


    /**
	 * 设置：商品库存
	 */
    public void setKafeiKucunNumber(Integer kafeiKucunNumber) {
        this.kafeiKucunNumber = kafeiKucunNumber;
    }
    /**
	 * 获取：商品原价
	 */
    public Double getKafeiOldMoney() {
        return kafeiOldMoney;
    }


    /**
	 * 设置：商品原价
	 */
    public void setKafeiOldMoney(Double kafeiOldMoney) {
        this.kafeiOldMoney = kafeiOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getKafeiNewMoney() {
        return kafeiNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setKafeiNewMoney(Double kafeiNewMoney) {
        this.kafeiNewMoney = kafeiNewMoney;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getKafeiClicknum() {
        return kafeiClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setKafeiClicknum(Integer kafeiClicknum) {
        this.kafeiClicknum = kafeiClicknum;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getKafeiDelete() {
        return kafeiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setKafeiDelete(Integer kafeiDelete) {
        this.kafeiDelete = kafeiDelete;
    }
    /**
	 * 获取：商品简介
	 */
    public String getKafeiContent() {
        return kafeiContent;
    }


    /**
	 * 设置：商品简介
	 */
    public void setKafeiContent(String kafeiContent) {
        this.kafeiContent = kafeiContent;
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
