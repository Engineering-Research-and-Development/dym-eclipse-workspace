package it.eng.rd.hubcap.sandbox.request.model;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import it.eng.rd.hubcap.sandbox.request.model.ObjectSerializer;

@JSON 
public class JSONResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<JSONObject> data = new ArrayList<JSONObject>();
	private long total = -1;
	private boolean success = true;
	private String errorMessage = "";
	private String message = "";
	private String stackTrace = "";

	@JSON(include=true)
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@JSON(include=true)
	public List<JSONObject> getData() {
		return data;
	}
	
	@JSON(include=true)
	public JSONObject getData(int index) throws JSONException{
		try{
		return data.get(index);
		}
		catch(IndexOutOfBoundsException e)
		{
			throw new JSONException(e.getMessage());
		}
		
	}
	
	public void setData(JSONArray dataArray) {
		List<JSONObject> dataLocal = new ArrayList<JSONObject>();
		for(int i=0; i<dataArray.length(); i++) {
			dataLocal.add(dataArray.getJSONObject(i));
		}
		this.setData(dataLocal);
	}

	public void setData(List<JSONObject> list) {
		this.data = list;
		this.total = list.size();
	}

	public void setData(JSONObject data)
	{
		this.data.clear();
		addData(data);
	}
	public void addData(JSONObject data) {
		this.data.add(data);
		this.total = this.data.size(); 
	}
	 

	public void addData(List<String> data) throws JSONException
	{
		JSONObject stringJson;
		List<JSONObject> dataLocal = new ArrayList<JSONObject>();
		for (String string : data) {
			stringJson=JSONFactoryUtil.createJSONObject("{\"value\":\""+string+"\"}");
			dataLocal.add(stringJson);
		}
		this.setData(dataLocal);
	}
	
	public void addData(String data) throws JSONException {
		this.addData(JSONFactoryUtil.createJSONObject("{\"value\":\""+data+"\"}"));
		this.total = this.data.size(); 
	}

	public void addData(String key, String value) throws JSONException {
		this.addData(JSONFactoryUtil.createJSONObject("{\""+key+"\":\""+value+"\"}"));
		this.total = this.data.size(); 
	}
	
	public void setDataTotal(List<JSONObject> list,long total) {
		this.data = list;
		this.total = total;
	}
	
	@JSON(include=true)
	public long getTotal() {
		return total;
	}
	
	public void setTotal(long total) {
		this.total = total;
	}
	
	@JSON(include=true)
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@JSON(include=true)
	public String getStackTrace() {
		return stackTrace;
	}
	
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public static JSONObject errorResponse() throws JSONException {
		List<JSONObject> data = new ArrayList<JSONObject>();
		JSONResponse resp = new JSONResponse();
		resp.setData(data);
		resp.setSuccess(false);
		resp.setTotal(0);
		return ObjectSerializer.serializeObject(resp);
	}

	public static JSONResponse errorResponse(String errorMessage) /*throws JSONException*/ {
		List<JSONObject> data = new ArrayList<JSONObject>();
		JSONResponse resp = new JSONResponse();
		resp.setData(data);
		resp.setSuccess(false);
		resp.setTotal(0);
		resp.setErrorMessage(errorMessage);
		return resp;
	}

	public static JSONResponse errorResponse(Throwable t)  {
		
		List<JSONObject> data = new ArrayList<JSONObject>();
		JSONResponse resp = new JSONResponse();
		resp.setData(data);
		resp.setSuccess(false);
		resp.setTotal(0);
		resp.setErrorMessage(t.getMessage());
		
		// Add Stack Trace
		StringWriter sw = new StringWriter();
	    t.printStackTrace(new PrintWriter(sw));
	    resp.setStackTrace(sw.toString());
	    
		return resp;
	}
	
	/********************************************************************************
	 * Serialize JSONResponse to JSONObject
	 * 
	 * @return The JSONObject representation of the object
	 */
	public JSONObject toJSONObject() {
		JSONObject ret = JSONFactoryUtil.createJSONObject();
		
		JSONArray dataArray = JSONFactoryUtil.createJSONArray();
		if(data != null) {
			for(JSONObject item: data) {
				dataArray.put(item);
			}
		}
		
		ret.put("data", dataArray);
		ret.put("total", total);
		ret.put("success", success);
		ret.put("errorMessage", errorMessage); 
		ret.put("message", message);
		ret.put("stackTrace", stackTrace);
		return ret;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
