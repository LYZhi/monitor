package com.lyzhi.monitor.common.domain.server;

import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 磁盘信息
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class DiskDomain extends AbstractSuperBean {

    /**
     * 磁盘数量
     */
    private int diskNum;

    /**
     * 磁盘信息
     */
    private List<DiskInfoDomain> diskInfoList;

    @Data
    @ToString
    @NoArgsConstructor
    @Accessors(chain = true)
    @EqualsAndHashCode(callSuper = true)
    public static class DiskInfoDomain extends AbstractSuperBean {

        /**
         * 分区的盘符名称
         */
        String devName;

        /**
         * 分区的盘符路径
         */
        String dirName;

        /**
         * 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
         */
        String typeName;

        /**
         * 文件系统类型，比如 FAT32、NTFS
         */
        String sysTypeName;

        /**
         * 文件系统总大小（单位：byte）
         */
        long total;

        /**
         * 文件系统剩余大小（单位：byte）
         */
        long free;

        /**
         * 文件系统已使用大小（单位：byte）
         */
        long used;

        /**
         * 文件系统可用大小（单位：byte）
         */
        long avail;

        /**
         * 文件系统资源的利用率
         */
        double usePercent;

    }

}