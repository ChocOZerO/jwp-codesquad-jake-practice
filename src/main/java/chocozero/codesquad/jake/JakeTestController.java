package chocozero.codesquad.jake;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JakeTestController {
	@GetMapping("jaketest")
	public String getJakeTest() {
		return "get jake test";
	}
}
