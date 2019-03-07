package main;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import com.protobuftest.protobuf.PersonResponse;
import com.protobuftest.protobuf.PersonResponse.PhoneType;
import com.protobuftest.protobuf.PersonServiceGrpc;


public class PersonSever extends PersonServiceGrpc.PersonServiceImplBase {
	
	@Override
    public void get(com.protobuftest.protobuf.PersonRequest request,
            io.grpc.stub.StreamObserver<com.protobuftest.protobuf.PersonResponse> responseObserver) {
		
		PersonResponse  respone = PersonResponse.newBuilder().setName(request.getName()).setId(request.getId())
				.setEmail("123@11.com")
				.addPhone(0, PersonResponse.PhoneNumber.newBuilder().setNumber("123").setType(PhoneType.HOME)).build();
		
		responseObserver.onNext(respone);
		responseObserver.onCompleted();
          
        }
}
