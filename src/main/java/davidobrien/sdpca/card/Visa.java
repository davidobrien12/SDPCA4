package davidobrien.sdpca.card;

import davidobrien.sdpca.controller.AppController;

public class Visa extends AbstractValidator{
	

	public Visa(AppController app, String cardName, String LongCardNum, int expiryDateMonth,
			int expiryDateYear, String cvv) {

		super(app, cardName, LongCardNum, expiryDateMonth, expiryDateYear, cvv);

	}



	protected boolean validateLongCardNumFormat() {



		boolean FormatError = false;

		if (LongCardNum.charAt(0) != '7') {

			FormatError = true;									

		}
		else {


		}

		return !FormatError;

	}

}
