package com.ptit.qlns.controller.admin;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ptit.qlns.dao.PositionDAOImpl;
import com.ptit.qlns.model.Position;


@Controller
@RequestMapping(value = "/position")
public class PositionController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("position/index");
		PositionDAOImpl dao = new PositionDAOImpl();
		try {
			mv.addObject("positions", dao.getAll());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView("position/create","position", new Position());
		return mv;
	}
	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public ModelAndView addPosition(@Valid @ModelAttribute("position")Position position, BindingResult result) {
		if(result.hasErrors()) {
			ModelAndView mv = new ModelAndView("position/create");
//			mv.addObject("errors", result.hasErrors());
			return mv ;
        }
		Position pos = new Position();
   		pos.setName(position.getName());
   		pos.setDescription(position.getDescription());
   		PositionDAOImpl dao = new PositionDAOImpl();
   		try {
			dao.addPosition(pos);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
   		
   		return new ModelAndView("redirect:/position/index");
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") int id, Model model) {
		ModelAndView mv = new ModelAndView("position/edit","position", new Position());
		Position pos = new Position();
		PositionDAOImpl dao = new PositionDAOImpl();
		try {
			pos = dao.getPositionById(id);
			mv.addObject("position", pos);
			return mv;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable("id") int id,@ModelAttribute("position")Position position, ModelMap model) {
		PositionDAOImpl dao = new PositionDAOImpl();
		Position pos = new Position();
		pos.setId(id);
		pos.setName(position.getName());
		pos.setDescription(position.getDescription());
		try {
			dao.updatePosition(pos);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/position/index");
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		PositionDAOImpl dao = new PositionDAOImpl();
		try {
			dao.deletePosition(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/position/index");
	}
}
