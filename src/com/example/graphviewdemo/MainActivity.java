package com.example.graphviewdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

public class MainActivity extends Activity {

	private LineGraphView mGraphView;

	private LinearLayout mLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLayout = (LinearLayout) findViewById(R.id.graph_layout);

		mGraphView = new LineGraphView(this, "aa");
		mGraphView
				.setHorizontalLabels(new String[] { "1", "2", "3", "4", "5" });
		mGraphView.setVerticalLabels(new String[] { "5", "", "4", "", "3", "",
				"2", "", "1" });

		mGraphView.getGraphViewStyle().setGridColor(Color.GREEN);
		mGraphView.getGraphViewStyle().setHorizontalLabelsColor(Color.YELLOW);
		mGraphView.getGraphViewStyle().setVerticalLabelsColor(Color.RED);
		mGraphView.getGraphViewStyle().setTextSize(28);
		mGraphView.getGraphViewStyle().setNumHorizontalLabels(5);
		mGraphView.getGraphViewStyle().setNumVerticalLabels(4);
		mGraphView.getGraphViewStyle().setVerticalLabelsWidth(30);
		mGraphView.setBackgroundColor(Color.parseColor("#aaff00ff"));
		mGraphView.setDrawBackground(true);
		mGraphView.setDrawDataPoints(true);

		GraphViewData[] data = new GraphViewData[5];
		data[0] = new GraphViewData(0, 2);
		data[1] = new GraphViewData(1, 5);
		data[2] = new GraphViewData(2, 3);
		data[3] = new GraphViewData(3, 1);
		data[4] = new GraphViewData(4, 4);
		mGraphView.addSeries(new GraphViewSeries(data));

		// mGraphView.setViewPort(2, 40);
		mLayout.addView(mGraphView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
