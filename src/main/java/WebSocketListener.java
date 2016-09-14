/**
 * Created by kei on 2016/09/15.
 */

import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;

public class WebSocketListener {
    private Session session;

    @OnWebSocketConnect
    public void onConnect(Session session) {
        this.session = session;
        WebSocketBroadcaster.getInstance().join(this);
    }

    @OnWebSocketMessage
    public void onText(String message) {
        WebSocketBroadcaster.getInstance().sendToAll(message);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        WebSocketBroadcaster.getInstance().bye(this);
    }

    public Session getSession(){
        return this.session;
    }
}
