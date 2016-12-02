package server.model;

import java.util.ArrayList;

import client.model.ShopItem;
import client.model.ShopList;

public interface Observer {
	public void update(ShopList shoplist);
}
