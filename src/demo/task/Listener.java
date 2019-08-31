package demo.task;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import demo.timedesc.manager;

/**
 * 定时任务监听器
 * @author liyingdhls
 *
 */
public class Listener implements ServletContextListener{
	 public void contextInitialized(ServletContextEvent event) {
		//启动提醒
		System.out.println("定时任务监听...");
		//调用定时器
		new manager().send();
	}
	
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("定时任务销毁...");
	}

}
