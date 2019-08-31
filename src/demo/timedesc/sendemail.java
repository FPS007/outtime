package demo.timedesc;

import java.util.TimerTask;

public class sendemail extends TimerTask {
	//重写执行方法
	@Override
	public void run() {
		// TODO Auto-generated method stub
		email email = new email();
		Boolean succ = email.send();
		if(succ) {
			System.out.println("发送成功++++++++++++++++++++++++++++++++++++++++++++++++");
		}else {
			System.out.println("发送失败------------------------------------------------");
		}
	}
	
}
