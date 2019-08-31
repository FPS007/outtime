package demo.timedesc;

import java.util.Date;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class email {
    // �����˵� ���� �� ����
    // PS: ĳЩ���������Ϊ���������䱾������İ�ȫ�ԣ��� SMTP �ͻ��������˶������루�е������Ϊ����Ȩ�롱��,
    //     ���ڿ����˶������������, ����������������ʹ������������루��Ȩ�룩��
    private static String myEmailAccount = "CXY08421@163.com";	//���÷��������˻�
    private static String myEmailPassword = "XXXXXXXXXXXX";			//���÷�����������
 
    // ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ��(ֻ��һ��, ���Ǿ���)��ʽΪ: smtp.xxx.com
    // �����ҵķ��ͷ���163���䣬 163����� SMTP ��������ַΪ: smtp.163.com
    private static String myEmailSMTPHost = "smtp.163.com";
 
    // �ռ�������
    private static String receiveMailAccount = "737322799@qq.com";
 
    public Boolean send() {
        // 1. ������������, ���������ʼ��������Ĳ�������
        Properties props = new Properties();                    // ��������
        props.setProperty("mail.transport.protocol", "smtp");   // ʹ�õ�Э�飨JavaMail�淶Ҫ��
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // �����˵������ SMTP ��������ַ
        props.setProperty("mail.smtp.auth", "true");            // ��Ҫ������֤
        Boolean success = false;
        try {
            // 2. �������ô����Ự����, ���ں��ʼ�����������
            Session session = Session.getInstance(props);
            // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log
            session.setDebug(true);
     
            // 3. ���÷��������ʼ�����
            MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);
            
            // 4. ���� Session ��ȡ�ʼ��������
            Transport transport = session.getTransport();
     
            // 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
            //
            //    PS_01: ������ӷ�����ʧ��, �����ڿ���̨�����Ӧʧ��ԭ���log��
            //    ��ϸ�鿴ʧ��ԭ��, ��Щ����������᷵�ش������鿴�������͵�����,
            //    ���ݸ����Ĵ������͵���Ӧ�ʼ��������İ�����վ�ϲ鿴����ʧ��ԭ��
            //
            //    PS_02: ����ʧ�ܵ�ԭ��ͨ��Ϊ���¼���, ��ϸ������:
            //           (1) ����û�п��� SMTP ����;
            //           (2) �����������, ����ĳЩ���俪���˶�������;
            //           (3) ���������Ҫ�����Ҫʹ�� SSL ��ȫ����;
            //           (4) �������Ƶ��������ԭ��, ���ʼ��������ܾ�����;
            //           (5) ������ϼ��㶼ȷ������, ���ʼ���������վ���Ұ�����
            //
            transport.connect(myEmailAccount, myEmailPassword);
     
            // 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ��ӵ������ռ���, ������, ������
            transport.sendMessage(message, message.getAllRecipients());
            // 7. �ر�����
            transport.close();
            success = true;
        }catch (Exception e){
        	e.printStackTrace();
        }finally {
        	return success;
        }
    }
    /**
     * ����һ��ֻ�����ı��ļ��ʼ�
     *
     * @param session     �ͷ����������ĻỰ
     * @param sendMail    ����������
     * @param receiveMail �ռ�������
     * @return
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
        // 1. ����һ���ʼ�
        MimeMessage message = new MimeMessage(session);
 
        // 2. From: ������
        message.setFrom(new InternetAddress(sendMail, "��ʱ����", "UTF-8"));
 
        // 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "�����", "UTF-8"));
        // 4. �����ʼ�����
        message.setSubject("�ʼ����Է���","UTF-8");
        // 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
        message.setContent("�ʼ����Է���.................", "text/html;charset=UTF-8");
        // 6. ���ڷ���
        message.setSentDate(new Date());
        // 7. ��������
        message.saveChanges();
        return message;
    }
}