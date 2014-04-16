package com.aj.gremlindesigner.pickers;

import android.content.Intent;

import com.aj.gremlindesigner.Gremlin.GremlinPart;
import com.aj.gremlindesigner.GremlinConstants;
import com.aj.gremlindesigner.pickers.base.PickerActivity;

public class BodyPickerActivity extends PickerActivity {

	@Override
	public GremlinPart getFocusedPart() {
		return GremlinPart.BODY;
	}

	@Override
	public void goToNextPicker() {
		Intent intent = new Intent(getApplicationContext(), HandsPickerActivity.class);
		wagon.pack(intent);
		startActivity(intent);
	}

	@Override
	public void goToPreviousPicker() {
		Intent intent = new Intent(getApplicationContext(), HeadPickerActivity.class);
		wagon.pack(intent);
		startActivity(intent);
	}

	@Override
	protected int[] getPartOptions() {
		return GremlinConstants.BODY_OPTIONS;
	}
}
