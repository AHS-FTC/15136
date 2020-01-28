package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.Chassis;

class PlanBlueDepo {
    private Chassis c;
    public PlanBlueDepo(Chassis c){
        this.c = c;
    }
    public void run(){
        c.StraitMotion(-.50,20);

    }
}