package com.aj.gremlindesigner.pickers;

import android.content.Intent;

import com.aj.gremlindesigner.Gremlin.GremlinPart;
import com.aj.gremlindesigner.GremlinConstants;
import com.aj.gremlindesigner.pickers.base.PickerActivity;

public class FeetPickerActivity extends PickerActivity {

	@Override
	public GremlinPart getFocusedPart() {
		return GremlinPart.FEET;
	}

	@Override
	public void goToNextPicker() {
		Intent intent = new Intent(getApplicationContext(), EyesPickerActivity.class);
		getWagon().pack(intent);
		startActivity(intent);
	}

	@Override
	public void goToPreviousPicker() {
		Intent intent = new Intent(getApplicationContext(), HandsPickerActivity.class);
		getWagon().pack(intent);
		startActivity(intent);
	}

	@Override
	protected int[] getPartOptions() {
		return GremlinConstants.FEET_OPTIONS;
	}
}
