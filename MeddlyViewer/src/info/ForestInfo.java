package info;

import org.json.simple.JSONObject;

public class ForestInfo {
	private int forestDepth;
	private String forestName;
	private int left;
	private int right;
	private int id;

	public ForestInfo(JSONObject forestRules) {
		
		forestDepth = (int) forestRules.get("right");
		forestName = (String) forestRules.get("name");
		id = (int) forestRules.get("id");
		left = (int) forestRules.get("left");
		
	}
	
	public int getForestDepth(){
		return forestDepth;
	}
	
	public String getForestName(){
		return forestName;
	}
	
	public int getRightCount(){
		return right;
	}
	
	public int getLeftCount(){
		return left;
	}
	
	public int getId(){
		return id;
	}	

}