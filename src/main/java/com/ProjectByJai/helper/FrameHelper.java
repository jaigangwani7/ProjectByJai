package com.ProjectByJai.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.ProjectByJai.constant.Constant;

public class FrameHelper 
{
	private Logger log = LoggerHelper.takeLogger(FrameHelper.class);
	
	/**
	 * this method will switchToFrame based on frame index
	 * @param frameIndex
	 */
	public void switchToFrame(int frameIndex){
		Constant.driver.switchTo().frame(frameIndex);
		log.info("switched to :"+ frameIndex+" frame");
	}
	
	/**
	 * this method will switchToFrame based on frame name
	 * @param frameName
	 */
	public void switchToFrame(String frameName){
		Constant.driver.switchTo().frame(frameName);
		log.info("switched to :"+ frameName+" frame");
	}
	
	/**
	 * this method will switchToFrame based on frame WebElement
	 * @param element
	 */
	public void switchToFrame(WebElement element){
		Constant.driver.switchTo().frame(element);
		log.info("switched to frame "+element.toString());
	}
}
