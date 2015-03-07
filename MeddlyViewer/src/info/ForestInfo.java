package info;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import org.json.simple.JSONObject;

/**
 * Forest Information Class used to build and update chart series information for visualizer
 * @author Coleman
 */
public class ForestInfo {
	
	private Long forestDepth;
	private String forestName;
	private Long left;
	private Long right;
	private Long id;
	private Series series;
	
	
	/**
	 * 
	 * @param forestRules
	 *  A JSON object in the form of { "forest_id": 1, "name": "forest name", "left": 1, "right": 25, "an": [0, 0] }
	 */
	public ForestInfo(JSONObject forestRules) {

		forestDepth = (Long) forestRules.get("right");
		forestName = (String) forestRules.get("name");
		id = (Long) forestRules.get("forest_id");
		left = (Long) forestRules.get("left");
		series = this.setSeries(forestDepth);
		

	}

	/**
	 * 
	 * @param newForestDepth
	 */
	public void setForestDepth(Long newForestDepth) {
		this.forestDepth = newForestDepth;
	}

	/**
	 * 
	 * @param newForestName
	 */
	public void setForestName(String newForestName) {
		this.forestName = newForestName;
	}

	/**
	 * 
	 * @param left
	 */
	public void setLeftMostNode(Long left) {
		this.left = left;
	}

	/**
	 * 
	 * @param right
	 */
	public void setRightMostNode(Long right) {
		this.right = right;
	}

	/**
	 * 
	 * @param id
	 */
	public void setForestID(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public Long getForestDepth() {
		return forestDepth;
	}

	/**
	 * 
	 * @return
	 */
	public String getForestName() {
		return forestName;
	}

	/**
	 * 
	 * @return
	 */
	public Long getRightCount() {
		return right;
	}

	/**
	 * 
	 * @return
	 */
	public Long getLeftCount() {
		return left;
	}

	/**
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param numberOfInitialNodes
	 * @return
	 */
	public Series setSeries(Long numberOfInitialNodes){
		
		XYChart.Series series = new XYChart.Series();
		series.setName(this.getForestName());		
		for(int i = 0; i < numberOfInitialNodes; i++){
			series.getData().add(new XYChart.Data(1, "" + i));
		}
		
		return series;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Series getSeries(){
		return series;
	}

}
