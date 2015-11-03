package com.baseev.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baseev.common.helper.ViewHelper;
import com.baseev.stack.StackFactory;


@Controller
@RequestMapping("/stack")
public class StackController {

    private static final Log LOG = LogFactory.getLog(StackController.class);
    
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/setSize", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView setSize(@RequestBody Integer data, ModelMap model) {
	    createArrayStack(data);
	    ViewHelper view = new ViewHelper();
	    view.setStatus("success");
	    view.setData("Created a stack with size "+data);
	    return view.getView();
	}	
	
    
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/push", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView push(@RequestBody Integer data, ModelMap model) {
	    StackFactory.push(data);
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        view.setData("Successfully pushed data : "+data+" to stack");
        return view.getView();
    }
   
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/pop", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView pop(ModelMap model) {
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        view.setData(StackFactory.pop());
        return view.getView(); 
	}
   
   
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/list", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView list(ModelMap model) {
        ViewHelper view = new ViewHelper();
        view.setStatus("success");
        view.setData(StackFactory.list());
        return view.getView(); 
    }
   
    
   private void createArrayStack(int size) {
       StackFactory.createInstance(size);
   }
   
}