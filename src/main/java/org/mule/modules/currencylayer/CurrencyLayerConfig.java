package org.mule.modules.currencylayer;

import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.components.Configuration;

@Configuration( configElementName = "config-type", friendlyName = "Access Key Configuration" )
public class CurrencyLayerConfig {

	CurrencyLayerClient client;

	@Configurable
	String accessKey;

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey( String accessKey ) {
		this.accessKey = accessKey;
	}
}