package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.business.ProductService;
import com.example.demo.model.Alien;

//Angel Comment

//jc kjgsdgkfgkjjk
main
//shetty comment
//@Controller praveen
@Controller
public class AppController {

	@Autowired
	private ProductService service;

	@GetMapping("/")
	public String viewItem(Model model) {
		Object listProducts = service.listAll();
		model.addAttribute("listItems", listProducts);
		return "index";
	}
	//This Is Angel Singh
//comment line
	@GetMapping("/new")
	public String showItem(Model model) {
		Alien alien = new Alien();
		model.addAttribute("alien", alien);
		return "new_product";
	}

	@PostMapping("/save")
	public String saveItem(@ModelAttribute("alien") Alien alien) {
		service.save(alien);

		return "redirect:/";
	}
	@GetMapping("/edit/{aid}")
	public ModelAndView editItem(@PathVariable(name="aid") int aid) {
		ModelAndView mv = new ModelAndView("edit_product");
		Alien alien = service.get(aid);
		mv.addObject("alien", alien);
		return mv;
	}

	@GetMapping("/delete/{aid}")
	public String deleteItem(@PathVariable(name ="aid") int aid) {
		service.delete(aid);
		return "redirect:/";       
	}
}
