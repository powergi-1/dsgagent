package com.nnb.DSGAgent.ctrl.Service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.nnb.DSGAgent.ctrl.Controller.CtrlController;
import com.nnb.DSGAgent.ctrl.Service.CtrlService;
import com.nnb.DSGAgent.ctrl.Service.CtrlVO;


@Service("ctrlService")
public class CtrlServiceImpl implements CtrlService{
	private final String LINUX_BASE_DIR = "/home/steam/steamapps/DST";
	private final String SERVER_SHELL_NAME = "dst_proc.sh";
	private final String PARAM_PORT = "11112";//"\"11112\"";
	private final String PARAM_MAX_PLAYERS = "18";//"\"18\"";
	private final String PARAM_CLUSTER_NAME = "Let us go ";//"\"Let us go!!\"";
	private final String PARAM_CLUSTER_PASSWORD = "1234";//"\"12345test\"";
	private final String PARAM_GAME_MODE = "endless";//"\"endless\"";
	private final String PARAM_TOKEN = "pds-g^KU_SIyU7nA-^D3/W5C9txL1MkVCESnM63mZW6YH+nMaa46blADEBRCA=";//"\"pds-g^KU_SIyU7nA-^D3/W5C9txL1MkVCESnM63mZW6YH+nMaa46blADEBRCA=\"";
	private final String PARAM_USER = "user009";//"\"user009\"";
	private final String LINUX_CLUSTER_DIR = "DoNotStarveTogether/Cluster_1";
	
	private static final Logger logger = LoggerFactory.getLogger(CtrlServiceImpl.class);
	
	public int startServer(CtrlVO startinfoVo) {
		logger.info("startServer() in");
		String port = "-port";// + PARAM_PORT;
		String max_players = "-max_players";// + PARAM_MAX_PLAYERS;
		String cluster_name = "-cluster_name";// + PARAM_CLUSTER_NAME;
		String cluster_password = "-cluster_password";// + PARAM_CLUSTER_PASSWORD;
		String game_mode = "-game_mode";// + PARAM_GAME_MODE;
		String token = "-token";// + PARAM_TOKEN;
		String user = "-user";// + PARAM_USER;
		String shellCmd = "" + LINUX_BASE_DIR + "/" + SERVER_SHELL_NAME;
		
		logger.info(shellCmd);
		logger.info("Game Name : " + startinfoVo.getGameName());
		logger.info("User ID : " + startinfoVo.getUserId());
		logger.info("Port : " + startinfoVo.getPort());
		//String[] cmd = {shellCmd, user, startinfoVo.getUserId(), port, startinfoVo.getPort(), token, PARAM_TOKEN, max_players, PARAM_MAX_PLAYERS, cluster_name, PARAM_CLUSTER_PASSWORD, cluster_password, PARAM_CLUSTER_PASSWORD};
		String[] cmd = {shellCmd, "start", startinfoVo.getUserId()};		
		Runtime rt = Runtime.getRuntime(); 
		try {
			logger.info("pb.start() before");
			//Process process = pb.start();
			Process process = rt.exec(cmd);
			logger.info("pb.start() after");
			
			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream())
					);
			String line;
			while((line = reader.readLine()) != null ) {
				output.append(line);
			}
			logger.info(output.toString());
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

		logger.info("startServer() out");
		return 0;
	}
	
	public int stopServer(CtrlVO startinfoVo) {
		logger.info("stopServer() in");
		String shellCmd = "" + LINUX_BASE_DIR + "/" + SERVER_SHELL_NAME;
		
		logger.info(shellCmd);
		logger.info("Game Name : " + startinfoVo.getGameName());
		logger.info("User ID : " + startinfoVo.getUserId());
		logger.info("Port : " + startinfoVo.getPort());
		String[] cmd = {shellCmd, "stop", startinfoVo.getUserId()};		
		Runtime rt = Runtime.getRuntime(); 
		try {
			logger.info("pb.start() before");
			//Process process = pb.start();
			Process process = rt.exec(cmd);
			logger.info("pb.start() after");
			
			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream())
					);
			String line;
			while((line = reader.readLine()) != null ) {
				output.append(line);
			}
			logger.info(output.toString());
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

		logger.info("stopServer() out");
		return 0;
	}
	
	public int restartServer(CtrlVO startinfoVo) {
		logger.info("restartServer() in");
		String shellCmd = "" + LINUX_BASE_DIR + "/" + SERVER_SHELL_NAME;
		
		logger.info(shellCmd);
		logger.info("Game Name : " + startinfoVo.getGameName());
		logger.info("User ID : " + startinfoVo.getUserId());
		logger.info("Port : " + startinfoVo.getPort());
		String[] cmd = {shellCmd, "restart", startinfoVo.getUserId()};		
		Runtime rt = Runtime.getRuntime(); 
		try {
			logger.info("pb.start() before");
			//Process process = pb.start();
			Process process = rt.exec(cmd);
			logger.info("pb.start() after");
			
			StringBuilder output = new StringBuilder();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream())
					);
			String line;
			while((line = reader.readLine()) != null ) {
				output.append(line);
			}
			logger.info(output.toString());
		}catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}

		logger.info("restartServer() out");
		return 0;
	}
}
