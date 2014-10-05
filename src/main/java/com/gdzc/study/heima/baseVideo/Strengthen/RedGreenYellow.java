package com.gdzc.study.heima.baseVideo.Strengthen;

/**
 * -红绿灯枚举
 * Created by Liu_Zhichao on 14-10-6.
 */
public enum RedGreenYellow {
    RED(35){
        @Override
        public RedGreenYellow nextLamp() {
            return GREEN;
        }
    },GREEN(40){
        @Override
        public RedGreenYellow nextLamp() {
            return YELLOW;
        }
    },YELLOW(5){
        @Override
        public RedGreenYellow nextLamp() {
            return RED;
        }
    };

    private int time;
    private RedGreenYellow(int time){
        this.time = time;
    }

    public abstract RedGreenYellow nextLamp();
}
