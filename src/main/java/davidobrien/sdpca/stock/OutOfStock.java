package davidobrien.sdpca.stock;

public class OutOfStock implements State{

	public boolean stateOfStock() {
		return false;
	}

}