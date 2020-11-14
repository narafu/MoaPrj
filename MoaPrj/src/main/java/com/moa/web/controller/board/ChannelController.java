package com.moa.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/channel/")
public class ChannelController {

	@GetMapping("list")
	public String list() {

		return "contents/board/channel/list";
	}
	
	@GetMapping("reg")
	public String reg() {
		
		return "contents/board/channel/reg";
	}

}
