package com.nnb.DSGAgent.setting.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nnb.DSGAgent.setting.Service.SettingService;

@RestController
public class SettingController {
	
	@Autowired
	SettingService settingService;
	
	@GetMapping("/setting/{gmname}/{userid}/setServer")
	@ResponseBody
	public Map<String, String> setServer(@PathVariable("gmname") String gmname, @PathVariable("userid") String userid){
		Map<String, String> retMap = new HashMap<>();
		
		try {
			settingService.setServerInfo();
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		return retMap;
	}
}
