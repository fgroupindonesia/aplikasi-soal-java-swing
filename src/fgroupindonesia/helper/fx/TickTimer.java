package fgroupindonesia.helper.fx;

import fgroupindonesia.frames.client.StudentQuestionFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class TickTimer extends TimerTask {

    StudentQuestionFrame stframe;
    private JLabel label;
    // in minutes
    private int timeLimit;
    int secondNow;

    int minute, second;
    String prefix;

    public void setPrefix(String n) {
        prefix = n;
    }

    private String getAsText(int num) {
        if (num < 10) {
            return "0" + num;
        }

        return "" + num;
    }

    public void setStudentQuestionFrameRef(StudentQuestionFrame st){
        stframe = st;
    }
    
    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * @return the timeLimit
     */
    public int getTimeLimit() {
        return timeLimit;
    }

    /**
     * @param timeLimit the timeLimit to set
     */
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;

        minute = timeLimit;
        minute--;
        second = 60;

    }

    public TickTimer() {

    }

    // this is normal increment
    private void updateLabel() {

        second++;

        if (second == 60) {
            second = 0;
            minute++;
        }

        if (prefix == null) {
            label.setText(getAsText(minute) + ":" + getAsText(second));
        } else {
            label.setText(prefix + getAsText(minute) + ":" + getAsText(second));

        }

    }

    // this is countdown counter
    private void updateLabelCountdown() {

        second--;

        if (second == 0) {
            second = 59;
            minute--;
        }

        if (prefix == null) {
            label.setText(getAsText(minute) + ":" + getAsText(second));
        } else {
            label.setText(prefix + getAsText(minute) + ":" + getAsText(second));

        }

    }

    private final static int ONE_SECOND = 1000;
    Timer timer;

    public void start() {

        timer = new Timer();
        timer.schedule(this, 0, ONE_SECOND);

    }

    @Override
    public void run() {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // updateLabel();
                updateLabelCountdown();
            }
        });

        if (secondNow == timeLimit * 60) {
            timer.cancel();
            stframe.warning();
        }

        secondNow++;

    }

}
