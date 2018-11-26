package json;

import java.util.Map;

import net.sf.json.JSONObject;

public class JSONTest {
	public static void main(String[] args) {
		// Map<String, String> map = new HashMap<>();
		// map.put("backCustomId", "000016142880981231903744");
		// System.out.println(JSONObject.fromObject(map).toString());

		Map<String, Object> m = JSONObject.fromObject("{\"backCustomId\":\"000016142880981231903744\"}");
		System.out.println(m.get("backCustomId"));
		String backCustomId = m.get("backCustomId").toString();
		System.out.println(backCustomId);

	}
}
