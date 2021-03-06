package top.wangruns.trackstacking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import top.wangruns.trackstacking.model.TrendingSong;
import top.wangruns.trackstacking.service.MyMusicService;

@Controller
public class MyMusicPageController {
	@Autowired
	private MyMusicService myMusicService;
	
	@GetMapping(value = "myMusicPage.do")
	public ModelAndView myMusicPage(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("myMusicPage");
		List<TrendingSong> myCollectionList=myMusicService.getMyCollectionWithCollectionFlag(request);
		List<TrendingSong> myRecentPlayList=myMusicService.getMyRecentPlayListWithCollectionFlag(request);
		
		modelAndView.addObject("myCollectionList",myCollectionList);
		modelAndView.addObject("myRecentPlayList",myRecentPlayList);
		modelAndView.addObject("test","Name");
		
		return modelAndView;
		
	}
	
	@GetMapping(value = "myRecentLoad.do")
	public ModelAndView myRecentLoad(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("myMusicPage");
		List<TrendingSong> myCollectionList=myMusicService.getMyCollectionWithCollectionFlag(request);
		List<TrendingSong> myRecentPlayList=myMusicService.getMyRecentPlayListWithCollectionFlag(request);
		
		modelAndView.addObject("myCollectionList",myCollectionList);
		modelAndView.addObject("myRecentPlayList",myRecentPlayList);
		modelAndView.addObject("test","Name");
		
		return modelAndView;
		
	}
	
	@GetMapping(value = "recentFrameLoad.do")
	public ModelAndView recentFrameLoad(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("recentFrame");
		List<TrendingSong> myRecentPlayList=myMusicService.getMyRecentPlayListWithCollectionFlag(request);
		
		modelAndView.addObject("myRecentPlayList",myRecentPlayList);
		
		return modelAndView;
		
	}
	
	@GetMapping(value = "collectedFrameLoad.do")
	public ModelAndView collectedFrameLoad(HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("collectedFrame");
		List<TrendingSong> myCollectionList=myMusicService.getMyCollectionWithCollectionFlag(request);
		
		modelAndView.addObject("myCollectionList",myCollectionList);
		
		return modelAndView;
		
	}
	


}
