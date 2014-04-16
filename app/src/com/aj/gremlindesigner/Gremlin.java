package com.aj.gremlindesigner;

import com.aj.gremlindesigner.R.drawable;

public class Gremlin {

	public enum GremlinPart {
		HEAD, BODY, HANDS, FEET, EYES
	}

	public int head = drawable.head_001;
	public int body = drawable.body_001;
	public int hands = drawable.hands_001;
	public int feet = drawable.feet_001;
	public int eyes = drawable.eyes_001;

	public boolean isValid() {
		return head != 0 && body != 0 && hands != 0 && feet != 0 && eyes != 0;
	}

	public void update(GremlinPart focusedPart, int value) {

		switch (focusedPart) {
		case HEAD:
			head = value;
			break;
		case BODY:
			body = value;
			break;
		case HANDS:
			hands = value;
			break;
		case FEET:
			feet = value;
			break;
		case EYES:
			eyes = value;
			break;
		default:
			break;
		}

	}
}
