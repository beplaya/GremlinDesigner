package james.a.grant.gremlindesigner.pickers.base;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import james.a.grant.gremlindesigner.BaseActivity;
import james.a.grant.gremlindesigner.Gremlin;
import james.a.grant.wagon.Wagon;

import static james.a.grant.gremlindesigner.R.id;
import static james.a.grant.gremlindesigner.R.layout;

public abstract class PickerActivity extends BaseActivity implements Swiper.ISwipeListener {

    private ImageView pickerView;
    private GremlinBuilder gremlinBuilder = new GremlinBuilder();
    private Wagon<GremlinBuilder> wagon;
    private int optionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_picker);
        ((Button) findViewById(id.btn_previous)).setOnClickListener(new StepClickListener(false));
        ((Button) findViewById(id.btn_next)).setOnClickListener(new StepClickListener(true));

        pickerView = (ImageView) findViewById(id.picker_iv);

        pickerView.setOnTouchListener(new Swiper(this, this));

        wagon = getWagon();
        wagon.unpack(getIntent());
        refreshGremlin();
        refreshPickerView();
    }

    protected Wagon<GremlinBuilder> getWagon() {
        return new Wagon<GremlinBuilder>(gremlinBuilder.getClass(), gremlinBuilder);
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
        Gremlin.GremlinPart part = getFocusedPart();
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

    protected abstract Gremlin.GremlinPart getFocusedPart();

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
