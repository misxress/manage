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
import java.util.HashSet;
import java.util.Queue;
import java.util.UUID;

@Data
@ConfigurationProperties(prefix = "generator")
@Component
public class Generator {

    private int WIDTH;
    private int HEIGHT;
    private String FORMAT;
    private String CHARTSET;


    private Queue<String> pool;

    /**
     *
     * @param text
     * @return
     * @throws ExceptionBean
     */
    public String createQRcode(String text) throws ExceptionBean {
        try {
            HashMap<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, CHARTSET);
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
            hints.put(EncodeHintType.MARGIN, 2);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    str.append(bitMatrix.get(i, j) ? "1" : "0");
                }
            }
            return str.toString();
        } catch (WriterException e) {
            throw new ExceptionBean(ExceptionBeanType.SYSTEM_ERROR, "生成二维码失败");
        }
    }

    /**
     *
     * @return
     */
    public String createUUID() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        pool.add(uuid);
        return uuid;
    }

    public String getKey() {
        return pool.poll();
    }
}
