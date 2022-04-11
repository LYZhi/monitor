package com.lyzhi.monitor.common.property.client;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 心跳属性
 */
@Data
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class MonitoringHeartbeatProperties {

	/**
	 * 心跳频率
	 */
	private long rate;

}
