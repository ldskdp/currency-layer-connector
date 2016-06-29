package org.mule.modules.currencylayer;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class CurrencyLayerClient {

	private Client client;
	private WebResource apiResource;
	private String URL = "http://apilayer.net/api/";
	private CurrencyLayerConnector connector;

	public CurrencyLayerClient( CurrencyLayerConnector currencyLayerConnector ) {
		setConnector( currencyLayerConnector );

		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put( JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE );
		this.setClient( Client.create( clientConfig ) );
		this.setApiResource( this.client.resource( URL ) );
	}

	/**
	 * Returns live conversion rates for specified source
	 * 
	 * @param source
	 * @return
	 */
	public ConversionRates getConversionRates( String source ) throws CurrencyLayerConnectorException {
		WebResource webResource = getApiResource().path( "live").queryParam( "access_key", getConnector().getCurrencyLayerConfig().getAccessKey() );
		return execute( webResource, "GET", ConversionRates.class );
	}

	private <T> T execute( WebResource webResource, String method, Class<T> returnClass ) throws CurrencyLayerConnectorException {
		ClientResponse clientResponse = webResource.accept( MediaType.APPLICATION_JSON ).method( method, ClientResponse.class );
		if( clientResponse.getStatus() == 200 ) {
			return clientResponse.getEntity( returnClass );
		} else {
			throw new CurrencyLayerConnectorException(
					String.format( "ERROR - statusCode: %d - message: %s",
							clientResponse.getStatus(), clientResponse.getEntity( String.class ) ) );
		}
	}

	public void setConnector( CurrencyLayerConnector connector ) {
		this.connector = connector;
	}

	public CurrencyLayerConnector getConnector() {
		return connector;
	}

	public Client getClient() {
		return client;
	}

	public void setClient( Client client ) {
		this.client = client;
	}

	public WebResource getApiResource() {
		return apiResource;
	}

	public void setApiResource( WebResource apiResource ) {
		this.apiResource = apiResource;
	}
}
