package com.aj.gremlindesigner.pickers.base;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.aj.gremlindesigner.BaseActivity;
import com.aj.gremlindesigner.Gremlin;
import com.aj.gremlindesigner.Gremlin.GremlinPart;
import com.aj.gremlindesigner.R.id;
import com.aj.gremlindesigner.R.layout;
import com.aj.gremlindesigner.pickers.base.Swiper.ISwipeListener;
import com.aj.wagon.Wagon;

public abstract class PickerActivity extends BaseActivity implements ISwipeListener {

	private ImageView pickerView;
	private GremlinBuilder gremlinBuilder = new GremlinBuilder();
	protected Wagon<GremlinBuilder> wagon;
	private int optionIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layout.activity_picker);
		((Button) findViewById(id.btn_previous)).setOnClickListener(new StepClickListener(false));
		((Button) findViewById(id.btn_next)).setOnClickListener(new StepClickListener(true));

		pickerView = (ImageView) findViewById(id.picker_iv);

		pickerView.setOnTouchListener(new Swiper(this, this));

		wagon = new Wagon<GremlinBuilder>(gremlinBuilder.getClass(), gremlinBuilder);
		wagon.unpack(getIntent());
		showGremlin(gremlinBuilder.gremlin);
		refreshPickerView();
	}

	@Override
	public void onSwipeRight() {
		previousChoice();
	}

	@Override
	public void onSwipeLeft() {
		nextChoice();
	}

	@Override
	public void onSwipeTop() {
	}

	@Override
	public void onSwipeBottom() {
	}

	public void onPick(int partResourceId) {
		GremlinPart part = getFocusedPart();
		// FIXME
	}

	@Override
	public void onBackPressed() {
		goToPreviousPicker();
	}

	protected void previousChoice() {
		if (optionIndex > 0) {
			optionIndex--;
			refreshGremlin();
			refreshPickerView();
		}
	}

	protected void nextChoice() {
		if (optionIndex < getPartOptions().length - 1) {
			optionIndex++;
			refreshGremlin();
			refreshPickerView();
		}
	}

	private void refreshGremlin() {
		gremlinBuilder.gremlin.update(getFocusedPart(), getPartOptions()[optionIndex]);
		showGremlin(gremlinBuilder.gremlin);
	}

	protected void showGremlin(Gremlin gremlin) {
		// FIXME
	}

	protected abstract int[] getPartOptions();

	protected abstract GremlinPart getFocusedPart();

	protected abstract void goToNextPicker();

	protected abstract void goToPreviousPicker();

	private void refreshPickerView() {
		pickerView.setImageResource(getPartOptions()[optionIndex]);
	}

	private class StepClickListener implements OnClickListener {
		private boolean isForward;

		public StepClickListener(boolean isForward) {
			this.isForward = isForward;
		}

		@Override
		public void onClick(View v) {
			if (isForward)
				goToNextPicker();
			else
				goToPreviousPicker();
		}
	}
}
