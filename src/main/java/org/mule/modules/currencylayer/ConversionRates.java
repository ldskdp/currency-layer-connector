package org.mule.modules.currencylayer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschem2pojo")
@JsonPropertyOrder({"success","terms","privacy","timestamp","source","quotes"})
public class ConversionRates {

		@JsonProperty("success")
		private Boolean success;
		@JsonProperty("terms")
		private String terms;
		@JsonProperty("privacy")
		private String privacy;
		@JsonProperty("timestamp")
		private Date timestamp;
		@JsonProperty("source")
		private String source;
		@JsonProperty("quotes")
		private Map<String,Integer> quotes = new HashMap<String, Integer>();
		
		public Boolean getSuccess() {
			return success;
		}
		
		public void setSuccess( Boolean success ) {
			this.success = success;
		}
		
		public String getTerms() {
			return terms;
		}
		
		public void setTerms( String terms ) {
			this.terms = terms;
		}
		
		public String getPrivacy() {
			return privacy;
		}
		
		public void setPrivacy( String privacy ) {
			this.privacy = privacy;
		}
		
		public Date getTimestamp() {
			return timestamp;
		}
		
		public void setTimestamp( Date timestamp ) {
			this.timestamp = timestamp;
		}
		
		public String getSource() {
			return source;
		}
		
		public void setSource( String source ) {
			this.source = source;
		}
		
		public Map<String, Integer> getQuotes() {
			return quotes;
		}
		
		public void setQuotes( Map<String, Integer> quotes ) {
			this.quotes = quotes;
		}
		
		
}
