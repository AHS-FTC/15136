package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.org.firstinspires.ftc.teamcode;

import android.graphics.Bitmap;
import android.os.Build;

import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.sensors.vuforia;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.FTCUtilities;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.vuforia.Vuforia;

@TeleOp(name="Vision Test OpMode", group="Iterative Opmode")
public class WebCam extends OpMode
{
    Vuforia vuforia;
    Bitmap vuBitmap;
    Bitmap croppedBitmap;

    public final int IMAGE_X = 0;
    public final int IMAGE_Y = 500;
    public final int IMAGE_WIDTH = 1000;
    public final int IMAGE_HEIGHT = 200;


    @Override
    public void init() {
        FTCUtilities.setOpMode(this);
        vuforia = new Vuforia();
    }

    @Override    public void init_loop() {
    }

    @Override
    public void start() {
        vuBitmap = vuforia.getBitmap();
        croppedBitmap = Bitmap.createBitmap(vuBitmap, IMAGE_X, IMAGE_Y, IMAGE_WIDTH, IMAGE_HEIGHT);

        telemetry.addData("height", Bitmap.getHeight());
        telemetry.addData("width", Bitmap.getWidth());

        int[] pixles = new int[Bitmap.getWidth()];


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Bitmap.getPixels();
            //color = Color.valueOf(bitmap.getPixel(50,50));
        }


    }

    @Override
    public void loop() {


    }

    @Override
    public void stop() {
    }

}