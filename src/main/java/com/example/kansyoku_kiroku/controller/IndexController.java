package com.example.kansyoku_kiroku.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kansyoku_kiroku.model.domain.Menu;
import com.example.kansyoku_kiroku.model.mapper.MenuMapper;
import com.example.kansyoku_kiroku.model.session.LoginSession;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		if(loginSession.getPassword() != null) {
			Date d = new Date();
			//��ʂɕ\��������t
			//SimpleDateFormat d1 = new SimpleDateFormat("yyyy�NMM��dd��");
			//DB�ŎQ�Ƃ�����t�̃t�H�[�}�b�g
			SimpleDateFormat d2 = new SimpleDateFormat("yyyy-MM-dd");
			//String today = d1.format(d);
			String dbToday = d2.format(d);
			//m.addAttribute("today", today);
			
			SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date dbDate = dbDateFormat.parse(dbToday);
				List<Menu> todayMenus = menuMapper.findTodayMenu(loginSession.getUserId(), dbDate);
				int sumTodayPrice = menuMapper.sumTodayPrice(loginSession.getUserId(), dbDate);
				int sumTodayKcal = menuMapper.sumTodayKcal(loginSession.getUserId(), dbDate);
				m.addAttribute("todayMenus", todayMenus);
				m.addAttribute("sumTodayPrice", sumTodayPrice);
				m.addAttribute("sumTodayKcal", sumTodayKcal);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//���j���[������Model�ɋl�߂�
			List<Menu> menuHistories = menuMapper.findMenuHistory(loginSession.getUserId());
			m.addAttribute("menuHistories", menuHistories);
			m.addAttribute("loginSession", loginSession);
			
			return "index";
		}
		//���O�C�����Ă��Ȃ��ꍇ��introduce�֑J��
		else {
			return "introduce";
		}
	}
	
	@RequestMapping("/introduce")
	public String introduce() {
		return "introduce";
	}

}
