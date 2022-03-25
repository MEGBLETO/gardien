package engine;

import java.util.Timer;
import java.util.TimerTask;

public class Time {//ajout timer dans gamebuilder a voir
    int second = 0;
    int click = 0;

    Timer chrono = new Timer();
    TimerTask go = new TimerTask() {
        @Override
        public void run() {
            second++;
            System.out.print("Time : "+second+"\n");
        }
    };

    public void TimeExec(){
        long debut = System.nanoTime();
        long end = System.nanoTime()-debut;
        System.out.println("Execution time : "+end+" ns");
    }

    public void CountClick(){ // ajout a maingui appel countclick() a voir
        click++;
        System.out.println("Number of click : "+click);
    }

    public void start(){
        TimeExec();
        chrono.scheduleAtFixedRate(go,1000,1000);
    }


}
