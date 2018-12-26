package com.duteliang.geteway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zl
 * @Date: 2018-12-26 18:39
 */
@Component
@Slf4j
public class TestFilter extends ZuulFilter {

	/**
	 * 拦截类型 前置拦截
	 * @return
	 */
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	/**
	 * 拦截器的顺序， 每个类型的拦截器都有很多，需要制定一个顺序，
	 * 越小越靠前
	 * @return
	 */
	@Override
	public int filterOrder() {
		return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
	}

	/**
	 * 是否执行该过滤器，
	 * true  执行
	 * false 不执行
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		log.info("TestFilter  shouldFilter");
		return true;
	}

	/**
	 * 具体的拦截方法
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		log.info("TestFilter  run ");
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		HttpServletResponse response = currentContext.getResponse();

		/*
		 巴拉巴拉
		 */


		return null;
	}
}
