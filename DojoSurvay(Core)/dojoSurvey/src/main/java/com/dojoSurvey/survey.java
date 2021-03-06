package com.dojoSurvey;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class survey {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String show(@RequestParam(value = "name") String name, @RequestParam(value = "location") String location,
			@RequestParam(value = "language") String language, @RequestParam(value = "comment") String comment,
			HttpSession session) {
		if (session.getAttribute(name) == null) {
			session.setAttribute("name", name);
			session.setAttribute("location", location);
			session.setAttribute("language", language);
			session.setAttribute("comment", comment);

		}
		return "redirect:/result";
	}

	@RequestMapping("/result")
	public String result() {
		return "result.jsp";
	}

	@RequestMapping("/back")
	public String back(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("/check")
	public String check(HttpSession session) {
		if (session != null)
			return "redirect:/result";
		else
			return "redirect:/";

	}

}
