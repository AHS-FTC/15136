package org.firstinspires.ftc.teamcode;

import backcountry.Chassis;

class PlanParkBlueNear {
    private Chassis c;
    public PlanParkBlueNear(Chassis c){
        this.c = c;
    }
    public void run(){
        c.Strafe(-.50,30);

    }
}