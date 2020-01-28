package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.org.firstinspires.ftc.teamcode;

import android.graphics.Bitmap;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.internal.android.dx.util.Warning;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.FTCUtilities;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.sensors.vuforia;

import java.util.List;


@Disabled
@TeleOp(name="Vision Test OpMode", group="Iterative Opmode")
public class WebCam  extends LinearOpMode
{
    //    Vuforia vuforia;
    Bitmap vuBitmap;
    Bitmap croppedBitmap;

    public final int IMAGE_X = 0;
    public final int IMAGE_Y = 500;
    public final int IMAGE_WIDTH = 1000;
    public final int IMAGE_HEIGHT = 200;
    private org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.sensors.vuforia vuforia;
    private static final String VUFORIA_KEY = "AUKN4dL/////AAABmZL4EHQ+ukIzpu89viYzaR4/jtXdbGjrssYSj0jYOGUszrxyjIZgyw6bnlbe3u5cMKxWpBP4i8HPWkAKoqmaJmRHrv8Ho7vPazLYJ65ZoLevtugk9OihzarMGR1FSjcThK3Tx3k2zpgCwaZWGopNS4ObXr5mFqdZkLmE11hEj7QV/sX886rFKB6Q9ySF1L4eYhwZmsArJjf5BGgenPwg0/Ou8yhB3VXk5++EAbLQwwlSFYZnQkS8h9TeGHe7LL5CbPgYptx+qo8iLJqqx6cqkabRHyVv1rzTxeJw42wFpHAono6FcMrWOiuKZs2xBiKKlUlw2qI8cl6sHbhiRPcOtLO3X5p7f0+fInRqOY4pakdS";
    private VuforiaLocalizer Vuforia;
    private TFObjectDetector tfod;
    boolean chkloop = true;
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "Webcam 1");

        //  Instantiate the Vuforia engine
        Vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the Tensor Flow Object Detection engine.
    }

    @Override
    public void runOpMode() throws InterruptedException {
        initVuforia();
//        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
//            initTfod();
//        } else {
//            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
//        }

        telemetry.addData(">", "Press Play to start tracking");
        telemetry.update();
        waitForStart();
        FTCUtilities.setOpMode(this);
        this.vuforia = new vuforia();
        if (opModeIsActive()) {
            /** Activate Tensor Flow Object Detection. */
            if (tfod != null) {
                tfod.activate();
            }

            while (chkloop) {
                if (tfod != null) {


                    vuBitmap = vuforia.getBitmap();
                    croppedBitmap = Bitmap.createBitmap(vuBitmap, IMAGE_X, IMAGE_Y, IMAGE_WIDTH, IMAGE_HEIGHT);

                    telemetry.addData("height", croppedBitmap.getHeight());
                    telemetry.addData("width", croppedBitmap.getWidth());

                    int[] pixles = new int[croppedBitmap.getWidth()];


                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        croppedBitmap.getPixel(720, 1080);
                        //color = Color.valueOf(bitmap.getPixel(50,50));
                    }
                }
            }
        }
    }

    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, Vuforia);
    }
}