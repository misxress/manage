package com.chuangxin.manage.util;

import com.chuangxin.manage.model.ExceptionBean;
import com.chuangxin.manage.model.ExceptionBeanType;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

@Data
@ConfigurationProperties(prefix = "generator")
@Component
public class Generator {

    private int WIDTH;
    private int HEIGHT;
    private String FORMAT;
    private String CHARTSET;

    public BitMatrix createQRcode() throws ExceptionBean {
        try {
            HashMap<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, CHARTSET);
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            hints.put(EncodeHintType.MARGIN, 2);
            return new MultiFormatWriter().encode(createUUID(), BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
        } catch (WriterException e) {
            throw new ExceptionBean(ExceptionBeanType.SYSTEM_ERROR, "生成二维码失败");
        }
    }

    public String createUUID() {
        return UUID.randomUUID().toString();
    }
}
