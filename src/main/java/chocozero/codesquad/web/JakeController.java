package chocozero.codesquad.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JakeController {
	@GetMapping("/jake")
	public String jake() {
		return "jake dadadada";
	}
}
