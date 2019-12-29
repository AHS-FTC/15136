package backcountry;

import backcountry.Chassis;

public class Robot {
    private Chassis chassis;

    public Robot(){
        this.chassis = new Chassis();
    }


    public Chassis getChassis(){
        return chassis;
    }

    public void init(){
        chassis.init();
    }

}
