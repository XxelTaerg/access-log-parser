import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Statistics {

    int totalTraffic;
    double sumTraffic;
    LocalDateTime minTime, maxTime;
    HashSet<String> existPage = new HashSet<>();
    HashMap<String, Integer> countKindOfOS = new HashMap<>();


    public Statistics() {
        this.minTime = null;
        this.maxTime = null;
        this.totalTraffic = 0;
        this.sumTraffic = 0;
    }

    public void addEnty(LogEntry logEntry) throws ParseException {
        if (minTime != null && maxTime != null) {
            if (logEntry.getDatestamp().isBefore(minTime)) {
                this.minTime = logEntry.getDatestamp();
            } else if (logEntry.getDatestamp().isAfter(maxTime)) {
                this.maxTime = logEntry.getDatestamp();
            }
        } else {
            this.minTime = logEntry.getDatestamp();
            this.maxTime = logEntry.getDatestamp();
        }
        this.totalTraffic = logEntry.getDataSize();
        this.sumTraffic += totalTraffic;
        if (logEntry.getHttpAnswer() == 200) {
            existPage.add(logEntry.getPathStartPage());
        }
        String osToCountOfOs = new UserAgent(logEntry.getUserAgent()).getOs();
        if (countKindOfOS.containsKey(osToCountOfOs)) {
            countKindOfOS.put(osToCountOfOs, countKindOfOS.get(osToCountOfOs) + 1);
        }else countKindOfOS.put(osToCountOfOs, 1);
    }

    public double getTrafficRate() {
        System.out.println("Обьем данных = " + sumTraffic);
        System.out.println("Количество часов = " + minTime.until(maxTime, ChronoUnit.HOURS));
        return (double) sumTraffic / minTime.until(maxTime, ChronoUnit.HOURS);
    }

    public HashSet<String> getExistPages () {
        return this.existPage;
    }

    public HashMap<String, Double> getStatsOfOs(){
        int sum = 0;
        for (Integer a : this.countKindOfOS.values()) {
            sum = sum + a;
        }
        HashMap<String, Double> statsOfOs = new HashMap<>();
        for (Map.Entry<String, Integer>  a : this.countKindOfOS.entrySet())
        statsOfOs.put(a.getKey(),(double)a.getValue()/sum);

        return statsOfOs;
    }


}
