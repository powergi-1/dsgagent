package com.nnb.DSGAgent.info.Service;

import java.util.Map;

public interface InfoService {

	public Map<String, String> getServiceInfo(String clusterPath) throws Exception;
}
