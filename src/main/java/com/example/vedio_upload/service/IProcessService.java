package com.example.vedio_upload.service;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;

/**
 * @author zsp
 * @version v 0.1 2022/7/13 1:00
 */

/** 处理传入视频业务层接口*/
public interface IProcessService {
    /** 转换算法*/
    String  ProcessAlgorithm(String originUrl, String fileName, HttpServletRequest req);
}
