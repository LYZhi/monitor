package com.lyzhi.monitor.common.util.server;

import com.lyzhi.monitor.common.domain.Server;
import com.lyzhi.monitor.common.util.server.oshi.PowerSourceUtils;
import com.lyzhi.monitor.common.util.server.oshi.ProcessUtils;
import com.lyzhi.monitor.common.util.server.oshi.SensorsUtils;
import com.lyzhi.monitor.common.util.server.sigar.CpuUtils;
import com.lyzhi.monitor.common.util.server.sigar.DiskUtils;
import com.lyzhi.monitor.common.util.server.sigar.MemoryUtils;
import com.lyzhi.monitor.common.util.server.sigar.NetInterfaceUtils;
import org.hyperic.sigar.SigarException;

/**
 * <p>
 * 服务器信息工具类
 * </p>
 *
 */
public final class ServerUtils {

    /**
     * <p>
     * 屏蔽共有构造方法
     * </p>
     *
     * @author 皮锋
     */
    private ServerUtils() {
    }

    /**
     * <p>
     * 获取服务器信息
     * </p>
     *
     * @return {@link Server}
     * @throws SigarException Sigar异常

     */
    public static Server getServerInfo() throws SigarException {
        return Server.builder()
                .cpuDomain(CpuUtils.getCpuInfo())
                .memoryDomain(MemoryUtils.getMemoryInfo())
                .netDomain(NetInterfaceUtils.getNetInfo())
                .osDomain(OsUtils.getOsInfo())
                .diskDomain(DiskUtils.getDiskInfo())
                .powerSourcesDomain(PowerSourceUtils.getPowerSourcesInfo())
                .sensorsDomain(SensorsUtils.getSensorsInfo())
                .processDomain(ProcessUtils.getProcessInfo())
                .build();
    }

}
