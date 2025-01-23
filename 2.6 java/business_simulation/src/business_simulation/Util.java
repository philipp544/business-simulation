package business_simulation;

public class Util {
	public static String convertWarenartToString(Warenart warenart) {
		return switch (warenart) {
		case BIER -> { 
			yield "Bier";
		}
		case WEIN -> {
			yield "Wein";
		}
		case KORN -> {
			yield "Korn";
		}
		case GLAS -> {
			yield "Glas";
		}
		case TUCH -> {
			yield "Tuch";
		}
		case GOLD -> {
			yield "Gold";
		}
	};
	}
}
