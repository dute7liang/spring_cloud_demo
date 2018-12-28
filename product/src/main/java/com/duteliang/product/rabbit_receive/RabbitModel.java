package com.duteliang.product.rabbit_receive;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zl
 * @Date: 2018-12-28 16:52
 */
@Data
@ToString
public class RabbitModel implements Serializable {

	private String name;
	private Integer age;
	private Date date;
	private Double dou;

}
