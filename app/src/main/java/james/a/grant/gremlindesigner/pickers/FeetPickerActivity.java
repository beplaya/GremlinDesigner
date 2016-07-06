package james.a.grant.gremlindesigner.pickers;

import android.content.Intent;

import james.a.grant.gremlindesigner.Gremlin;
import james.a.grant.gremlindesigner.GremlinConstants;
import james.a.grant.gremlindesigner.pickers.base.PickerActivity;

public class FeetPickerActivity extends PickerActivity {

    @Override
    public Gremlin.GremlinPart getFocusedPart() {
        return Gremlin.GremlinPart.FEET;
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
