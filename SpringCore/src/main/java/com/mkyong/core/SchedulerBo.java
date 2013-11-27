package com.mkyong.core;

public class SchedulerBo {
	private String msg;
	
	public void printMsg(String msg) {
		this.msg = msg;
		System.out.println("SchedulerBo : " + msg);
	}
	
	@Override
	public String toString() {
		return "Scheduler Object: " + super.toString() + "->msg: " + msg;
	}	
}
