package business_simulation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Lager {

	private String ort;
	private HashMap<Warenart, Integer> lagerbestand = new HashMap<Warenart, Integer>();

	public Lager(String ort) {
		this.ort=ort;
	}
	
	
	public void einlagern(Warenart warenart, int mengeEinlagern) {
		if(lagerbestand.containsKey(warenart)) {
			
			int bisherigerBestand = lagerbestand.get(warenart).intValue();
			int neuerBestand = bisherigerBestand+mengeEinlagern;
			lagerbestand.put(warenart, neuerBestand);
		} else {
		
			lagerbestand.put(warenart, mengeEinlagern);
		}
	}
	
	public int verkaufen(Warenart warenart, int mengeVerkaufen, int preis) {
		if(lagerbestand.containsKey(warenart)) {
			if(lagerbestand.get(warenart)>=mengeVerkaufen) {
				int bisherigerBestand = lagerbestand.get(warenart).intValue();
				int neuerBestand = bisherigerBestand-mengeVerkaufen;
				lagerbestand.put(warenart, neuerBestand);
				return mengeVerkaufen*preis; 
			} else if(lagerbestand.get(warenart)>0) {
				int bisherigerBestand = lagerbestand.get(warenart).intValue();
				lagerbestand.remove(warenart);
				return bisherigerBestand*preis;
			} 
		} 
		return 0;
	}
	
	public Set<Warenart> getEingelagerteWaren() {
		return lagerbestand.keySet();
	}
	
	public int getBestand(Warenart warenart) {
		if(lagerbestand.containsKey(warenart)) {
			return lagerbestand.get(warenart).intValue();
		} else {
			return -1;
		}
	}
	public void printBestand() {
	    for (Map.Entry<Warenart, Integer> eintrag : lagerbestand.entrySet()) {
	        System.out.println(Util.convertWarenartToString(eintrag.getKey()) + ": " + eintrag.getValue());
	    }
	}
}
