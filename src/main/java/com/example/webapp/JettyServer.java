package com.example.webapp;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JettyServer {
    private static final Logger logger = LoggerFactory.getLogger(JettyServer.class);

    public static void main(String[] args) throws Exception {
        logger.info("Starting Jetty server...");
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new HelloServlet()), "/webpage");

        server.start();
        logger.info(" http://localhost:8080/webpage");
        server.join();
    }
}
