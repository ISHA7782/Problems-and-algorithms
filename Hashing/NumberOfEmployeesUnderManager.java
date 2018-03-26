import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfEmployeesUnderManager {
	
	 static Map<String,Integer> results = new HashMap<String, Integer>();
	public static void main(String args[])
	{
		Map<String,String> InputData = new HashMap<String,String>();
		InputData.put("A","C");
		InputData.put("B","C");
		InputData.put("C","F");
		InputData.put("D","E");
		InputData.put("E","F");
		InputData.put("F","F");
		
		getReportee(InputData);
		System.out.println(results);
	}
	static int printemployeesundermanager(String manager, Map<String, List<String>> EmpManagerHashMap)
	{
		int count = 0;
		
		if( !EmpManagerHashMap.containsKey(manager))
		{
			results.put(manager,0);
			return 0;
		}
		else
		{
			if( results.containsKey(manager))
				count  = results.get(manager);
			else
			{
				 List<String> directReportees = EmpManagerHashMap.get(manager);
		            count = directReportees.size();
		            for (String directReportEmp: directReportees)
		               count =  count + (printemployeesundermanager(directReportEmp ,EmpManagerHashMap));
		 
		            results.put(manager, count);
			}
			return count;
		}
		
	}
	static void getReportee(Map<String,String> InputData)
	{
		Map<String, List<String>> mngrEmpMap =  new HashMap<String, List<String>>();
		
		for(Map.Entry<String, String > entry : InputData.entrySet())
		{
			String employee  =  entry.getKey();
			String manager = entry.getValue();
			
			if (employee.equals(manager) == false)
			{
				List<String> employees_list = mngrEmpMap.get(manager);
				
				if (employees_list == null)
					employees_list = new ArrayList<String>();
				
				employees_list.add(employee);
				
				mngrEmpMap.put(manager, employees_list);

			}
		}
		for(String manager: InputData.keySet())
		{
			printemployeesundermanager(manager, mngrEmpMap);
		}
	}

}
