 

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

//admin console  is at http//localhost:8161
public class JmsMessageConsumer {

	public static void main(String[] args) throws JMSException {
		Connection connection = null;

		// start with embedded built-in activeMQ JMS provider
		// ConnectionFactory connectionFactory = new
		// ActiveMQConnectionFactory("vm://localhost");

		// connect to external activeMQ JMS provider
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");

		connection = connectionFactory.createConnection();
		connection.start();
		int autoAck = Session.AUTO_ACKNOWLEDGE;
		Session session = connection.createSession(false, autoAck);
		Destination queue = new ActiveMQQueue("test.Queue");
		MessageConsumer consumer = session.createConsumer(queue);
		System.out.println("Starting to read messages..");
		//blocking if there is no message to read on the queue..
		Message receivedMessage = consumer.receive();
		
		//Receive the message with timeout..
		//Message receivedMessage = consumer.receive(5000);
		
		System.out.println("The receivedMessage is  "+receivedMessage);
		
		if (!(receivedMessage instanceof TextMessage)) {
			throw new RuntimeException("expected a TextMessage..");
		}
		String text = ((TextMessage) receivedMessage).getText();
		System.out.println("The text message received in jms consumer is  :  "
				+ text);

		connection.close();
	}
}
