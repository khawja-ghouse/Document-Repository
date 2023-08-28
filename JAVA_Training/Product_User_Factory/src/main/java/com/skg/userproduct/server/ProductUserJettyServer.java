package com.skg.userproduct.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductUserJettyServer {

	private static final Logger logger = LoggerFactory.getLogger(ProductUserJettyServer.class);

	public static void main(String[] args) {
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
		context.setContextPath("/");
		Server server = new Server(8080);
		server.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(1);
		jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "com.skg.userproduct.resources");

		try {
			server.start();
			server.join();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			server.destroy();
		}

	}
}
