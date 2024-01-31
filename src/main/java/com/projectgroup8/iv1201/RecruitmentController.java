package com.projectgroup8.iv1201;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RecruitmentController {
//example code.
@GetMapping("/")
	public String hello() {
		return "hello";
	}


}
