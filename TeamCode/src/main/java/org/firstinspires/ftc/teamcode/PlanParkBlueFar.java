package org.firstinspires.ftc.teamcode;

import backcountry.Chassis;

class PlanParkBlueFar {
    private Chassis c;
    public PlanParkBlueFar(Chassis c){
        this.c = c;
    }
    public void run(){
        c.StraitMotion(.50, 21);
        c.Strafe(-.50,30);
    }
}