package com.testJDK18.j2014;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestDateAPI {

	public static void main(String[] args) throws Exception {
		Instant start = Instant.now();
		Thread.sleep(500);
		Instant end = Instant.now();
		Instant plus = end.plus(1, ChronoUnit.DAYS);
		Duration timeElapse = Duration.between(start, plus);
		long days = timeElapse.toDays();
		long hours = timeElapse.toHours();
		long minutes = timeElapse.toMinutes();
		long millis = timeElapse.toMillis();
		long sec = timeElapse.getSeconds();
		System.out.println(timeElapse + "--" + days + "--" + hours + "--" + minutes + "--" + sec + "--" + millis);
		System.out.println("------------------");

		LocalDateTime current = LocalDateTime.now();
		System.out.println(current);
		System.out.println(current.minusDays(2));
		LocalDate date = current.toLocalDate();
		System.out.println(date);
		LocalTime now = current.toLocalTime();
		System.out.println(now);
		System.out.println("-----------------");

		Month month = current.getMonth();
		Chronology chronology = current.getChronology();
		System.out.println(chronology);// 年表 曆法
		int day = current.getDayOfMonth();
		int day2 = current.getDayOfYear();
		int seconds = current.getSecond();
		System.out.println(month + "/" + day + "/" + day2 + "/" + seconds);

		LocalDateTime time = current.withDayOfMonth(10).withMonth(8).withYear(2018);
		System.out.println(time);
		LocalDate date2 = LocalDate.of(2018, Month.APRIL, 11);
		System.out.println(date2);
		LocalTime times = LocalTime.of(1, 1, 1);
		System.out.println(times);
		LocalDateTime currentTime = LocalDateTime.parse("2000-01-08T16:00:00");
		// 格式化日期時間
		String format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(currentTime);
		System.out.println(currentTime);
		System.out.println(format);
		System.out.println("---------------");

		ZonedDateTime zoneTime = ZonedDateTime.now();
		System.out.println(zoneTime);
		ZoneId zone = zoneTime.getZone();
		System.out.println(zone);
		ZoneId id = ZoneId.systemDefault();
		System.out.println(id);
		ZoneId z = ZoneId.of("Asia/Shanghai");
		System.out.println(z);

	}

}
