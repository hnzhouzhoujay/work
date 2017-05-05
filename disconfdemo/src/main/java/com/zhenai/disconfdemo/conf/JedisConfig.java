package com.zhenai.disconfdemo.conf;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfItem;

@Service
@Scope("singleton")
@DisconfFile(filename="redis.properties")
public class JedisConfig {
	
	private String host;
	
	private Integer port;
	
	@DisconfItem(key="redis.host",associateField="host")
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	@DisconfItem(key="redis.port",associateField="port")
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

}
