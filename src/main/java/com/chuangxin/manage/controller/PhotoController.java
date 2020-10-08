package com.chuangxin.manage.controller;

import com.chuangxin.manage.model.ExceptionBean;
import com.chuangxin.manage.model.ResponseBean;
import com.chuangxin.manage.service.PhotoService;
import com.chuangxin.manage.util.Generator;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping(value = "/QRcode/photo_id", method = RequestMethod.GET)
    public ResponseBean getQRcodeOfPhoto() {
        try {
            return ResponseBean.ok("返回二维码成功", photoService.createQRcode());
        }catch (ExceptionBean e) {
            return ResponseBean.error(e);
        }
    }


}
