package com.moa.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/default/")
public class DefaultController {

	@GetMapping("list")
	public String list() {

		return "contents/board/default/list";
	}

}
