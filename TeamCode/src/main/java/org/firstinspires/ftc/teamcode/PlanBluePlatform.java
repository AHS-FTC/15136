package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.Chassis;

class PlanBluePlatform {
    private Chassis c;
    public PlanBluePlatform(Chassis c){
        this.c = c;
    }
    public void run(){
        c.StraitMotion(.50,40);

    }
}