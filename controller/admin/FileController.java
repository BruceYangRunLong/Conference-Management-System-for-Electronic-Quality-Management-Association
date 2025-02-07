package com.lemon.meet.controller.admin;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.lemon.web.annotation.ResponseResult;
import org.springframework.core.env.Environment;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author
 * @version 1.0.0
 * @describe
 * @company lemon
 * @address
 * @updateTime 2024-06-29 19:25
 * @since 2024-06-29 19:25
 */

@ResponseResult
@RequestMapping("/file")
@RestController
public class FileController {

  @Resource
  private Environment environment;

    @RequestMapping("/upload")
    public String upload(MultipartFile file,HttpServletRequest request) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        //获取地址
        String hostAddress = localHost.getHostAddress();
        //获取端口
        String port = environment.getProperty("server.port");
        String path = URLDecoder.decode(ResourceUtils.getURL("classpath:").getPath(), "utf-8");
        //获取文件后缀名
        String extName = FileUtil.extName(file.getOriginalFilename());
        //新的文件名
        String newFileName = UUID.randomUUID().toString() + "." + extName;
        file.transferTo(new File(path, "static/" + newFileName));
        return "http://" + hostAddress + ":" + port  + "/static/" + newFileName;
    }


    @RequestMapping("/download")
    public void download(@RequestParam(name = "path") String path, HttpServletResponse response) throws IOException {
        //获取文件名
        List<String> split = StrUtil.split(path, "/");
        String fileName = CollUtil.getLast(split);
        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        File file = new File(path);
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(IoUtil.readBytes(FileUtil.getInputStream(file)));
        outputStream.close();
        outputStream.flush();
    }

}
