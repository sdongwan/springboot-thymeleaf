package com.sdongwan.springbootthymeleaf;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class SpringbootThymeleafApplication{

	@RequestMapping({ "test" })
	public Object test(HttpServletRequest request,Model model) {
		System.out.println("thymeleaf enter");
		model.addAttribute("title","hello world by sdongwan1");
		model.addAttribute("number",1);
		model.addAttribute("html","<span style='color:red'>测试文本转义</span>");
		return "thymeleafPage";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleafApplication.class, args);
	}

}
