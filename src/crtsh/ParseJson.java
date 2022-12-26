package crtsh;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJson {

	public void toJson(String responsebody) throws Exception {

		JSONArray jsonArray = new JSONArray(responsebody);
		Set<String> nameValuesSet = new HashSet<>();
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String nameValue = jsonObject.getString("name_value");
			String[] nameValues = nameValue.split("\n");
			for (String value : nameValues) {
				nameValuesSet.add(value);
			}

		}
		for (String nameValue : nameValuesSet) {
			if (!nameValue.startsWith("*")) {
				System.out.println(nameValue);

			}

		}

	}
}