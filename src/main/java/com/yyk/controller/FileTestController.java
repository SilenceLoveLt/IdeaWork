package com.yyk.controller;


import com.yyk.util.Url;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(Url.FILE_MANAGE)
public class FileTestController {




    @RequestMapping(Url.SHOW)
    public ModelAndView show(){
        return new ModelAndView("fileTest");
    }


    @RequestMapping(Url.FILE_UPLOAD)
    public String fileUpload(@RequestParam(value="file")MultipartFile file, Model model, HttpServletRequest request){
        if(file.isEmpty()){
            return "文件为空";
        }

        String fileName = file.getOriginalFilename();  // 文件名
        //String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "C://temp-rainy//"; // 上传后的路径
       // fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName); //根目录+文件目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs(); //创建根目录
        }
        try {
            file.transferTo(dest); //实现文件上传
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "file:///"+"C:/temp-rainy/" + fileName;
        model.addAttribute("filename", filename);
        return "fileTest";

    }
}
