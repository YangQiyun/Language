package mind.edu.seu.com.languageassistant;

/**
 * Created by think on 2017/3/20.
 */

import java.io.File;

        import android.os.Bundle;
        import android.app.Activity;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

public class FileActivity extends Activity implements OnItemClickListener, OnClickListener {

    //声明变量
    ListView listView;

    TextView file_path;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找到相应的控件
        listView =(ListView) findViewById(R.id.listView1);

        file_path=(TextView) findViewById(R.id.text_path);

        //新建一个适配器。用来适配ListView，显示文件列表
        FileAdapter fileAdapter= new FileAdapter();
        //设置适配器，绑定适配器
        listView.setAdapter(fileAdapter);
        //listView中按键响应
        listView.setOnItemClickListener(this);
        //显示默认的文件目录
        fileAdapter.scanFiles("/");
        //响应“向上”的按钮
        //btn_up.setOnClickListener(this);
    }


    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        //声明一个适配器
        FileAdapter fileNext=(FileAdapter) listView.getAdapter();

        File f=fileNext.list.get(position);

        //获取文件路径和文件名称
        if(f.isDirectory()){

            Toast.makeText(FileActivity.this,"当前是个文件jia，不是文件,可以去打开当前文件夹"
                    ,Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(FileActivity.this,"当前是个文件，不是文件夹"
                    ,Toast.LENGTH_SHORT).show();
        }

    }

    public void onClick(View v) {
        //设置适配器
        FileAdapter upfa=(FileAdapter) listView.getAdapter();

        if(upfa.currPath.equals("/"))
        {
            Toast.makeText(FileActivity.this,"当前在主目录下"
                    ,Toast.LENGTH_SHORT).show();
            return;
        }else{
            Toast.makeText(FileActivity.this,"准备返回上级文件夹"
                    ,Toast.LENGTH_SHORT).show();
        }


    }



}