package it.eng.rd.hubcap.sandbox.request.model;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class JSONResponseDeserializer {

	public static JSONResponse deserialize(String jsonString) throws JSONException {
		JSONResponse ret = new JSONResponse();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);
		JSONArray data = jsonObject.getJSONArray("data");
		long total = jsonObject.getLong("total");
		boolean success = jsonObject.getBoolean("success");
		String errorMessage = jsonObject.getString("errorMessage");
		
		if(data != null) {
			ret.setData(jsonArrayToList(data));
			ret.setTotal(total);
			ret.setSuccess(success);
			ret.setErrorMessage(errorMessage);
		} else {
			System.err.println("Data is null!");
			System.err.println("Failed conversion of: "+jsonString);
			ret.setSuccess(false);
			ret.setErrorMessage("Data is null! Failed conversion of: "+jsonString);
		}
		return ret;
	}

	public static JSONResponse deserializeExt(String jsonString, String label) throws JSONException {
		JSONResponse ret = new JSONResponse();
		List<JSONObject> data = new ArrayList<JSONObject>();
		String initialCaracter = jsonString.substring(0,1);
		boolean success = false;
		String errorMessage = "";
		
		if (label.compareTo("")!=0)	
		{
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);
	    data = getNJSON(label, jsonObject);
		success = jsonObject.getBoolean("success");
		errorMessage = jsonObject.getString("errorMessage");
		
		}
		else if (label.compareTo("")==0 && initialCaracter.compareTo("[")==0)
		{
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
			data = getNJSONbyArray(jsonArray);
		    success = true;
		}
		else if (label.compareTo("")==0 && initialCaracter.compareTo("{")==0)
		{
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);
			data.add(jsonObject); 
		    success = true;
			errorMessage = jsonObject.getString("errorMessage");
		}
			
		if(data != null) {
			ret.setData(data);
			ret.setSuccess(success);
			ret.setErrorMessage(errorMessage);
		} else {
			System.err.println("Data is null!");
			System.err.println("Failed conversion of: "+jsonString);
			ret.setSuccess(false);
			ret.setErrorMessage("Data is null! Failed conversion of: "+jsonString);
		}
		return ret;
	}
	
	private static List<JSONObject> getNJSON(String root, JSONObject json){
    	List<JSONObject> ret = new ArrayList<JSONObject>();
		if(json.has(root)) {
	    	  if (json.getJSONArray(root)!=null){   
			      JSONArray array =json.getJSONArray(root);
			      for(int i=0; i<array.length(); i++) {
			    	  ret.add(array.getJSONObject(i));
			      }
	    	  }
	    	  else{
	    		  ret.add(json.getJSONObject(root)); 
	    	  }
		}
        return ret; 
	}
	
	private static List<JSONObject> getNJSONbyArray(JSONArray json){
    	List<JSONObject> ret = new ArrayList<JSONObject>();
        for(int i=0; i<json.length(); i++) {
    	  ret.add(json.getJSONObject(i));
        }
        return ret; 
	}
	
	public static List<JSONObject> jsonArrayToList(JSONArray data) {
		List<JSONObject> dataList = new ArrayList<JSONObject>();
		for(int i=0; i<data.length(); i++) {
			dataList.add(data.getJSONObject(i));
		}
		return dataList;
	}
}
