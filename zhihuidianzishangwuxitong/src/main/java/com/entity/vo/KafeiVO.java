package com.entity.vo;

import com.entity.KafeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商品
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("kafei")
public class KafeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
