package mind.edu.seu.com.languageassistant.SecondFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import mind.edu.seu.com.languageassistant.R;
import mind.edu.seu.com.languageassistant.SecondFragment.basic.IatBasicFragment;

/**
 * Created by Mind on 2017/3/16.
 */
public class SecondFragment extends IatBasicFragment implements View.OnClickListener{

    private  View mView;
    private ImageButton fragTwo_startBtn;
    private ImageButton fragTwo_pauseBtn;
    private Button fragTwo_endBtn;
    private EditText fragTwo_EditText;

    public SecondFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_two, container, false);
        initViwe();
        return mView;
    }

    private void initViwe() {
        fragTwo_EditText= (EditText) mView.findViewById(R.id.fragTwo_editText);
        fragTwo_endBtn= (Button) mView.findViewById(R.id.fragTwo_endBtn);
        fragTwo_pauseBtn= (ImageButton) mView.findViewById(R.id.fragTwo_pauseBtn);
        fragTwo_startBtn= (ImageButton) mView.findViewById(R.id.fragTwo_startBtn);
        fragTwo_startBtn.setOnClickListener(this);
        fragTwo_pauseBtn.setOnClickListener(this);
        fragTwo_endBtn.setOnClickListener(this);
        initIatData(fragTwo_EditText);
    }

    @Override
    public void onClick(View v) {
        super.clickMethod(v);

    }
}
