package demo.timedesc;

import java.util.TimerTask;

public class sendemail extends TimerTask {
	//��дִ�з���
	@Override
	public void run() {
		// TODO Auto-generated method stub
		email email = new email();
		Boolean succ = email.send();
		if(succ) {
			System.out.println("���ͳɹ�++++++++++++++++++++++++++++++++++++++++++++++++");
		}else {
			System.out.println("����ʧ��------------------------------------------------");
		}
	}
	
}
