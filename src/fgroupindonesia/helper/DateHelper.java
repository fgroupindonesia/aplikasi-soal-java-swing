package fgroupindonesia.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fgroupindonesia
 */
public class DateHelper {
    public String getToday(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return sdf.format(new Date());
    }
}
