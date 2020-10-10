package com.chuangxin.manage.service;

import com.chuangxin.manage.dao.PhotoDao;
import com.chuangxin.manage.model.ExceptionBean;
import com.chuangxin.manage.model.Photo;
import com.chuangxin.manage.model.ResponseBean;
import com.chuangxin.manage.util.Generator;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    @Autowired
    private Generator generator;

    @Autowired
    private PhotoDao photoDao;

    public String createQRcode() throws ExceptionBean{
        String uuid = generator.createUUID();

        String text = "chuangxin#" + uuid;
        return generator.createQRcode(text);
    }

    public Boolean stagePhoto(String uuid, String base64) {
        Integer value = (Integer) generator.getValue(uuid);
        if(value == 1) {
            return true;
        }
        return false;
    }
}





