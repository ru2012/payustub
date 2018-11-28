package co.za.payu.stub.payustub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayustubApplication {

	//https://spring.io/guides/gs/producing-web-service/
	//http://www.springboottutorial.com/creating-soap-web-service-with-spring-boot-web-services-starter


	//https://jbossadventure.wordpress.com/2013/04/16/spring-ws-no-adapter-for-endpoint/
	//spring-ws calls getEndpointAdapter() from org.springframework.ws.server.MessageDispatcher


	//http://localhost:8080/ws/enterpriseAPISoapService.wsdl
	//   /home/rudi/dev/payustub/src/test/resources/testSetTransaction.xml
	// curl --header "content-type: text/xml" -d @/home/rudi/dev/payustub/src/test/resources/testSetTransaction.xml http://localhost:8080/ws
	public static void main(String[] args) {
		SpringApplication.run(PayustubApplication.class, args);
	}
}
