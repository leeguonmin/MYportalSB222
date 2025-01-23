package himedia.myportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.repositories.vo.GuestbookVo;
import himedia.myportal.services.GuestbookService;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@Autowired
	GuestbookService guestbookServiceImpl;
	
	@GetMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = 
				guestbookServiceImpl.getMessageList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	
	// @ModelAttribute는 폼 데이터를 자동으로 객체에 바인딩해주는 어노테이션
	// : 이 코드에서 @ModelAttribute GuestbookVo vo는 
	// 클라이언트에서 보낸 HTTP 요청의 폼 데이터(예를 들어, 입력한 게시물 제목, 내용 등)를 
	// GuestbookVo 객체에 자동으로 담아주는 역할
	// -> 즉, 폼에서 입력된 데이터를 GuestbookVo 객체의 필드에 자동으로 매핑
	// (예를 들어, GuestbookVo가 name, message, date 필드를 가지고 있다면, 
	// 사용자가 입력한 name, message, date 값이 자동으로 이 객체의 해당 필드에 세팅)
	@PostMapping("/write")
	public String write(@ModelAttribute GuestbookVo vo) {
		boolean success = guestbookServiceImpl.writeMessage(vo);
		return "redirect:/guestbook";
		
		
	}
	
	// @GetMapping("/delete/{no}")와 @PostMapping("/delete")가 
	// 각각 다른 역할을 하기 때문에 두 가지 방식으로 나눠야함!! (아니근데 비밀번호만 입력하게 뜰수도 있자나요 그건 안됩니까?)
	
	// 삭제할 게시물을 보여주는 새 창
	@GetMapping("/delete/{no}")
	public String deleteForm(@PathVariable("no") Integer no, 
							Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	@PostMapping("/delete")
	public String delete(@ModelAttribute GuestbookVo vo) {
		boolean success = guestbookServiceImpl.deleteMessage(vo);
		return "redirect:/guestbook";
	}

	
	/*
	@Autowired
	GuestbookService guestbookServiceImpl;
	
	@GetMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = 
				guestbookServiceImpl.getMessageList();
		model.addAttribute("list", list);
		return "guestbook/list";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute GuestbookVo vo) {
		System.out.println("FORM:" + vo);
		boolean success = guestbookServiceImpl
							.writeMessage(vo);
		System.out.println("Write Result:" + success);
		return "redirect:/guestbook";
	}
	
	@RequestMapping(value="/delete/{no}",
			method=RequestMethod.GET)
	public String deleteForm(@PathVariable("no") Integer no, 
							Model model) {
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	@RequestMapping(value="/delete",
			method=RequestMethod.POST)
	public String deleteAction(@ModelAttribute GuestbookVo vo) {
		boolean success = guestbookServiceImpl.deleteMessage(vo);
		System.out.println("Delete Result:" + success);
		return "redirect:/guestbook";
	}
	*/
}