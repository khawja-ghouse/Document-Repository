package com.leap.forwarder.bean;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.camel.Exchange;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rabbitmq.jms.admin.RMQConnectionFactory;

import com.attunedlabs.leap.LeapDataContext;
import static com.leap.forwarder.util.LeapForwarderConstant.*;

@Configuration
public class JMSDispatcherBean {
	private static Logger logger = LoggerFactory.getLogger(JMSDispatcherBean.class.getName());

	public void setAuthDetails(Exchange exchange) {
		logger.debug("Inside setAuthDetails");
		String actionValue = exchange.getIn().getHeader("action").toString();
		String destinationQueueName = null;
		String tslVersion = null;
		LeapDataContext leapDataContext = exchange.getIn().getHeader(LEAP_DATA_CONTEXT, LeapDataContext.class);
		JSONObject configJSONObj = new JSONObject(
				leapDataContext.getContextElement(actionValue).getData().getItems().getData().toString());
		destinationQueueName = configJSONObj.getJSONObject(DESTINATION).getString(DESTINATION_NAME);
		tslVersion = configJSONObj.getJSONObject(TSL_KEY).getString(TSL_VERSION_KEY);
		if (tslVersion != null) {
			exchange.getIn().setHeader(TSL_VERSION_KEY, tslVersion);
		}
		if (destinationQueueName != null)
			exchange.getIn().setHeader(QUEUE_NAME, destinationQueueName);
		if (configJSONObj.has(TSL_KEY))
			exchange.getIn().setHeader(TSL_ENABLED_KEY, true);
		else
			exchange.getIn().setHeader(TSL_ENABLED_KEY, false);

	}

	@Bean(name = "jmsTLSv1_3Connection")
	public RMQConnectionFactory jmsConnectionFactory() throws Exception {
		RMQConnectionFactory rc = new RMQConnectionFactory();
		rc.setPassword("guest");
		rc.setUsername("guest");
		rc.setHost("localhost");
		rc.setVirtualHost("/");
		rc.setPort(5673);
		rc.useSslProtocol(getSSLContext());
		System.out.println("is SSL enabled? : " + rc.isSsl());
		return rc;
	}

	private SSLContext getSSLContext() throws Exception {
		try {
			logger.debug("Inside getSSLContext");
			// use apache http-client
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			FileInputStream instream = new FileInputStream(new File("D:\\Khawja_Ghouse\\JMS_RMQ_TSL\\jmsjkscert.jks"));
			try {
				trustStore.load(instream, "reactive".toCharArray());
			} finally {
				instream.close();
			}
			SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy())
					.build();
			return sslcontext;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
