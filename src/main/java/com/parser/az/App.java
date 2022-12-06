package com.parser.az;

import com.parser.az.service.SchedulerService;

import java.util.Random;
import java.util.Timer;


public class App {
    public static void main(String[] args) {
        Timer time = new Timer(); // Instantiate Timer Object
        SchedulerService st = new SchedulerService(); // Instantiate SheduledTask class
        Random random = new Random();
        int period = random.nextInt(10000) + 5000;
        time.schedule(st, 0, period);
    }
}
