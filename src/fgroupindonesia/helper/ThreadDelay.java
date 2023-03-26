package fgroupindonesia.helper;

import fgroupindonesia.frames.MainFrame;
import java.util.TimerTask;

/**
 *
 * @author asus
 */
public class ThreadDelay extends TimerTask {

    MainFrame mframe;

    public ThreadDelay(MainFrame mf) {
        mframe = mf;
    }

    @Override
    public void run() {

        if(mframe!=null)
        mframe.displayLogin();
        
    }

}
