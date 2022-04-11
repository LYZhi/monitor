package com.lyzhi.monitor.common.dto;


import com.lyzhi.monitor.common.abs.AbstractSuperBean;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 密文数据包
 * </p>
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class CiphertextPackage extends AbstractSuperBean {

    /**
     * 加密后的数据
     */
    private String ciphertext;

    /**
     * 是否需要进行UnGzip（先压缩再加密，先解密再解压）
     */
    private boolean isUnGzipEnabled;

}
