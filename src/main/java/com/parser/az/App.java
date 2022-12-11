package com.parser.az;

import com.parser.az.service.LalafoCollectorServiceImpl;
import com.parser.az.service.interfaces.LalafoCollectorService;
import com.parser.az.service.schedule.SchedulerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println(" For beginning write what you want to search here is 3 options:" +
                " \n cpu \n videocard \n motherboard");
        Timer time = new Timer(); // Instantiate Timer Object
        SchedulerService st = new SchedulerService(); // Instantiate SheduledTask class
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SchedulerService.productType = reader.readLine();
        time.schedule(st, 0, 7000);
    }
}
