package cn.lmtoo.ui.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.lmtoo.core.security.domain.UserAccount;

/**
 * 
 * 模块：<br>
 * 描述：
 * 
 * @author 李乐 601235723@qq.com
 * @version 1.0 2014年5月22日<br>
 *          Copyright 2014 XXX有限公司.
 */
@Controller
@RequestMapping("controller")
public class TestController {
	@RequestMapping("/owners/{ownerId}/pets/{petId}/{buyDate}")
	public void testURITempldate(@PathVariable String ownerId, @PathVariable String petId, @PathVariable Date date) {
		System.out.println("ownerId=" + ownerId);
		System.out.println("petId=" + petId);
		System.out.println("buyDate=" + date);
	}

	@RequestMapping(value = "/owners/{ownerId}", consumes = "application/json")
	public void testConsumer(@PathVariable String ownerId) {
		System.out.println("ownerId=" + ownerId);
		System.out.println("consumers=" + "application / json");
	}

	@RequestMapping(value = "/request")
	public void test(@RequestBody String request, Map model) {
		System.out.println(request);
	}

	@ModelAttribute
	public UserAccount beforeMethod() {
		return new UserAccount();
	}

	@ResponseBody
	@RequestMapping("body")
	public Object restResponseBody(Map<String, Object> model) {
		return model;
	}

	@RequestMapping("header")
	public void testHeader(@RequestHeader String header) {
		System.out.println(header);
	}

	@RequestMapping("entity")
	public void testEntity(HttpEntity<String> request, Map<String, Object> modole) {
		Set<Entry<String, List<String>>> entrySet = request.getHeaders().entrySet();
		for (Entry<String, List<String>> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println(request.getBody());
	}

	@RequestMapping("redirect")
	public String testRedirectAttr(RedirectAttributes attrs) {
		attrs.addFlashAttribute("userName", "ddd");
		return "redirect:/controller/moduleAttr";
	}

	@RequestMapping("moduleAttr")
	public void testModuleAttr(Map<String, Object> model) {
		System.out.println(model);
	}

}
