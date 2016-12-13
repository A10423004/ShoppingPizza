package client.model;

public interface Iterator {
	public abstract boolean hasNext();
	public abstract Item Next();
	public void remove();
}
