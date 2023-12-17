package com.nnb.DSGAgent.ctrl.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nnb.DSGAgent.ctrl.Service.CtrlService;
import com.nnb.DSGAgent.ctrl.Service.CtrlVO;

@RestController
public class CtrlController {
	
	@Autowired
	private CtrlService ctrlService;

	@GetMapping("/ctrl/{gmname}/{userid}/start")
	@ResponseBody
	public Map<String, String> startServer(@PathVariable("gmname") String gmname, @PathVariable("userid") String userid) {
		Map<String, String> retMap = new HashMap<>();
		CtrlVO paramVo = new CtrlVO();
		paramVo.setGameName(gmname);
		paramVo.setUserId(userid);
		paramVo.setPort("12313");
		
		try {
			ctrlService.startServer(paramVo);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return retMap;
	}

	@GetMapping("/ctrl/{gmname}/{userid}/stop")
	@ResponseBody
	public Map<String, String> stopServer(@PathVariable("gmname") String gmname, @PathVariable("userid") String userid) {
		Map<String, String> retMap = new HashMap<>();
		CtrlVO paramVo = new CtrlVO();
		paramVo.setGameName(gmname);
		paramVo.setUserId(userid);
		paramVo.setPort("12313");
		
		try {
			ctrlService.stopServer(paramVo);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return retMap;
	}

	@GetMapping("/ctrl/{gmname}/{userid}/restart")
	@ResponseBody
	public Map<String, String> restartServer(@PathVariable("gmname") String gmname, @PathVariable("userid") String userid) {
		Map<String, String> retMap = new HashMap<>();
		CtrlVO paramVo = new CtrlVO();
		paramVo.setGameName(gmname);
		paramVo.setUserId(userid);
		paramVo.setPort("12314");
		
		try {
			ctrlService.restartServer(paramVo);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return retMap;
	}
}
