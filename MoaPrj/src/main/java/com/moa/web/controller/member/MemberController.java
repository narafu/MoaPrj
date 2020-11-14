package com.moa.web.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.moa.web.service.KakaoLoginService;
import com.moa.web.service.NaverLoginService;

@Controller("memberController")
@RequestMapping("")
public class MemberController {

	private NaverLoginService naverLoginService;

	@Autowired
	private void setNaverLoginBO(NaverLoginService naverLoginBO) {
		this.naverLoginService = naverLoginBO;
	}

	@Autowired
	private KakaoLoginService kakaoLoginService;

	@RequestMapping("/member/login/kakao")
	public String loginKakao(@RequestParam("code") String code, HttpSession session) {

		String access_Token = kakaoLoginService.getAccessToken(code);
		HashMap<String, Object> userInfo = kakaoLoginService.getUserInfo(access_Token);
		System.out.println("kakao login Controller : " + userInfo);

		// 클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
		if (userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("email"));
			session.setAttribute("nickname", userInfo.get("nickname"));
			session.setAttribute("access_Token", access_Token);
		}

		return "redirect:/home";
	}

	@ResponseBody
	@GetMapping("/member/login/naver")
	public String loginNaver(Model model, HttpSession session) {

		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginService.getAuthorizationUrl(session);
		model.addAttribute("naverAuthUrl", naverAuthUrl);

		/* 생성한 인증 URL을 View로 전달 */
		return naverAuthUrl;
	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping("/callback")
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginService.getAccessToken(session, code, state);
		// 로그인 사용자 정보를 읽어온다.
		HashMap<String, Object> userInfo = naverLoginService.getUserProfile(oauthToken);
		System.out.println("naver login Controller : " + userInfo);

		if (userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("email"));
			session.setAttribute("nickname", userInfo.get("nickname"));
			session.setAttribute("oauthToken", oauthToken);
		}

		return "redirect:/home";
	}

	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {

		if (session.getAttribute("access_Token") == null) {
			session.removeAttribute("oauthToken");
		} else {
			kakaoLoginService.kakaoLogout((String) session.getAttribute("access_Token"));
			session.removeAttribute("access_Token");
		}

		session.removeAttribute("userId");
		session.removeAttribute("nickname");
		session.invalidate();

		return "redirect:/home";
	}

}
