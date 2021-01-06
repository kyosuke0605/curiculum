package check;

import constants.Constants;
//フィールド変数
public class Check{
	private static String firstName = "京介" ;
	private static String lastName ="大島";
//変数を連結したprintNameメソッド
	private static String printName(String lastName, String firstName) {
		return lastName + firstName;

	}
	
public static void main(String[] args) {
	System.out.println("printName → " + lastName+firstName);	
	
	Pet pet = new Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HOGE);
	pet.introduce();
	
	RobotPet robo = new RobotPet(Constants.CHECK_CLASS_R2D2,Constants.CHECK_CLASS_LUKE);
	robo.introduce();
	}

}


