package cn.lmtoo.ui.web.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * 模块：文件上传<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月31日<br>
 *          Copyright 2014 XXX有限公司.
 */
@Controller
@RequestMapping("upload")
public class FileUploadController {
	@RequestMapping(value = "file", method = RequestMethod.POST)
	public String fileUpload(String name, MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			return "redirect:uploadSuccess";
		}
		return "redirect:uploadFailure";
	}

	/**
	 * 基于Servlet3.0方式的上传
	 * 
	 * @param name
	 * @param part
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "part", method = RequestMethod.POST)
	public String partUpload(String name, Part part) throws IOException {
		InputStream inputStream = part.getInputStream();
		return "redirect:uploadFailure";
	}
}
