/**
 * Created by kei on 2016/09/15.
 */
import java.util.ArrayList;
import java.util.List;

public class WebSocketBroadcaster {
    private static WebSocketBroadcaster INSTANCE = new WebSocketBroadcaster();
    private List<WebSocketListener> clients = new ArrayList<WebSocketListener>();

    private WebSocketBroadcaster(){}

    protected static WebSocketBroadcaster getInstance(){
        return INSTANCE;
    }

    /**
     * Add Client
     * */
    protected void join(WebSocketListener socket){
        clients.add(socket);
    }
    /**
     * Delete Client
     * */
    protected void bye(WebSocketListener socket){
        clients.remove(socket);
    }

    /**
     * BroadCast to joined member
     * */
    protected void sendToAll(String message){
        for(WebSocketListener member: clients){
            member.getSession().getRemote().sendStringByFuture(message);
        }
    }
}
