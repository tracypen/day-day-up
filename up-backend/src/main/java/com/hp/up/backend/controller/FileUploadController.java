package com.hp.up.backend.controller;

//import com.sun.deploy.net.URLEncoder;

import com.hp.up.core.Entity.User;
import com.hp.up.core.utils.file.CompressTools;
import com.hp.up.core.utils.file.FileTools;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.UUID;

/**
 * springMvc file upload And download
 * com.hp.up.backend.controller
 * Created by haopeng on 2017/9/29  22:01.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController extends BaseController {

    /**
     * user headImage upload
     */
    @RequestMapping(value = "/image", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity singleFile(HttpServletRequest request) throws Exception {

        /*Integer x = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("x"), "图片截取异常:X！"));
        Integer y = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("y"), "图片截取异常:Y！"));
        Integer w = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("w"), "图片截取异常:W！"));
        Integer h = Integer.parseInt(MyStringTools.checkParameter(request.getParameter("h"), "图片截取异常:H！"));
        String scaleWidthString = MyStringTools.checkParameter(request.getParameter("sw"), "图片截取异常：SW！");
        */
        Integer x = Integer.parseInt(request.getParameter("x"));
        Integer y = Integer.parseInt(request.getParameter("y"));
        Integer w = Integer.parseInt(request.getParameter("w"));
        Integer h = Integer.parseInt(request.getParameter("h"));
        String scaleWidthString = request.getParameter("sw");
        int swIndex = scaleWidthString.indexOf("px");
        Integer sw = Integer.parseInt(scaleWidthString.substring(0, swIndex));
        //String scaleHeightString = MyStringTools.checkParameter(request.getParameter("sh"), "图片截取异常：SH！");
        String scaleHeightString = request.getParameter("sh");
        int shIndex = scaleHeightString.indexOf("px");
        Integer sh = Integer.parseInt(scaleHeightString.substring(0, shIndex));

        //获取用户ID用于指向对应文件夹
        long userID = super.getCurrentUser().getId();
        //获取文件路径
        //String filePath = FileTools.getPortraitPath(userID);
        String filePath = request.getSession().getServletContext().getRealPath("upload");

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        String path;
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iterator = multiRequest.getFileNames();
            while (iterator.hasNext()) {
                //一次遍历所有文件
                MultipartFile multipartFile = multiRequest.getFile(iterator.next().toString());
                if (multipartFile != null) {
                    String[] allowSuffix = {".jpg",".JPG"};
                    if (!FileTools.checkSuffix(multipartFile.getOriginalFilename(), allowSuffix)) {
                        logger.error("文件后缀名不符合要求！");
                       // throw new BusinessException("文件后缀名不符合要求！");
                    }
                   String uuidFileName = getFileName() + "_" + multipartFile.getOriginalFilename();
                   // path = filePath + FileTools.getPortraitFileName(uuidFileName);
                    path = filePath +"\\"+ uuidFileName;
                     //path = request.getSession().getServletContext().getRealPath("upload");
                    //存入硬盘
                   // MultipartFile file =  multiRequest.getFile(iterator.next().toString());
                   //String  fileName = getFileName() + "_" + file.getOriginalFilename();
                    saveUserImageInfo(uuidFileName);
                    multipartFile.transferTo(new File(path));
                    //图片截取
                    if (FileTools.imgCut(path, x, y, w, h, sw, sh)) {
                        CompressTools compressTools = new CompressTools();
                        if (compressTools.simpleCompress(new File(path))) {
                           // return JsonResult.success(FileTools.filePathToSRC(path, FileTools.IMG));
                            return  super.getJsonResponseEntity(Boolean.TRUE);
                        } else {
                           // return JsonResult.error("图片压缩失败！请重新上传！");
                            return  super.getJsonResponseEntity(Boolean.TRUE);
                        }
                    } else {
                      //  return JsonResult.error("图片截取失败！请重新上传！");
                        return  super.getJsonResponseEntity(Boolean.TRUE);
                    }
                }
            }
        }
        return super.getJsonResponseEntity(Boolean.TRUE);






/*
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        MultipartFile file = null;
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iterator = multiRequest.getFileNames();
            while (iterator.hasNext()) {
                //一次遍历所有文件
                file = multiRequest.getFile(iterator.next().toString());

            }
        }
        String fileName = "";
        try {
            if (null != file) {
                String path = request.getSession().getServletContext().getRealPath("upload");
                fileName = getFileName() + "_" + file.getOriginalFilename();
                File dir = new File(path, fileName);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                //MultipartFile自带的解析方法
                file.transferTo(dir);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return super.getJsonResponseEntity(Boolean.FALSE);
        }
        //保存用户头像信息
        saveUserImageInfo(fileName);
        return super.getJsonResponseEntity(Boolean.TRUE);*/
    }


    /**
     * single file upload
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity singleFile(@RequestParam MultipartFile file, HttpServletRequest request) {
        try {
            String path = request.getSession().getServletContext().getRealPath("upload");
            String fileName = file.getOriginalFilename();
            File dir = new File(path, fileName);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //MultipartFile自带的解析方法
            file.transferTo(dir);

        } catch (Exception e) {
            e.printStackTrace();
            return super.getJsonResponseEntity(Boolean.FALSE);
        }
        return super.getJsonResponseEntity(Boolean.TRUE);
    }


    /**
     * multi-file upload
     */
    @RequestMapping(value = "/multi_upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity multiFile(@RequestParam MultipartFile[] files, HttpServletRequest request) {
        try {
            if (files != null && files.length > 0) {
                //循环获取file数组中得文件
                for (MultipartFile file : files) {
                    if (file.getSize() == 0) {
                        continue;
                    }
                    //保存文件
                    String filename = file.getOriginalFilename();
                    String targetDir = request.getSession().getServletContext().getRealPath("upload");
                    File targetFile = new File(targetDir, filename);
                    file.transferTo(targetFile);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return super.getJsonResponseEntity(Boolean.FALSE);
        }
        return super.getJsonResponseEntity(Boolean.TRUE);
    }


    /**
     * file download
     */
    @RequestMapping("/download")
    public void down(HttpServletRequest request, HttpServletResponse response, String fileName,String action) throws Exception {
        if(null == fileName && null != action){
            //获取用户头像路径
            fileName = super.getCurrentUser().getAvatar();
        }
        //模拟文件，myfile.txt为需要下载的文件
        String fileFullName = request.getSession().getServletContext().getRealPath("upload") + "/" + fileName;
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileFullName)));
        //假如以中文名下载的话
        String filename = "下载文件.txt";
        //转码，免得文件名中文乱码
        // filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
    }


    public String getFileName() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    void saveUserImageInfo(String fileName) {
        User user = new User();
        user.setId(super.getCurrentUser().getId());
        user.setAvatar(fileName);
        userService.update(user);
    }
}
