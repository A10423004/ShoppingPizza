package client.model;

public class CashOnDeliveryPrice implements Strategy{
	
	@Override
	public double getTransportPrice() {
		return 60.0;
	}
}
