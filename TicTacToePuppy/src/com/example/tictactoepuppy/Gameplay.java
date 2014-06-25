package com.example.tictactoepuppy;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import java.util.Random;


public class Gameplay extends ActionBarActivity {

	private int place;
	private boolean userTurn = false;
	private boolean start = true;
	private int grid[][];
	private Random rand;
	private int placing;
	private ImageView image;
	private int turn;
	private int diffLevel;
	private int[] used = new int[10];

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gameplay);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
//		int k = 0;
//		// fill grid
//		for (int i = 0; i < 3; i++) {
//			for (int j =0; j < 3; j++) {
//				grid[i][j] = k;
//				k++;				
//			}
//		}
		for (int l = 0; l < 10; l++) {
			used[l] = 0;
		}
		//rand = new Random();
		//turn = rand.nextInt(1) + 1;
		Intent intent = getIntent();
        diffLevel  = intent.getIntExtra("diffLevel", 2);
		playGame();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gameplay, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_gameplay,
			container, false);
			return rootView;
		}
	}
	
	public void playGame() {
		if (start == true) { //&& turn == 1 ) {
			userTurn = true;
			start = false;
		}
		else {
			userTurn = false;
			start = false;
			switch (diffLevel) {
				case 1:
					compEasy();
				case 2:
					compMedium();
				case 3:
					compHard();		
				default:
					break;
			}
		}
	}
	
	public void compEasy() {
		placing = rand.nextInt(8);
		while (used[placing] != 0) {
			placing = rand.nextInt(8);
		}
		compPlace();
	}
	
	public void compMedium() {
		
	}
	
	public void compHard() {
		
	}
	
	public void compPlace() {
		switch (placing) {
		case 0:
			image = (ImageView)findViewById(R.id.x0);
			image.setVisibility(0);
			break;
		case 1:
			image = (ImageView)findViewById(R.id.x1);
			image.setVisibility(0);
			break;
		case 2:
			image = (ImageView)findViewById(R.id.x2);
			image.setVisibility(0);
			break;
		case 3:
			image = (ImageView)findViewById(R.id.x3);
			image.setVisibility(0);
			break;
		case 4:
			image = (ImageView)findViewById(R.id.x4);
			image.setVisibility(0);
			break;
		case 5:
			image = (ImageView)findViewById(R.id.x5);
			image.setVisibility(0);
			break;
		case 6:
			image = (ImageView)findViewById(R.id.x6);
			image.setVisibility(0);
			break;
		case 7:
			image = (ImageView)findViewById(R.id.x7);
			image.setVisibility(0);
			break;
		case 8:
			image = (ImageView)findViewById(R.id.x8);
			image.setVisibility(0);
			break;
		}
		used[placing] = 2;
		//check for win
		userTurn = true;
	}
	
	public void clickPlace(View view) {
		if (userTurn == true) {
			switch (view.getId()) {
				case R.id.place0:
					place = 0;
					image = (ImageView)findViewById(R.id.o0);
					image.setVisibility(0);
					break;
				case R.id.place1:
					place = 1;
					image = (ImageView)findViewById(R.id.o1);
					image.setVisibility(0);
					break;
				case R.id.place2:
					place = 2;
					image = (ImageView)findViewById(R.id.o2);
					image.setVisibility(0);
					break;
				case R.id.place3:
					place = 3;
					image = (ImageView)findViewById(R.id.o3);
					image.setVisibility(0);
					break;
				case R.id.place4:
					place = 4;
					image = (ImageView)findViewById(R.id.o4);
					image.setVisibility(0);
					break;
				case R.id.place5:
					place = 5;
					image = (ImageView)findViewById(R.id.o5);
					image.setVisibility(0);
					break;
				case R.id.place6:
					place = 6;
					image = (ImageView)findViewById(R.id.o6);
					image.setVisibility(0);
					break;
				case R.id.place7:
					place = 7;
					image = (ImageView)findViewById(R.id.o7);
					image.setVisibility(0);
					break;
				case R.id.place8:
					place = 8;
					image = (ImageView)findViewById(R.id.o8);
					image.setVisibility(0);
					break;
			}
			used[place] = 1;
//			if (used[place] == 0) {
//				int[] location = new int[2];
//				view.getLocationOnScreen(location);
//				float x = location[0];
//				float y = location[1];
//			    final ImageView iv = (ImageView) findViewById(R.drawable.o);
//				iv.setImageResource(R.drawable.o);
//			    final RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) iv.getLayoutParams();
//			    lp.x = x;
//			    lp.y = y;
//			    iv.setLayoutParams(lp);
//			    used[place] = 1;
			    playGame();
			//}
		}
	}

    public void clickMenu(View view) {
        // Do something in response to button click
    	Intent intent = new Intent(this, StartMenu.class);
		startActivity(intent);
    }
}
