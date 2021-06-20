package com.ninjagoldgame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonFormat;

@Controller
public class theninja {
	ArrayList<String> activites = new ArrayList<>();

	@RequestMapping("/gold")
	public String showPage(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		if (session.getAttribute("activity") == null) {
			session.setAttribute("activity", "");
		}
		if (session.getAttribute("activity") == null) {
			session.setAttribute("gold", 0);
		}

		return "gold.jsp";
	}

	@RequestMapping(value = "/play", method = RequestMethod.POST)
	public String play(@RequestParam(value = "gold") String add, HttpSession session) {
		Random random = new Random();

		Date activityDate = new Date();
		SimpleDateFormat changeFormat = new SimpleDateFormat("EEEE, MMMM dd YYYY hh:mm:ss a");
		String date = changeFormat.format(activityDate);
		if (add.equals("farm")) {
			int gold;

			gold = random.nextInt(20 - 10) + 10;
			session.setAttribute("count", gold + (int) session.getAttribute("count"));
			String newActivity = "You entere  a farm and earned " + Integer.toString(gold) + " at " + date;
			activites.add(new String(newActivity));
			session.setAttribute("activites", activites);
			session.setAttribute("gold", gold);
		}
		if (add.equals("cave")) {
			int gold;

			gold = random.nextInt(10 - 5) + 5;
			session.setAttribute("count", gold + (int) session.getAttribute("count"));
			String newActivity = "You entere  a cave and earned " + Integer.toString(gold) + " at " + date;
			activites.add(new String(newActivity));
			session.setAttribute("activites", activites);
			session.setAttribute("gold", gold);
		}
		if (add.equals("house")) {
			int gold;

			gold = random.nextInt(5 - 2) + 2;
			session.setAttribute("count", gold + (int) session.getAttribute("count"));
			String newActivity = "You entere  a House and earned " + Integer.toString(gold) + " at " + date;
			activites.add(new String(newActivity));
			session.setAttribute("activites", activites);
			session.setAttribute("gold", gold);
		}
		if (add.equals("casino")) {
			int gold;

			gold = random.nextInt(50 - (-50)) - 50;
			session.setAttribute("count", gold + (int) session.getAttribute("count"));
			String newActivity = "You entere  a Casino and earned " + Integer.toString(gold) + " at " + date;
			activites.add(new String(newActivity));
			session.setAttribute("activites", activites);
			session.setAttribute("gold", gold);
		}

		return "redirect:/gold";

	}
}