package weather.forecast;

import ipma.client.IpmaApiClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AnyCityForecast {

    private static final Logger logger = LogManager.getLogger(AnyCityForecast.class);
    private List<Integer> cities = new ArrayList<>(Arrays.asList(1010500,
         1020500,
         1030300,
         1030800,
         1040200,
         1050200,
         1060300,
         1070500,
         1080500,
         1081505,
         1081100,
         1080800,
         1090700,
         1090821,
         1100900,
         1110600,
         1121400,
         1131200,
         1141600,
         1151200,
         1151300,
         1160900,
         1171400,
         1182300,
         2310300,
         2320100,
         3410100,
         3420300,
         3430100,
         3440100,
         3450200,
         3460200,
         3470100,
         3480200,
         3490100));

    class MyTimerTask extends TimerTask {
        public void run() {
            int CITY_ID = cities.get((int) (Math.random() * cities.size()));
            String result = IpmaApiClient.maxTemp(CITY_ID);
            logger.info(result.trim() + " in " + CITY_ID);
        }
    }

    public static void main(String[] args) {

        AnyCityForecast app = new AnyCityForecast();
        MyTimerTask myTask = app.new MyTimerTask();
        Timer myTimer = new Timer();

        myTimer.schedule(myTask, 0, 20000);

        while (true) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

        myTimer.cancel();
    }
}
