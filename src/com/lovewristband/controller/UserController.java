package com.lovewristband.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovewristband.po.BandInfo;
import com.lovewristband.po.UserCount;
import com.lovewristband.po.UserInfo;
import com.lovewristband.po.User_Band;
import com.lovewristband.service.BandService;
import com.lovewristband.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Resource
	private UserService userservice;
	
	@Resource
	private BandService bandservice;

	@RequestMapping("login.do")
	@ResponseBody
	public String login(HttpServletResponse response, HttpServletRequest request, UserInfo userInfo) {
		response.setContentType("text/html;charset=utf-8");
		System.out.println(userInfo.toString());
		userInfo = userservice.submit(userInfo);
		HttpSession session = request.getSession();
		if (userInfo != null) {
			session.setAttribute("user", userInfo);
			return "yes";
		}
		return "no";
	}

	@RequestMapping(value = "reg.do", produces = "html/text;charset=UTF-8")
	@ResponseBody
	public String reg(HttpServletResponse response, HttpServletRequest request, UserInfo userInfo) {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		userservice.reg(userInfo);
		session.setAttribute("user", userInfo);
		return "yes";
	}

	@RequestMapping("duplicate.do")
	@ResponseBody
	public String duplicate(HttpServletResponse response, HttpServletRequest request, UserInfo userInfo) {
		response.setContentType("text/html;charset=utf-8");
		System.out.println(userInfo.toString());
		userInfo = userservice.check(userInfo);
		if (userInfo == null)
			return "ok";
		return "duplicating";
	}

	@RequestMapping(value = "check.do", produces = "html/text;charset=UTF-8")
	@ResponseBody
	public String check(HttpServletResponse response, HttpServletRequest request) {
		System.out.println("ceshi");
		String bandID=request.getParameter("bandID");
		List<UserInfo> li=userservice.getfamily(bandID);
		System.out.println(li);
		JSONArray json = JSONArray.fromObject(li);
		return json.toString();
	}

	@RequestMapping(value = "checkband.do", produces = "html/text;charset=UTF-8")
	@ResponseBody
	public String checkband(HttpServletResponse response, HttpSession session, 
			HttpServletRequest request,BandInfo bandInfo) {
		response.setContentType("text/html;charset=utf-8");
		if (session.getAttribute("band") != null)
			bandInfo = (BandInfo)session.getAttribute("band");
		bandInfo = userservice.checkband(bandInfo);
		System.out.println(bandInfo);
		if (bandInfo != null) {
			JSONObject json = JSONObject.fromObject(bandInfo);
			return json.toString();
		}
		return "no";
	}

	@RequestMapping("set.do")
	@ResponseBody
	public void set(HttpServletResponse response, HttpServletRequest request, UserInfo userInfo) {
		response.setContentType("text/html;charset=utf-8");
		System.out.println(userInfo);
		userservice.setAll(userInfo);
		HttpSession session = request.getSession();
		session.setAttribute("user", userInfo);
	}

	@RequestMapping("session.do")
	@ResponseBody
	public UserInfo getSession(HttpServletResponse response, HttpSession session) {
		if (session.getAttribute("user") != null)
			return (UserInfo)(session.getAttribute("user"));
		return null;
	}

	@RequestMapping("quit.do")
	@ResponseBody
	public String quit(HttpServletResponse response, HttpSession session, HttpServletRequest request)
			throws IOException {
		session.invalidate();
		return "ok";
	}

	@RequestMapping(value = "bandnum.do", produces = "html/text;charset=UTF-8")
	@ResponseBody
	public String bandnum(HttpServletResponse response, User_Band user_band, HttpServletRequest request,
			HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		ArrayList<User_Band> list = userservice.getBandList(userInfo.getUserID());
		ArrayList<BandInfo> bandlist = new ArrayList<BandInfo>();
		while(!list.isEmpty()){
			User_Band user_band1 = list.get(0);
			BandInfo  bandInfo   = new BandInfo();
			bandInfo.setBandID(user_band1.getBandID());
			bandInfo = bandservice.existBand(bandInfo);
			bandlist.add(bandInfo);
			list.remove(0);
		}
		JSONArray jsonlist = JSONArray.fromObject(bandlist);
		return jsonlist.toString();
	}
	
	
		@RequestMapping(value = "getUserNum.do", produces = "html/text;charset=UTF-8")
	@ResponseBody
	public String getUserNum(HttpServletResponse response,HttpServletRequest request) {
		UserCount userCount = userservice.getUserNum();
		JSONObject json = JSONObject.fromObject(userCount);
		return json.toString();
	}

}
