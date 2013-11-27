package com.mkyong.core;

public class CustomerBo {
	private String msg;
	
	public void printMsg(String msg) {
		this.msg = msg;
		System.out.println("CustomerBo : " + msg);
	}
	
	@Override
	public String toString() {
		return "Customer Object: " + super.toString() + "->msg: " + msg;
	}
}
