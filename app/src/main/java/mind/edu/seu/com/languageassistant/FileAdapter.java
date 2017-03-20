package mind.edu.seu.com.languageassistant;

/**
 * Created by think on 2017/3/20.
 */

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FileAdapter extends BaseAdapter {
    //创建view时必须要提供context
    public Activity activity;
    //提供数据源，文件列表
    public List<File> list=new LinkedList<File>();
    //当前列表路径
    public String currPath;
    private Bitmap bmp_folder,bmp_file;

    public int getCount() {

        return list.size();
    }

    public Object getItem(int position) {

        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View arg1, ViewGroup arg2) {
        //申明一个视图装载listView条目
        View v=View.inflate(activity, R.layout.file_list, null);
        TextView textPath=(TextView) v.findViewById(R.id.text_path);
        TextView textSize=(TextView) v.findViewById(R.id.text_size);
        ImageView img=(ImageView) v.findViewById(R.id.imageView1);
        //获取当前位置
        File f=list.get(position);
        //获取文件名和文件大小
        textPath.setText(f.getName());
        textSize.setText(getFileSize(f));
        //识别是文件还是文件夹，显示出不同的图片
        if(f.isDirectory()){
            img.setImageBitmap(bmp_folder);
        }else
            img.setImageBitmap(bmp_file);
        //肉眼视图
        return v;
    }

    private static String getFileSize(File f) {
        //申明变量
        int sub_index=0;
        String show="";
        //计算文件大小
        if(f.isFile()){
            long length=f.length();

            if(length>=1073741824)
            {
                sub_index=String.valueOf((float)length/1073741824).indexOf(".");
                show= ((float) length/1073741824 + "000").substring(0, sub_index + 3)+ "GB";
            }

            else if(length>=1048576)
            {
                sub_index=(String.valueOf((float)length/1048576)).indexOf(".");
                show=((float)length/1048576+"000").substring(0,sub_index+3)+"MB";
            }

            else if(length>=1024)
            {
                sub_index=(String.valueOf((float)length/1024)).indexOf(".");
                show=((float)length/1024+"000").substring(0,sub_index+3)+"KB";
            }
            else if(length<1024)
                show=String.valueOf(length)+"B";
        }

        return show;
    }

    //扫描文件夹
    public void scanFiles(String path) {

        list.clear();
        File dir=new File(path);
        File[] subFiles=dir.listFiles();
        //生成文件列表
        if(subFiles!=null){
            for(File f:subFiles)
                list.add(f);
        }
        this.notifyDataSetChanged();
        currPath=path;

    }
//    public FileAdapter(Activity activity){
//
//        this.activity=activity;
//        //绑定显示文件图标
//        bmp_folder= BitmapFactory.decodeResource(activity.getResources(),R.drawable.bmp_floder);
//        bmp_file=BitmapFactory.decodeResource(activity.getResources(), R.drawable.bmp_file);
//    }

}