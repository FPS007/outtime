package demo.timedesc;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class manager {
	//����ʱ����������������10sһ��
	private static final long PERIOD_DAY = 10 * 60 * 1000;
	public void send() {
		//����ִ��ʱ��
		Calendar calendarup = Calendar.getInstance();
		calendarup.set(Calendar.HOUR_OF_DAY, 15);	//ʱ
		calendarup.set(Calendar.MINUTE, 27);		//��
		calendarup.set(Calendar.SECOND, 0);			//��
		Date dateup = calendarup.getTime(); 
		// ��һ��ִ�ж�ʱ�����ʱ��
		// �����һ��ִ�ж�ʱ�����ʱ���ڵ�ǰ��ʱ��֮�䣬���������ִ�У������������������addhour����һСʱ��
		if (dateup.before(new Date())) {
			dateup = this.addHour(dateup, 1);
		}
		Timer timerSend = new Timer();
		//ʵ������Ҫִ�е����񣬷����ʼ�
		sendemail send = new sendemail();
		// ����ָ����������ָ����ʱ�俪ʼ�����ظ��Ĺ̶��ӳ�ִ�С�
		timerSend.schedule(send, dateup, PERIOD_DAY);
	}
	//�Ƴ����ڣ�������Ҫ��������ִ�о���ʱ�䣬����趨��ִ��ʱ����Ѿ���ȥ�����Ƴ�1Сʱִ��
	public Date addHour(Date date, int num) {
			Calendar startDT = Calendar.getInstance();
			startDT.setTime(date);
			startDT.add(Calendar.HOUR_OF_DAY, num);
			return startDT.getTime();
	}
}
