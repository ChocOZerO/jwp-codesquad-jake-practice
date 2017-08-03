package chocozero.codesquad.web;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.User;

@Controller
public class UserController {
	ArrayList<User> users = new ArrayList<>();
	
	@PostMapping("/users")
	public ModelAndView create(User user) {
		users.add(user);
		return new ModelAndView("redirect:/users");
	}
	
	@GetMapping("/users")
	public ModelAndView getUserList() {
		ModelAndView mav = new ModelAndView("user/list");
		mav.addObject("users", users);
		return mav;
	}
	
	@GetMapping("/users/{userId}")
	public ModelAndView getUserProfile(@PathVariable String userId) {
		ModelAndView mav = new ModelAndView("user/profile");
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserId().equals(userId)) {
				mav.addObject("user", users.get(i));
			}
		}
		return mav;
	}
	
	@GetMapping("/users/{userId}/form")
	public ModelAndView updateForm(@PathVariable String userId) {
		ModelAndView mav = new ModelAndView("user/updateForm");
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserId().equals(userId)) {
				mav.addObject("user", users.get(i));
			}
		}
		return mav;
	}
	
	@PostMapping("/users/{userId}/update")
	public ModelAndView updateUser(@PathVariable String userId, User user) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserId().equals(userId)) {
				users.get(i).setUserId(user.getUserId());
				users.get(i).setPassword(user.getPassword());
				users.get(i).setName(user.getName());
				users.get(i).setEmail(user.getEmail());
			}
		}
		return new ModelAndView("redirect:/users");
	}
}
