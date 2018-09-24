package java8.newdate;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import static java.lang.System.out;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class TestNewDate {

  @Test
  public void testLocalDate() {
    LocalDate localDate =  LocalDate.of(2018, 9, 24);
    System.out.println(localDate);
    out.println(localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfMonth());
  }

  @Test
  public void testLocalTime() {
    LocalTime localTime =  LocalTime.of(23, 9, 24);
    out.println(localTime);
  }

  @Test
  public void testLocalDateTime() {
    LocalDateTime localDateTime =  LocalDateTime.of(2018, 9, 24,23, 9, 24);
    out.println(localDateTime);

    LocalDate date = localDateTime.toLocalDate();
    LocalTime time = localDateTime.toLocalTime();
    Instant instant = Instant.ofEpochSecond(1, 1_0_00_000);
    out.println(instant);
  }

  @Test
  public void teastInstant() {
    LocalDateTime localDateTime = LocalDateTime.now();
    ZoneId zoneId = ZoneId.of("GMT-7");
    ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
    System.out.println("zonedDateTime: "+zonedDateTime.format(DateTimeFormatter.ofPattern("YYYY" +
      "-MM-dd HH:mm:ss")));

    Instant instant = Instant.ofEpochSecond(1537804621L*1000);
    out.println(instant);
    out.println("LocalDateTime:"+LocalDateTime.ofInstant(instant, zoneId));
    ZonedDateTime dateTime = ZonedDateTime.ofInstant(instant, zoneId);
    System.out.println("dateTime: "+dateTime.format(DateTimeFormatter.ofPattern("YYYY" +
      "-MM-dd HH:mm:ss")));

    TimeZone usa = TimeZone.getTimeZone("GMT-7");
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
    sdf.setTimeZone(usa);
    out.println("时间戳 -> date: "+sdf.format(new Date(Long.valueOf(1537804621L*1000))));

    Date date = new Date();
    out.println(sdf.format(date));
  }

  @Test
  public void testDuration() {
    // 以秒为单位的时间间隔
    Duration duration = Duration.between( LocalDateTime.of(2018, 9, 24,23, 9, 23),
       LocalDateTime.of(2018, 9, 24,23, 9, 24) );
    out.println(duration.getSeconds());
  }

  @Test
  public void testPeriod() {
    // 以秒为单位的时间间隔
    Period period = Period.between( LocalDate.of(2018, 8, 3),
      LocalDate.of(2018, 9, 4) );
    out.println(period);
  }

  @Test
  public void testParse() {
    LocalDate localDate1 = LocalDate.of(1201, 1,1);
    LocalDate localDate2 = localDate1.with(lastDayOfMonth());

    out.println(localDate2);
  }

}
