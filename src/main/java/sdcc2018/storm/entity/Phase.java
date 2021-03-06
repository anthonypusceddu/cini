package sdcc2018.storm.entity;

import java.io.Serializable;

public class Phase implements Serializable {
    private int id;
    private int green;//green time
    private int red;//red time
    private double effective_green;//effective green time
    private double effective_red;//effective red time
    private double ratioFlowSaturation;//rapporto flusso/saturazione

    public Phase(int id) {
        this.id = id;
    }
    public Phase(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public double getEffective_green() {
        return effective_green;
    }

    public void setEffective_green(double effective_green) {
        this.effective_green = effective_green;
    }

    public double getEffective_red() {
        return effective_red;
    }

    public void setEffective_red(double effective_red) {
        this.effective_red = effective_red;
    }

    public double getRatioFlowSaturation() {
        return ratioFlowSaturation;
    }

    public void setRatioFlowSaturation(double ratioFlowSaturation) {
        this.ratioFlowSaturation = ratioFlowSaturation;
    }
}
