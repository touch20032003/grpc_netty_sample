package main;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;

public class ServerMain {
	
	public static void main(String[] args){
		Server server = NettyServerBuilder.forPort(50010).addService(new PersonSever()).build();  
        try {
			server.start();
			Logger.getLogger(ServerMain.class.getName()).info("Server has started, listening on  50010");
	        server.awaitTermination();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
