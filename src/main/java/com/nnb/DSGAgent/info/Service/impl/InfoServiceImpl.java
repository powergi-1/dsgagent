package com.nnb.DSGAgent.info.Service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.ini4j.Ini;
import org.springframework.stereotype.Service;

import com.nnb.DSGAgent.info.Service.InfoService;

@Service("infoService")
public class InfoServiceImpl implements InfoService {

	public Map<String, String> getServiceInfo(String clusterPath) throws Exception {
		Map<String, String> networkSection = new HashMap<>();
		try {
			File fileToParse = new File(clusterPath);
			
			Ini ini = new Ini(fileToParse);
			networkSection = ini.get("NETWORK");
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		return networkSection;
	}

}
