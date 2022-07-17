package fastag;

import java.util.Scanner;

public class TollPlaza {
	
	public static int fasTagListIndex;
	
	public static boolean isfastagMatch(int fastagId, String licencePlateId) {
		
		boolean isMatched = false;
		
		for(Fastag tag: VehicleDatabase.fastags) {
			if( (tag.getFastagId() == fastagId) && (tag.getVehicle().getLicencePlateId().toLowerCase().equals(licencePlateId.toLowerCase())) ) {
				isMatched = true;
				fasTagListIndex = VehicleDatabase.fastags.indexOf(tag);
				break;
			}
		}
		return isMatched;	
	}

	
	public static void main(String[] args) throws InsuffcientFundsException {
		
		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		System.out.println("====================Welcome To TollPlaza=================");
		
		
		//Loop goes till the user enters valid id
		while(true){
			System.out.print("Enter FasTag ID: ");
			int fastagId = sc.nextInt();
			
			System.out.print("Enter Licence Plate ID: ");
			
			String licencePlateId = sc.next();
			
			if(isfastagMatch(fastagId, licencePlateId)) {
				System.out.println("fastag matched");
				break;
			}
			else {
				System.out.println("Your entered fastag id or licence plate id is not matching with our database.\nTry Again!");
			}
		}
		
		boolean isUserPrompted = false;
		String wantToRecharge;
		
		while(true) {
		
			if(!isUserPrompted) {
				System.out.print("Do you want to recharge your Fastag? ");
				wantToRecharge = sc.next().toLowerCase();
			}
			else {
				wantToRecharge = "yes";
			}
			
			if(wantToRecharge.equals("yes")) {
				
				System.out.print("How much amount you want to add to your FastTag balance? ");
				int amountToBeRecharged = sc.nextInt();
				
				System.out.print("Card or UPI? ");
				String paymentMethod = sc.next().toLowerCase();
				
				if(paymentMethod.equals("card")) {
					
					while(true) {
						
						System.out.print("Please enter your debit card number: ");
						String cardNumber = sc.next();
						String msgFromValidationCard = PaymentValidator.debitCardValidator(cardNumber);
						
						if(msgFromValidationCard.equals("valid")) {
							
							if(cardNumber.equals(VehicleDatabase.fastags.get(fasTagListIndex).getBankAccount().getDebitCardNumber())) {
								
								String msgFromRechargeFastag = RechargeFastag.rechargefastag(VehicleDatabase.fastags.get(fasTagListIndex), amountToBeRecharged);
								System.out.println(msgFromRechargeFastag);
								isUserPrompted = false;
								break;
							}
							else {
								System.out.println("Your card number is not matching with your linked bank account.Try again!\n");
								continue;
							}
			
						}
						else {
							System.out.println(msgFromValidationCard);
							continue;
						}
					
					}
					
				}
				else if(paymentMethod.equals("upi")) {
					
					while(true) {
						
						System.out.print("Please enter your UPI ID: ");
						String upiId = sc.next();
						String msgFromValidationUpi = PaymentValidator.upiValidator(upiId);
						
						if(msgFromValidationUpi.equals("valid")) {
							
							if(upiId.equals(VehicleDatabase.fastags.get(fasTagListIndex).getBankAccount().getUpiId())) {
								
								String msgFromRechargeFastag = RechargeFastag.rechargefastag(VehicleDatabase.fastags.get(fasTagListIndex), amountToBeRecharged);
								System.out.println(msgFromRechargeFastag);
								isUserPrompted = false;
								break;
							}
							else {
								System.out.println("Your upiId is not matching with your linked bank account.Try again!\n");
								continue;
							}
			
						}
						else {
							System.out.println(msgFromValidationUpi);
							continue;
						}
					}		
				}	
			}
			else if(wantToRecharge.equals("no")) {
				
				if(FastagMinBalance.hasMinimumBalance(VehicleDatabase.fastags.get(fasTagListIndex))) {
					
					System.out.println(TollPrice.chargeToll(VehicleDatabase.fastags.get(fasTagListIndex)));
					break;
				}
				
				else {
					System.out.println("Currunt balance is : " + VehicleDatabase.fastags.get(fasTagListIndex).getFastagBalance());
					System.out.println("Minimum Required balance is : " + FastagMinBalance.getMinBalance(VehicleDatabase.fastags.get(fasTagListIndex)));
					System.out.println("Your FasTag not have minimum balance. please recharge your fastag.\n");
					isUserPrompted = true;
					continue;
					
				}
					
			}
		
		}
		
		sc.close();

	}
}
