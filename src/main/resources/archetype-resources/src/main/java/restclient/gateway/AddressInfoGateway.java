#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.restclient.gateway;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import ${package}.restclient.model.AddressInfo;

@Repository
public class AddressInfoGateway {

	private Logger logger = Logger.getLogger(AddressInfoGateway.class);
	
    public AddressInfo findAddressInfoByCEP(String cep) {
    	AddressInfo addressInfo = new AddressInfo();
        try {
            String url = "http://cep.desenvolvefacil.com.br/BuscarCep.php?cep=" + cep + "&ret=xml";
            HttpClient client = new DefaultHttpClient();
            HttpGet method = new HttpGet(url);
            HttpResponse httpResponse = client.execute(method);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                InputStream inputStream = httpResponse.getEntity().getContent();
                addressInfo = parserXMLToObject(inputStream);
            }
        } catch (Exception e) {
        	logger.fatal(e);
        }
		return addressInfo;
    }
    
    private AddressInfo parserXMLToObject(InputStream inputStream) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(AddressInfo.class);
        AddressInfo addressInfo = (AddressInfo) xStream.fromXML(inputStream);
        System.out.println(addressInfo.getCity().toUpperCase() + " - " + addressInfo.getStreet().toUpperCase());
        return addressInfo;
    }
}
