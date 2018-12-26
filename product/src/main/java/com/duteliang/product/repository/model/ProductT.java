package com.duteliang.product.repository.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 产品表
 * </p>
 *
 * @author zl
 * @since 2018-12-26
 */
@TableName("product_t")
public class ProductT extends Model<ProductT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品数量
     */
    private Integer num;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 商品类型 0-水果 1-电子
     */
    private Integer type;
    /**
     * 创建时间
     */
    @TableField("begin_time")
    private Date beginTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ProductT{" +
        "id=" + id +
        ", name=" + name +
        ", num=" + num +
        ", price=" + price +
        ", type=" + type +
        ", beginTime=" + beginTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
