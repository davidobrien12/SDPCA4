package davidobrien.sdpca.card;

import davidobrien.sdpca.controller.AppController;

public class MasterCard extends AbstractValidator{
	
	public MasterCard(AppController app, String cardName, String LongCardNum, int expiryDateMonth,
			int expiryDateYear, String cvv) {

		super(app, cardName, LongCardNum, expiryDateMonth, expiryDateYear, cvv);
	}
	
	

	protected boolean validateLongCardNumFormat() {


		boolean FormatError = false;
		
		if (LongCardNum.charAt(0) == '2' && (LongCardNum.charAt(1) >= '1' && LongCardNum.charAt(1) <= '9')) {
								
		}
		else {
				
			FormatError = true;									
											
		}
		
		return !FormatError;
			
	}

}
