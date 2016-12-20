package com.ssm.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.domain.User;
import com.ssm.service.IUserService;

/**
 * HelloWorld
 * 
 * @author lmn
 * @since 2016年12月12日 下午2:03:12
 */
@Controller
@RequestMapping("/test")
public class HelloWorldController {
	
	private static final Log log = LogFactory.getLog(HelloWorldController.class);
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/helloWorld")
	public ModelAndView helloWorld(Model model) {
		ModelAndView mav = new ModelAndView("helloWorld");
		return mav;
	}
	
	@RequestMapping("/queryUsers")
	public String queryUsers(Model model)
	{
		List<User> userList = userService.queryUsers();
		for(User user:userList)
		{
//			System.out.println(user.toString());
			log.info(user.toString());
		}
		model.addAttribute("userList", userList);
//		return "userList";
		return "helloWorld";
	}

	@RequestMapping("/insert")
	public String insert(User user)
	{
		int id = userService.insert(user);
		System.out.println("id="+id);//影响的行数
		System.out.println("插入数据主键："+user.getId());
		return "helloWorld";
	}
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
