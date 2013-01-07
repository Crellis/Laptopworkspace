package com.craigdavidellis;
/*
 * Project Title: Space Wars
 * Author: Craig Ellis
 * Email: craigdavidellis@gmail.com
 * Course: DT354/4
 * Version 1.0
 * Date June 2012
 */
import java.io.Serializable;

public class Score  implements Serializable {
        private int score;
        private String name;

        public int getScore() {
                return score;
        }

        public String getName() {
                return name;
        }

        public Score(String name, int score) {
                this.score = score;
                this.name = name;
        }
}