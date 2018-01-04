package com.lovewristband.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lovewristband.po.BandInfo;
import com.lovewristband.po.PositionInfo;
import com.lovewristband.po.UserInfo;
import com.lovewristband.po.User_Band;
import com.lovewristband.service.BandService;
import com.lovewristband.service.UserService;
import com.lovewristband.util.Sha1Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/band/")
public class BandController {
	@Resource
	private BandService bandservice;

	@Resource
	private UserService userService;

	@RequestMapping(value = "exist.do")
	@ResponseBody
	public String exist(HttpServletResponse response, HttpServletRequest request, BandInfo bandInfo) {
		bandInfo = bandservice.existBand(bandInfo);
		if (bandInfo != null) {
			return bandInfo.toString();
		} else
			return "no";
	}

	@RequestMapping(value = "setband.do", produces = "html/text;charset=UTF-8")
	@ResponseBody
	public String setband(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			BandInfo bandInfo) {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("before  " + bandInfo);
		BandInfo bandInfo1;
		if (session.getAttribute("band") != null) {
			bandInfo1 = (BandInfo) session.getAttribute("band");
			bandInfo.setBandID(bandInfo1.getBandID());
			System.out.println("after  " + bandInfo);
			bandservice.setBand(bandInfo);
			return "ok";
		}
		return "no";
	}

	@RequestMapping(value = "setuser_band.do", produces = "html/text;charset=UTF-8")
	@ResponseBody
	public String setuser_band(HttpServletResponse response, User_Band user_band, HttpServletRequest request,
			HttpSession session, BandInfo bandInfo) {
		if (bandservice.loginBand(bandInfo) == null)
			return "no";
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		System.out.println(userInfo);
		user_band.setBandID(bandInfo.getBandID());
		user_band.setUserID(userInfo.getUserID());
		if (bandservice.duplicateBand(user_band) != null)
			return "duplicate";
		bandservice.setuser_band(user_band);
		return "yes";
	}

	@RequestMapping(value = "savebandsession.do", produces = "html/text;charset=UTF-8")
	@ResponseBody
	public String savebandsession(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			BandInfo bandInfo) {
		if (session.getAttribute("band") != null)
			session.removeAttribute("band");
		session.setAttribute("band", bandInfo);
		return "yes";
	}

	@RequestMapping(value = "disuser_band.do", produces = "html/text;charset=UTF-8")
	@ResponseBody
	public String disuser_band(HttpServletResponse response, HttpServletRequest request, HttpSession session,
			User_Band user_Band, BandInfo bandInfo) {
		if (bandservice.loginBand(bandInfo) == null)
			return "no";
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		System.out.println(user_Band);
		user_Band.setUserID(userInfo.getUserID());
		if (bandservice.duplicateBand(user_Band) == null)
			return "haveno";
		bandservice.disuser_band(user_Band);
		return "yes";

	}

	@RequestMapping(value = "create.do", produces = "html/text;charset=UTF-8")
	@ResponseBody
	public String create(HttpServletResponse response, HttpServletRequest request) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = dateFormat.format(date);
		String uuid = UUID.randomUUID().toString().substring(0, 4);
		String bandID = time + uuid;
		String sha = Sha1Util.getSha1("000000");
		BandInfo bandInfo = new BandInfo();
		bandInfo.setBandID(bandID);
		bandInfo.setPwd(sha);
		System.out.println(sha);
		System.out.println(bandID);
		bandservice.create(bandInfo);
		return "yes";
	}

	@RequestMapping("savePoint.do")
	@ResponseBody
	public String savePoint(HttpServletResponse response, HttpServletRequest request, HttpSession session,PositionInfo positionInfo) {
		response.setContentType("text/html;charset=utf-8");
		Timestamp d = new Timestamp(System.currentTimeMillis());
		positionInfo.setPtime(d.toString());
		System.out.println(positionInfo);
		bandservice.savePoint(positionInfo);
		return "yes";
	}
	
	@RequestMapping("getBandOneDayPosition.do")
	@ResponseBody
	public String getBandOneDayPosition(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html;charset=utf-8");
		String YYYY = (String)request.getParameter("YYYY");
		String MM = (String)request.getParameter("MM");
		String DD = (String)request.getParameter("DD");
		String ptime = YYYY + "-" + MM + "-" + DD; 
		System.out.println(ptime);
		HttpSession session = request.getSession();
		BandInfo bandInfo = (BandInfo)session.getAttribute("band");
		PositionInfo positionInfo =new PositionInfo();
		positionInfo.setBandID(bandInfo.getBandID());
		positionInfo.setPtime(ptime);
		List<PositionInfo> list = bandservice.getBandOneDayPosition(positionInfo);
		System.out.println(bandInfo.getBandID()+"号手环，同一天位置信息"+list);
		JSONArray jsonlist = JSONArray.fromObject(list);
		return jsonlist.toString();
	}
	

}
