package com.lyzhi.monitor.common.util.server.sigar;

import com.lyzhi.monitor.common.domain.server.DiskDomain;
import com.lyzhi.monitor.common.init.InitSigar;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.SigarException;

import java.util.List;

/**
 * <p>
 * 磁盘工具类
 * </p>
 *
 */
@Slf4j
public class DiskUtils extends InitSigar {

    /**
     * <p>
     * 获取磁盘信息
     * </p>
     *
     * @return {@link DiskDomain}
     * @throws SigarException Sigar异常

     */
    public static DiskDomain getDiskInfo() throws SigarException {
        DiskDomain diskDomain = new DiskDomain();
        List<DiskDomain.DiskInfoDomain> diskInfoDomains = Lists.newLinkedList();

        FileSystem[] fileSystemArray = SIGAR.getFileSystemList();
        for (FileSystem fileSystem : fileSystemArray) {
            DiskDomain.DiskInfoDomain diskInfoDomain = new DiskDomain.DiskInfoDomain();

            diskInfoDomain.setDevName(fileSystem.getDevName());
            diskInfoDomain.setDirName(fileSystem.getDirName());
            diskInfoDomain.setTypeName(fileSystem.getTypeName());
            diskInfoDomain.setSysTypeName(fileSystem.getSysTypeName());

            FileSystemUsage fileSystemUsage;
            // 磁盘类型
            int type = fileSystem.getType();
            try {
                fileSystemUsage = SIGAR.getFileSystemUsage(fileSystem.getDirName());
            }
            // 当fileSystem.getType()为5时会出现该异常——此时文件系统类型为光驱
            catch (SigarException e) {
                // 本地硬盘
                if (type == 2) {
                    throw e;
                }
                continue;
            }
            // TYPE_UNKNOWN ：未知
            if (type == 0) {
                log.debug("{}", "TYPE_UNKNOWN！");
                continue;
            }
            // TYPE_NONE
            else if (type == 1) {
                log.debug("{}", "TYPE_NONE！");
                continue;
            }
            // TYPE_LOCAL_DISK : 本地硬盘
            else if (type == 2) {
                log.debug("{}", "TYPE_LOCAL_DISK！");
            }
            // TYPE_NETWORK ：网络
            else if (type == 3) {
                log.debug("{}", "TYPE_NETWORK！");
                continue;
            }
            // TYPE_RAM_DISK ：闪存
            else if (type == 4) {
                log.debug("{}", "TYPE_RAM_DISK！");
                // continue;
            }
            // TYPE_CDROM ：光驱
            else if (type == 5) {
                log.debug("{}", "TYPE_CDROM！");
                continue;
            }
            // TYPE_SWAP ：页面交换
            else if (type == 6) {
                log.debug("{}", "TYPE_SWAP！");
                // continue;
            } else {
                continue;
            }
            diskInfoDomain.setTotal(fileSystemUsage.getTotal() * 1024L);
            diskInfoDomain.setFree(fileSystemUsage.getFree() * 1024L);
            diskInfoDomain.setUsed(fileSystemUsage.getUsed() * 1024L);
            diskInfoDomain.setAvail(fileSystemUsage.getAvail() * 1024L);
            diskInfoDomain.setUsePercent(fileSystemUsage.getUsePercent());
            diskInfoDomains.add(diskInfoDomain);
        }
        diskDomain.setDiskInfoList(diskInfoDomains);
        diskDomain.setDiskNum(diskInfoDomains.size());
        return diskDomain;
    }

}
