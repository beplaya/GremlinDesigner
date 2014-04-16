package com.aj.gremlindesigner.pickers;

import android.content.Intent;

import com.aj.gremlindesigner.Gremlin.GremlinPart;
import com.aj.gremlindesigner.GremlinConstants;
import com.aj.gremlindesigner.pickers.base.PickerActivity;

public class HandsPickerActivity extends PickerActivity {

	@Override
	public GremlinPart getFocusedPart() {
		return GremlinPart.HANDS;
	}

	@Override
	public void goToNextPicker() {
		Intent intent = new Intent(getApplicationContext(), FeetPickerActivity.class);
		wagon.pack(intent);
		startActivity(intent);
	}

	@Override
	public void goToPreviousPicker() {
		Intent intent = new Intent(getApplicationContext(), BodyPickerActivity.class);
		wagon.pack(intent);
		startActivity(intent);
	}

	@Override
	protected int[] getPartOptions() {
		return GremlinConstants.HAND_OPTIONS;
	}

}
