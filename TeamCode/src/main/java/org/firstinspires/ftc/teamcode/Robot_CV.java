package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.*;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

import java.util.ArrayList;
//Language : CV means computer vision.
public class Robot_CV {
    //GOAL: this class will provide functions to use during opmode for returning april tag value.
    private AprilTagProcessor tagProcessor;
    private VisionPortal cv;
    public Robot_CV() {
        //constructor: custom setting for processor
        tagProcessor = new AprilTagProcessor.Builder()
                .setDrawAxes(false)
                .setDrawCubeProjection(false)
                .setDrawTagOutline(true)
                .setDrawTagID(true)
                .build();
    }
    //run once only from op
    public void initializeCam(VisionPortal cv) {
        this.cv = cv;
    }
    //get ids, so u can use this for getting the tag, then get result from it
    public ArrayList<AprilTagDetection> getDetections() {
        return tagProcessor.getDetections();
    }
    public boolean isTagVisible(int id) {
        for (AprilTagDetection d : getDetections()) {
            if (d.id == id) return true;
        }
        return false;
    }
    //same but return the tag
    public AprilTagDetection getTag(int id) {
        for (AprilTagDetection d : getDetections()) {
            if (d.id == id) return d;
        }
        return null;
    }
    //get first result as best
    public int getBestTagID() {
        ArrayList<AprilTagDetection> detections = getDetections();
        if (detections.isEmpty()) return -1;
        return detections.get(0).id;

    }
    //getter, another just in case
    public AprilTagProcessor getProcessor() {
        return tagProcessor;
    }

    public void stop() {
        if (cv != null) {
            cv.close();
        }
    }




}

