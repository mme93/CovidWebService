package hrw.verteilteSysteme.CovidWebService.SOAP;

import generated.GetCovidRequest;
import generated.GetCovidResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CovidSoapEndpoint {
    private static final String NAMESPACE_URI = "http://innova.com/models/soap/emp";

    private CovidSoapRepository covidSoapRepository;

    @Autowired
    public CovidSoapEndpoint(CovidSoapRepository covidSoapRepository) {
        this.covidSoapRepository = covidSoapRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCovidRequest")
    @ResponsePayload
    public GetCovidResponse getCovid(@RequestPayload GetCovidRequest request) {
        GetCovidResponse response = new GetCovidResponse();
        response.setCovid(covidSoapRepository.findCovid(request.getNDays(), request.getInfo(), request.getRValue()));
        return response;
    }
}

