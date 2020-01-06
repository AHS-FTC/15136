package backcountry;

import org.firstinspires.ftc.robotcore.internal.android.dx.util.Warning;

import backcountry.sensors.IMU;

public class Chassis{

    private DriveUnit RightFront;
    private DriveUnit LeftFront;
    private DriveUnit RightBack;
    private DriveUnit LeftBack;

    private double runTime;
    private backcountry.sensors.IMU IMU;


    public Chassis(){
        this.RightFront= new DriveUnit(1,4,"RightFront",false);
        this.LeftFront= new DriveUnit(1,4,"LeftFront",true);
        this.RightBack= new DriveUnit(1,4,"RightBack",false);
        this.LeftBack= new DriveUnit(1,4,"LeftBack",true);
        this.IMU = new IMU(FTCUtilities.getIMU("imu"));

    }



    public void init(){
        RightFront.init();
        LeftFront.init();
        LeftBack.init();
        RightBack.init();
    }

    public void StraitMotion(double Speed,double Distence){
        RightBack.zeroDistance();
        LeftBack.zeroDistance();
        RightFront.zeroDistance();
        LeftFront.zeroDistance();

        while(true){

            RightBack.setPower(Speed);
            LeftBack.setPower(Speed);
            RightFront.setPower(Speed);
            LeftFront.setPower(Speed);

            double TravledRight = RightFront.getInchesTravelled();
            double TravledLeft = LeftFront.getInchesTravelled();

            if((TravledRight > Distence) || (TravledLeft > Distence)){
                break;
            }
            throw new Warning("you're in the while loop");
        }

        RightBack.setPower(0);
        LeftBack.setPower(0);
        RightFront.setPower(0);
        LeftFront.setPower(0);
    }

    public void Rotate(int degrees, double power){

        double  leftPower, rightPower;

        IMU.resetAngle();

        if (degrees < 0)
        {   // turn right.
            leftPower = power;
            rightPower = -power;
        }
        else if (degrees > 0)
        {   // turn left.
            leftPower = -power;
            rightPower = power;
        }
        else return;

        RightFront.setPower(rightPower);
        LeftFront.setPower(leftPower);
        RightBack.setPower(rightPower);
        LeftBack.setPower(leftPower);

        if (degrees < 0)
        {
            while (IMU.getAngle() == 0) {}
            while (IMU.getAngle() > degrees) {}
        }
        else    // left turn.
            while (IMU.getAngle() < degrees) {}

        RightFront.setPower(0);
        LeftFront.setPower(0);
        RightBack.setPower(0);
        LeftBack.setPower(0);

        IMU.resetAngle();
    }

    public void Strafe(double speed,int Distence){
        RightBack.zeroDistance();
        LeftBack.zeroDistance();
        RightFront.zeroDistance();
        LeftFront.zeroDistance();

        boolean run = true;
        while(run){
            RightBack.setPower(-speed);
            LeftBack.setPower(speed);
            RightFront.setPower(-speed);
            LeftFront.setPower(speed);

            double TravledRight = RightFront.getInchesTravelled();
            double TravledLeft = LeftFront.getInchesTravelled();

            if(TravledRight > Distence || TravledLeft > Distence){
                run = false;
            }
        }

        RightBack.setPower(0);
        LeftBack.setPower(0);
        RightFront.setPower(0);
        LeftFront.setPower(0);
    }

}

