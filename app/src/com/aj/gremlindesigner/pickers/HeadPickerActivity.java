package com.aj.gremlindesigner.pickers;

import android.content.Intent;

import com.aj.gremlindesigner.Gremlin.GremlinPart;
import com.aj.gremlindesigner.GremlinConstants;
import com.aj.gremlindesigner.MainActivity;
import com.aj.gremlindesigner.pickers.base.PickerActivity;

public class HeadPickerActivity extends PickerActivity {

	@Override
	public GremlinPart getFocusedPart() {
		return GremlinPart.HEAD;
	}

	@Override
	public void goToNextPicker() {
		Intent intent = new Intent(getApplicationContext(), BodyPickerActivity.class);
		wagon.pack(intent);
		startActivity(intent);
	}

	@Override
	public void goToPreviousPicker() {
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);
	}

	@Override
	protected int[] getPartOptions() {
		return GremlinConstants.HEAD_OPTIONS;
	}

}
