package com.tural.pc;

import com.tural.pc.entities.VideoCard;
import com.tural.pc.service.*;

import java.util.List;
import java.util.Set;
import java.util.Timer;


public class App {

    public static final String URL =
            "https://ru.tap.az/elanlar/elektronika/komputer-avadanliqi?utf8=%E2%9C%93&order=&q"
                    + "%5Buser_id%5D=&q%5Bcontact_id%5D=&q%5Bprice%5D%5B%5D=&q%5Bprice%5D%5B%5D=&p%5B834%5D=7400"
                    + "&p%5B833%5D=&p%5B856%5D=&q%5Bregion_id%5D=&q%5Bkeywords%5D=";

    public static void main(String[] args) {
        Timer time = new Timer(); // Instantiate Timer Object
        SchedulerService st = new SchedulerService(); // Instantiate SheduledTask class
        time.schedule(st, 0, 5000);
    }
}
