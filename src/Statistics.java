import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Statistics {

    int totalTraffic;
    double sumTraffic;
    LocalDateTime minTime, maxTime;

    public Statistics() {
        this.minTime = null;
        this.maxTime = null;
        this.totalTraffic = 0;
        this.sumTraffic = 0;
    }

    public void addEnty(LogEntry logEntry) {
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
    }

    public double getTrafficRate() {
        System.out.println("Обьем данных = " + sumTraffic);
        System.out.println("Количество часов = " + minTime.until(maxTime, ChronoUnit.HOURS));
        return (double) sumTraffic / minTime.until(maxTime, ChronoUnit.HOURS);
    }
}
