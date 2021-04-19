
import org.apache.camel.builder.RouteBuilder;

public class FileToJMSRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("ftp://server.com/orders?username=rider&password=secret").to("jms:incomingOrders");
    }
}
