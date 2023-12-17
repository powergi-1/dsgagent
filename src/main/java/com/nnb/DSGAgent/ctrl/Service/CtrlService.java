package com.nnb.DSGAgent.ctrl.Service;

public interface CtrlService {
	
	public int startServer(CtrlVO startinfoVo) throws Exception;
	public int stopServer(CtrlVO startinfoVo) throws Exception;
	public int restartServer(CtrlVO startinfoVo) throws Exception;
}
