package com.craigdavidellis;
/*
 * Project Title: Space Wars
 * Author: Craig Ellis
 * Email: craigdavidellis@gmail.com
 * Course: DT354/4
 * Version 1.0
 * Date June 2012
 */
import java.util.Comparator;

public class HighscoreComparator implements Comparator<Score> {
	
                public int compare(Score score1, Score score2) {

                        int sc1 = score1.getScore();
                        int sc2 = score2.getScore();

                        if (sc1 > sc2){
                                return -1;
                        }else if (sc1 < sc2){
                                return +1;
                        }else{
                                return 0;
                        }
                }
}