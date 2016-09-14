/**
 * Created by kei on 2016/09/14.
 */

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("WebSocket Server Init");
        Server server = new Server(9000);
        ResourceHandler resourceHandler = new ResourceHandler();
        // Set resource directory.
        resourceHandler.setResourceBase("./webapp");

        // websocket handler
        WebSocketServletImpl wsservlet = new WebSocketServletImpl();
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(wsservlet), "/");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] { resourceHandler, contextHandler });
        server.setHandler(handlers);

        try {
            server.start();
            System.out.println("Server Start");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}