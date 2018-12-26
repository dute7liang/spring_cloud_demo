package com.duteliang.geteway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @author: zl
 * @Date: 2018-12-26 18:47
 */
@Component
@Slf4j
public class RateLimitFilter extends ZuulFilter {

	private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 2;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		if(!RATE_LIMITER.tryAcquire()){
			log.info("令牌不够了！请骚等");
		}
		return null;
	}
}
