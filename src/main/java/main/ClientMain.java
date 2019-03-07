package main;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.protobuftest.protobuf.PersonRequest;
import com.protobuftest.protobuf.PersonResponse;
import com.protobuftest.protobuf.PersonServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;

public class ClientMain {
	
	public static void main(String[] args){
		@SuppressWarnings("deprecation")
		ManagedChannel channel =  NettyChannelBuilder.forAddress("localhost", 50010).usePlaintext(true).build();  
		PersonServiceGrpc.PersonServiceBlockingStub client = PersonServiceGrpc.newBlockingStub(channel).withDeadlineAfter(60000, TimeUnit.MILLISECONDS); 
		
		PersonResponse rs =  client.get(PersonRequest.newBuilder().setName("xy").setId(123).build());
		if(rs!=null){
			Logger.getLogger(ClientMain.class.getName()).info(String.format("Get grpc response from 127.0.0.1:50010: Name:%s, Id:%d, Email:%s, PhoneNumber:%s, PhoneType:%s"
					,rs.getName(),rs.getId(),rs.getEmail(),rs.getPhone(0).getNumber(),rs.getPhone(0).getType()));
		}
	}

}
