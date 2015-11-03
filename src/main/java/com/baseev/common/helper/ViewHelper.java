package com.baseev.common.helper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

public class ViewHelper
{
    private String status;
    private Object data;

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public ModelAndView getView() {
        ModelAndView model = new ModelAndView();
        model.addAllObjects(getViewData());
        return model;
    }
    
    private Map<String, Object> getViewData() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", status);
        map.put("data", data);
        return map;
    }
}
