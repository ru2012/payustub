package co.za.payu.stub.payustub;

import com.payjar.web.controller.api.soap.SetTransaction;
import com.payjar.web.controller.api.soap.SetTransactionResponse;
import https.www_payu_co_za.settransactionresponsemessage.SetTransactionResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SetTransactionEndpoint {

    private static final String NAMESPACE_URI = "http://soap.api.controller.web.payjar.com/";

    @Autowired
    public SetTransactionEndpoint() {
    }

    @PayloadRoot(localPart = "setTransaction", namespace = NAMESPACE_URI)
    @ResponsePayload
    public SetTransactionResponse setTransaction(@RequestPayload SetTransaction setTransaction) {

        SetTransactionResponse response = new SetTransactionResponse();
        SetTransactionResponseMessage message = new SetTransactionResponseMessage();
        message.setDisplayMessage("hey hey " + setTransaction.getApi());
        response.setReturn(message);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "setTransactionRequest")
    @ResponsePayload
    public SetTransactionResponse setTransactionRequest(@RequestPayload SetTransaction request) {

        SetTransactionResponse response = new SetTransactionResponse();
        SetTransactionResponseMessage message = new SetTransactionResponseMessage();
        message.setDisplayMessage("hey hey " + request.getApi());
        response.setReturn(message);

        return response;
    }
}
