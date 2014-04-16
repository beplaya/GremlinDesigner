package com.aj.gremlindesigner.pickers;

import android.content.Intent;

import com.aj.gremlindesigner.Gremlin.GremlinPart;
import com.aj.gremlindesigner.GremlinConstants;
import com.aj.gremlindesigner.MainActivity;
import com.aj.gremlindesigner.pickers.base.PickerActivity;

public class EyesPickerActivity extends PickerActivity {

	@Override
	public GremlinPart getFocusedPart() {
		return GremlinPart.EYES;
	}

	@Override
	public void goToNextPicker() {
		getWagon().pack(getSharedPreferences(GremlinConstants.PREF_KEY_GREMLIN, MODE_PRIVATE));
		Intent intent = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(intent);
	}

	@Override
	public void goToPreviousPicker() {
		Intent intent = new Intent(getApplicationContext(), FeetPickerActivity.class);
		getWagon().pack(intent);
		startActivity(intent);
	}

	@Override
	protected int[] getPartOptions() {
		return GremlinConstants.EYE_OPTIONS;
	}
}
