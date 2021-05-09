package com.mashibing.apipassenger.ribbonconfig;

import com.mashibing.apipassenger.annotation.ExcudeRibbonConfig;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;

/**
 * 该类不应该在主应用程序的扫描之下，需要修改启动类的扫描配置。否则将被所有的Ribbon client共享，
 * 比如此例中：ribbonRule 对象 会共享。
 * @author yueyi2019
 *
 */
//@Configuration
@ExcudeRibbonConfig
public class RibbonConfiguration {

	@Bean
	public IRule ribbonRule() {
		return new MsbRandomRule();


	}

	
	
}