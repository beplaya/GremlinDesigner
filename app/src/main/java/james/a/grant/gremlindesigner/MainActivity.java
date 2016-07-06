package james.a.grant.gremlindesigner;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import james.a.grant.gremlindesigner.pickers.HeadPickerActivity;
import james.a.grant.gremlindesigner.pickers.base.GremlinBuilder;
import james.a.grant.wagon.Wagon;

import static james.a.grant.gremlindesigner.R.id;

public class MainActivity extends BaseActivity {

    public GremlinBuilder gremlinBuilder = new GremlinBuilder();

    private GremlinViewer gremlinViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gremlinViewer = (GremlinViewer) findViewById(id.gremlin_viewer);
        gremlinViewer.setGremlin(new Gremlin());

        findViewById(id.main_btn_new_gremlin).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Wagon<GremlinBuilder> wagon = new Wagon<GremlinBuilder>(gremlinBuilder.getClass(), gremlinBuilder);
                Intent intent = new Intent(getApplicationContext(), HeadPickerActivity.class);
                wagon.pack(intent);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Wagon<GremlinBuilder> wagon = new Wagon<GremlinBuilder>(gremlinBuilder.getClass(), gremlinBuilder);
        wagon.unpack(getSharedPreferences(GremlinConstants.PREF_KEY_GREMLIN, MODE_PRIVATE));

        if (gremlinBuilder == null)
            gremlinBuilder = new GremlinBuilder();
        else if (!gremlinBuilder.gremlin.isValid())
            gremlinBuilder = new GremlinBuilder();

        gremlinViewer.setGremlin(gremlinBuilder.gremlin);
    }
}
