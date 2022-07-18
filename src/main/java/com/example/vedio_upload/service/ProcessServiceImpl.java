package com.example.vedio_upload.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zsp
 * @version v 0.1 2022/7/13 1:04
 */

@Service
public class ProcessServiceImpl implements IProcessService {
    @Override
    public String ProcessAlgorithm(String originUrl, String fileName, HttpServletRequest req) {
        /*
        * 处理函数body,将处理后视频文件放于/upload/processed/文件夹下
        * */
        String processedUrl = req.getScheme() + "://" +
                req.getServerName() + ":"
                + req.getServerPort()
                + "/upload" + "/processed/"+ fileName;

        return processedUrl;
    }
}
