package com.kingdee;



import org.junit.Test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {
	
	@Test
	public void  testJson() {
		
		String jsonStr="{\"workflowid\":22,\"workflowName\":\"员工入职流程\",\"staffEntries\":[{\"staffName\":\"张三\",\"staffAge\":8},{\"staffName\":\"李四\",\"staffAge\":9}]}";
		
		System.out.println(jsonStr);
		
		
	   JSONObject jsonObject = JSONObject.fromObject(jsonStr);
	   
	   //Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(jsonObject, Map.class);
	   //String workflowid=map.get("workflowid").toString();
	   //String workflowName=map.get("workflowName").toString();
	   //ArrayList staffEntries=(ArrayList) map.get("staffEntries");
	   
	   String workflowid=jsonObject.getString("workflowid");
	   String workflowName=jsonObject.getString("workflowName");
	   JSONArray staffEntriesArray=jsonObject.getJSONArray("staffEntries");
	   JSONObject firstEntry=staffEntriesArray.getJSONObject(0);
	   String staffName=firstEntry.getString("staffName");

	   System.out.println("workflowid="+workflowid+",workflowName="+workflowName+",staffEntries"+firstEntry.toString()+",staffName="+staffName);
		
	}

}
