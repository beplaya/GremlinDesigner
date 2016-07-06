package james.a.grant.gremlindesigner.pickers;

import android.content.Intent;

import james.a.grant.gremlindesigner.Gremlin;
import james.a.grant.gremlindesigner.GremlinConstants;
import james.a.grant.gremlindesigner.MainActivity;
import james.a.grant.gremlindesigner.pickers.base.PickerActivity;


public class EyesPickerActivity extends PickerActivity {

    @Override
    public Gremlin.GremlinPart getFocusedPart() {
        return Gremlin.GremlinPart.EYES;
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
