/**
 * Created by kei on 2016/09/15.
 */

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class WebSocketServletImpl extends WebSocketServlet{
    private static final long serialVersionUID = 1L;

    @Override
    public void configure(WebSocketServletFactory factory) {
        // Listener
        factory.register(WebSocketListener.class);
    }
}