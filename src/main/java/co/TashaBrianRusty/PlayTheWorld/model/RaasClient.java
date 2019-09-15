package co.TashaBrianRusty.PlayTheWorld.model;

import com.tangocard.raas.Configuration;
import com.tangocard.raas.controllers.AccountsController;
import com.tangocard.raas.controllers.BaseController;
import com.tangocard.raas.controllers.CatalogController;
import com.tangocard.raas.controllers.CustomersController;
import com.tangocard.raas.controllers.ExchangeRatesController;
import com.tangocard.raas.controllers.FundController;
import com.tangocard.raas.controllers.OrdersController;
import com.tangocard.raas.controllers.StatusController;
import com.tangocard.raas.http.client.HttpClient;

public class RaasClient {
	 public StatusController getStatus() {
	        return StatusController.getInstance();
	    }

	    /**
	     * Singleton access to Accounts controller
	     * @return	Returns the AccountsController instance 
	     */
	    public AccountsController getAccounts() {
	        return AccountsController.getInstance();
	    }

	    /**
	     * Singleton access to Fund controller
	     * @return	Returns the FundController instance 
	     */
	    public FundController getFund() {
	        return FundController.getInstance();
	    }

	    /**
	     * Singleton access to ExchangeRates controller
	     * @return	Returns the ExchangeRatesController instance 
	     */
	    public ExchangeRatesController getExchangeRates() {
	        return ExchangeRatesController.getInstance();
	    }

	    /**
	     * Singleton access to Orders controller
	     * @return	Returns the OrdersController instance 
	     */
	    public OrdersController getOrders() {
	        return OrdersController.getInstance();
	    }

	    /**
	     * Singleton access to Customers controller
	     * @return	Returns the CustomersController instance 
	     */
	    public CustomersController getCustomers() {
	        return CustomersController.getInstance();
	    }

	    /**
	     * Singleton access to Catalog controller
	     * @return	Returns the CatalogController instance 
	     */
	    public CatalogController getCatalog() {
	        return CatalogController.getInstance();
	    }

	    /**
	     * Get the shared http client currently being used for API calls
	     * @return The http client instance currently being used
	     */
	    public HttpClient getSharedHttpClient() {
	        return BaseController.getClientInstance();
	    }
	    
	    /**
	     * Set a shared http client to be used for API calls
	     * @param httpClient The http client to use
	     */
	    public void setSharedHttpClient(HttpClient httpClient) {
	        BaseController.setClientInstance(httpClient);
	    }

	    /**
	     * Default constructor 
	     */     
	    public RaasClient() {
	        Configuration.platformName = "QAPlatform2";
	        Configuration.platformKey = "apYPfT6HNONpDRUj3CLGWYt7gvIHONpDRUYPfT6Hj";
	    }

	    /**
	     * Client initialization constructor 
	     */     
	    public RaasClient(String platformName, String platformKey) {
	        this();
	        if(platformName != null) Configuration.platformName = platformName;
	        if(platformKey != null) Configuration.platformKey = platformKey;
	    }

		@Override
		public String toString() {
			return "RaasClient [getStatus()=" + getStatus() + ", getAccounts()=" + getAccounts() + ", getFund()="
					+ getFund() + ", getExchangeRates()=" + getExchangeRates() + ", getOrders()=" + getOrders()
					+ ", getCustomers()=" + getCustomers() + ", getCatalog()=" + getCatalog()
					+ ", getSharedHttpClient()=" + getSharedHttpClient() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
	    
	    
}
