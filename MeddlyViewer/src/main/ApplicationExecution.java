package main;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.ForestInfoParser;

public class ApplicationExecution extends Application {
	ForestInfoParser parser = new ForestInfoParser();
	final static String itemA = "A";
	final static String itemB = "B";
	final static String itemC = "F";

	@Override
	public void start(Stage stage) {
		final NumberAxis xAxis = new NumberAxis();
		final CategoryAxis yAxis = new CategoryAxis();
		final BarChart<Number, String> bc = new BarChart<Number, String>(xAxis,
				yAxis);
		bc.setTitle("Summary");
		xAxis.setLabel("Number of nodes");
		xAxis.setTickLabelRotation(90);
		yAxis.setLabel("Forest Level");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("This could work....");

		for (int i = 0; i < 5000; i++)
			series1.getData().add(new XYChart.Data(2, "" + i));

		Timeline tl = new Timeline();
		tl.getKeyFrames().add(
				new KeyFrame(Duration.millis(500),
						new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent actionEvent) {
								XYChart.Series<Number, String> series = bc
										.getData().get(0);
								for (XYChart.Data<Number, String> data : series
										.getData()) {
									data.setXValue(Math.random() * 1000);
								}

							}
						}));
		tl.setCycleCount(Animation.INDEFINITE);
		tl.play();

		Scene scene = new Scene(bc, 800, 600);
		bc.getData().addAll(series1);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args)
			throws org.json.simple.parser.ParseException {
		ForestInfoParser applicationInfoParser = new ForestInfoParser();
		applicationInfoParser.readJsonFile();

		launch(args);

	}

}
