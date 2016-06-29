package org.mule.modules.currencylayer;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.display.FriendlyName;
import org.mule.api.annotations.lifecycle.Start;

@Connector( name = "currency-layer", friendlyName = "CurrencyLayer", minMuleVersion = "3.5.0" )
public class CurrencyLayerConnector {

	@Config
	CurrencyLayerConfig currencyLayerConfig;
	
	private CurrencyLayerClient currencyLayerClient;
	
  @Start
  public void init() {
      setCurrencyLayerClient(new CurrencyLayerClient(this));
  }
	//////////////////////////////////////////////////////////////

	/**
	 * This endpoint requests the most recent exchange rate
	 * 
	 * @param access_key = your access key
	 * @param source = source currency
	 * @param currencies = optional csv list of currency codes you wish to compare
	 *          USA,AUD,CAD,PLN,MXN
	 * @param format = optional format number 1
	 * @return conversion rates for the requested currencies
	 * @throws CurrencyLayerConnectorException
	 */

	@Processor( friendlyName = "Conversion Rates" )
	public ConversionRates getConversionRates( @FriendlyName( "Source" ) String source ) throws CurrencyLayerConnectorException {
		return getCurrencyLayerClient().getConversionRates( source );
	}

	public CurrencyLayerConfig getCurrencyLayerConfig() {
		return currencyLayerConfig;
	}

	public void setCurrencyLayerConfig( CurrencyLayerConfig config ) {
		this.currencyLayerConfig = config;
	}

	public CurrencyLayerClient getCurrencyLayerClient() {
		return currencyLayerClient;
	}

	public void setCurrencyLayerClient( CurrencyLayerClient currencyLayerClient ) {
		this.currencyLayerClient = currencyLayerClient;
	}
}