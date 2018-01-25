/**
 * 
 */
package com.study.file.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.file.entry.User;
import com.study.file.service.IUserService;

/**
 * @author Administrator
 *
 */
@Controller
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping("/upload")
	public ModelAndView upload(User user, HttpServletRequest request) throws Exception {
		ModelAndView mav=new ModelAndView();
		System.out.println(request.getParameter("name"));
		// 保存数据库的路径
		String sqlPath = null;
		// 定义文件保存的本地路径
		String localPath = "D:\\File\\";
		// 定义文件名
		String filename = null;
		if (!user.getFile().isEmpty()) {
			// 生成uuid作文文件名称
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			// 获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType = user.getFile().getContentType();
			// 获得文件后缀名
			String suffixName = contentType.substring(contentType.indexOf("/") + 1);
			// 得到文件名
			filename = uuid + "." + suffixName;
			System.out.println(filename);
			// 文件保存路径
			user.getFile().transferTo(new File(localPath + filename));
		}
		// 把图片的相对路径保存至数据库
		sqlPath = "/images" + filename;
		System.out.println("sqlPath");
		user.setImage(sqlPath);
		userService.addUser(user);
		mav.setViewName("main");
		mav.addObject("user", user);
		return mav;

	}

}
