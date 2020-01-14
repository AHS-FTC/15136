package org.firstinspires.ftc.teamcode;

import backcountry.Chassis;

class PlanParkRedNear {
    private Chassis c;
    public PlanParkRedNear(Chassis c){
        this.c = c;
    }
    public void run(){
        c.Strafe(.50,30);

    }
}