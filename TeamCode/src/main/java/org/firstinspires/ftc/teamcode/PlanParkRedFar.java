package org.firstinspires.ftc.teamcode;

import backcountry.Chassis;

class PlanParkRedFar {
    private Chassis c;
    public PlanParkRedFar(Chassis c){
        this.c = c;
    }
    public void run(){
        c.StraitMotion(.50,21);
        c.Strafe(.50, 30);
    }
}