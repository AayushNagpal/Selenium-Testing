package com.selenium;

import com.pack.base.GrabPropertyValue;

public interface TimeOuts 
{	
	public static final int VERYSHORTWAIT = GrabPropertyValue.getWaitTime("VERYSHORTWAIT");
	public static final int SHORTWAIT = GrabPropertyValue.getWaitTime("SHORTWAIT");
	public static final int MEDIUMWAIT = GrabPropertyValue.getWaitTime("MEDIUMWAIT");
	public static final int LONGWAIT = GrabPropertyValue.getWaitTime("LONGWAIT");
	public static final int VERYLONGWAIT = GrabPropertyValue.getWaitTime("VERYLONGWAIT");
	public static final int IMPLICITWAIT = GrabPropertyValue.getWaitTime("IMPLICITWAIT");

}
