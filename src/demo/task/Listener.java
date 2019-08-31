package demo.task;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import demo.timedesc.manager;

/**
 * ��ʱ���������
 * @author liyingdhls
 *
 */
public class Listener implements ServletContextListener{
	 public void contextInitialized(ServletContextEvent event) {
		//��������
		System.out.println("��ʱ�������...");
		//���ö�ʱ��
		new manager().send();
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("��ʱ��������...");
	}

}
