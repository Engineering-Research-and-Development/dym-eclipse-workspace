package it.eng.rd.hubcap.sandbox.request.model;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializer;

public class ObjectSerializer {
	public static JSONObject serializeObject(Object obj) throws JSONException {
		JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
		jsonSerializer.exclude("class");
		return JSONFactoryUtil.createJSONObject(jsonSerializer.serialize(obj));
	}
}
