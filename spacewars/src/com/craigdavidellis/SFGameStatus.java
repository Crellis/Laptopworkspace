package com.craigdavidellis;
/*
 * Project Title: Space Wars
 * Author: Craig Ellis
 * Email: craigdavidellis@gmail.com
 * Course: DT354/4
 * Version 1.0
 * Date June 2012
 */

public class SFGameStatus {

	private int level;
	private long levelStartTime;
	
	public SFGameStatus() {
		level = 1;
		levelStartTime = System.nanoTime();
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
}
