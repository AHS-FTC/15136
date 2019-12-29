package org.firstinspires.ftc.teamcode;

import backcountry.Chassis;

class TestPlan{
    private Chassis c;
    public TestPlan(Chassis c){
        this.c = c;
    }
    public void run(){
        c.StraitMotion(1.0,5);
        c.StraitMotion(1.0,5);
    }
}