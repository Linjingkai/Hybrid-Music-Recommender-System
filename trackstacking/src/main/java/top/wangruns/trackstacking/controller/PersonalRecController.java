package top.wangruns.trackstacking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import top.wangruns.trackstacking.model.TrendingSong;
import top.wangruns.trackstacking.service.PersonalRecService;
import top.wangruns.trackstacking.service.TrendingRecService;

@Controller
public class PersonalRecController {
	@Autowired
	private PersonalRecService personalRecService;
	
	
	@RequestMapping(value = "personalRecPage.do",method = { RequestMethod.GET })
	public ModelAndView personalRecPage(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("personalRecPage");
		List<TrendingSong> personalRecSongList=personalRecService.getPersonalDailyRecWithCollectionFlag(request);
		
		modelAndView.addObject("personalRecSongList",personalRecSongList);
		modelAndView.addObject("test","Name");
		
		return modelAndView;
		
	}

}
