package com.sdongwan.springbootthymeleaf;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class SpringbootThymeleafApplication{

	@RequestMapping({ "test" })
	public Object test(HttpServletRequest request,Model model) {
		System.out.println("thymeleaf enter");
		model.addAttribute("title","hello world by sdongwan1");
		model.addAttribute("number",1);
		model.addAttribute("html","<span style='color:red'>测试文本转义</span>");
		User user = new User("sdongwan","boy");
		model.addAttribute(user);

		List<User> userList = new ArrayList<User>();
		for (int i=0;i<5;i++) {
			User user1 = new User("name"+i,"boy");
			userList.add(user1);
		}

		for(User user2 : userList) {

        }





		model.addAttribute(userList);
		return "thymeleafPage";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleafApplication.class, args);
	}

}
