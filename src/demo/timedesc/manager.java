package demo.timedesc;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class manager {
	//调用时间间隔，这里我设置10s一次
	private static final long PERIOD_DAY = 10 * 60 * 1000;
	public void send() {
		//设置执行时间
		Calendar calendarup = Calendar.getInstance();
		calendarup.set(Calendar.HOUR_OF_DAY, 15);	//时
		calendarup.set(Calendar.MINUTE, 27);		//分
		calendarup.set(Calendar.SECOND, 0);			//秒
		Date dateup = calendarup.getTime(); 
		// 第一次执行定时任务的时间
		// 如果第一次执行定时任务的时间在当前的时间之间，任务会立即执行；避免这样情况，调用addhour增加一小时。
		if (dateup.before(new Date())) {
			dateup = this.addHour(dateup, 1);
		}
		Timer timerSend = new Timer();
		//实例化需要执行的任务，发送邮件
		sendemail send = new sendemail();
		// 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		timerSend.schedule(send, dateup, PERIOD_DAY);
	}
	//推迟日期，这里主要决定任务执行具体时间，如果设定的执行时间点已经过去，就推迟1小时执行
	public Date addHour(Date date, int num) {
			Calendar startDT = Calendar.getInstance();
			startDT.setTime(date);
			startDT.add(Calendar.HOUR_OF_DAY, num);
			return startDT.getTime();
	}
}
