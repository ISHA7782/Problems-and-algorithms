import java.util.HashMap;
import java.util.Map;

public class ItineraryOfTickets {
	static void printItinerary(Map<String,String> InputData)
	{
		Map<String,String> ReverseDataSet = new HashMap<String,String>();
		for(Map.Entry<String,String> entry : InputData.entrySet())
		{
			ReverseDataSet.put(entry.getValue(), entry.getKey());
		}
		
		String startLocation = null;
		
		for(Map.Entry<String, String> entry : InputData.entrySet())
		{
			if(!ReverseDataSet.containsKey(entry.getKey()))
			{
				startLocation = entry.getKey();
				break;
			}
		}
		
		String dest = InputData.get(startLocation);
		while(dest != null)
		{
			System.out.print(startLocation +  " --> " + dest + " , " );
			startLocation = dest;
			dest = InputData.get(dest);
		}
		
	}
	public static void main(String args[])
	{
		Map<String,String> dataSetTickets = new HashMap<String,String>();
		dataSetTickets.put("Delhi","Goa");
		dataSetTickets.put("Mumbai","Pune");
		dataSetTickets.put("Pune", "Banglore");
		dataSetTickets.put("Goa", "Mumbai");
		dataSetTickets.put("Amritsar", "Delhi");
		
		printItinerary(dataSetTickets);
	}
	
}
