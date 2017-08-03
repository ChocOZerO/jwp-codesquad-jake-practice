package chocozero.codesquad.web;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import chocozero.codesquad.domain.Question;

@Controller
public class QuestionController {
	ArrayList<Question> questions = new ArrayList<>();
	
	@PostMapping("/questions")
	public ModelAndView ask(Question question) {
		Date date = new Date();
		question.setDate(date);
		questions.add(question);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/")
	public ModelAndView getQeustions() {
		ModelAndView mav = new ModelAndView("qna/list");
		mav.addObject("questions", questions);
		return mav;
	}
	
	@GetMapping("/questions/{index}")
	public ModelAndView showQuestion(@PathVariable int index) {
		ModelAndView mav = new ModelAndView("qna/show");
		mav.addObject("question", questions.get(index));
		return mav;
	}
	
}
