package com.nnb.DSGAgent.info.Controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nnb.DSGAgent.info.Service.InfoService;

@RestController
public class InfoController {
	private final String LINUX_BASE_DIR = "/home/steam/steamapps/DST";
	private final String LINUX_CLUSTER_DIR = "DoNotStarveTogether/Cluster_1";
	private final String WINDOWS_BASE_DIR = "C:\\eGovFrameDev-4.1.0-Win-64bit\\workspace\\data\\persistence_storage";
	private final String WINDOWS_CLUSTER_DIR = "DoNotStarveTogether\\Cluster_1";
	private final String WINDOWS_CLUSTER_FILENAME = "cluster.ini";
	
	private final Logger logger = LogManager.getLogger(InfoController.class);
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping("/info/{gmname}/{id}")
	@ResponseBody
	public Map<String, String> getServerInfo(@PathVariable("gmname") String gmname, @PathVariable("id") String id) {
		logger.info("[game name : " + gmname + "]" + " [id : " + id + "]");
		String cluster_name = "";
		Map<String, String> networkSection = new HashMap<>();
		try {
			String clusterPath = WINDOWS_BASE_DIR + "\\" + id + "\\" + WINDOWS_CLUSTER_DIR + "\\" + WINDOWS_CLUSTER_FILENAME;
			
			networkSection = infoService.getServiceInfo(clusterPath);
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return networkSection; 
	}
}
