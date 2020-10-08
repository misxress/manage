package com.chuangxin.manage.service;

import com.chuangxin.manage.model.ExceptionBean;
import com.chuangxin.manage.model.ResponseBean;
import com.chuangxin.manage.util.Generator;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Autowired
    private Generator generator;

    public String createQRcode() throws ExceptionBean{
        String uuid = generator.createUUID();

        String text = "chuangxin#" + uuid;
        return generator.createQRcode(text);
    }
}
