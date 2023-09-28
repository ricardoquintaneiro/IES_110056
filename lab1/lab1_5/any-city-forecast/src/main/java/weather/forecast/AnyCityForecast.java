package weather.forecast;

import ipma.client.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class AnyCityForecast {

    private static final Logger logger = LogManager.getLogger(AnyCityForecast.class);

    class MyTimerTask extends TimerTask {
        public void run() {
            int CITY_ID = (int) (Math.random() * 5000) + 1000000;
            String result = ipma.client.IpmaApiClient.maxTemp(CITY_ID);
            logger.info(result);
        }
    }

    public static void main(String[] args) {

        AnyCityForecast app = new AnyCityForecast();
        MyTimerTask myTask = app.new MyTimerTask();
        Timer myTimer = new Timer();

        /*
         * Set an initial delay of 1 second, then repeat every half second.
         */

        // execute next line 100 times with 5 second interval
        myTimer.schedule(myTask, 1000, 1000);

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        myTimer.cancel();
    }
}
