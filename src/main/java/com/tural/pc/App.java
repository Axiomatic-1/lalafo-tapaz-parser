package com.tural.pc;

import com.tural.pc.service.SchedulerService;

import java.util.Timer;


public class App {
    public static void main(String[] args) {
        Timer time = new Timer(); // Instantiate Timer Object
        SchedulerService st = new SchedulerService(); // Instantiate SheduledTask class
        time.schedule(st, 0, 10000);
    }
}
