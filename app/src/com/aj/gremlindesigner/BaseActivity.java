package com.aj.gremlindesigner;

import android.app.Activity;
import android.content.Intent;

public abstract class BaseActivity extends Activity {
	@Override
	public void startActivity(Intent intent) {
		super.startActivity(intent);
		finish();
	}
}
