package com.lyzhi.monitor.common.web.toolkit;

import io.undertow.server.DefaultByteBufferPool;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

/**
 * <p>
 * 去掉Undertow的“Buffer pool was not set on WebSocketDeploymentInfo, the default pool will be used”警告。
 * </p>
 *
 */
public class CustomizationBeanHandler implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {

    /**
     * <p>
     * 自定义指定的{@link WebServerFactory}。
     * </p>
     *
     * @param factory web服务器工厂
     *
     */
    @Override
    public void customize(UndertowServletWebServerFactory factory) {
        factory.addDeploymentInfoCustomizers(deploymentInfo -> {
            WebSocketDeploymentInfo webSocketDeploymentInfo = new WebSocketDeploymentInfo();
            webSocketDeploymentInfo.setBuffers(new DefaultByteBufferPool(false, 1024));
            deploymentInfo.addServletContextAttribute("io.undertow.websockets.jsr.WebSocketDeploymentInfo", webSocketDeploymentInfo);
        });
    }
}
