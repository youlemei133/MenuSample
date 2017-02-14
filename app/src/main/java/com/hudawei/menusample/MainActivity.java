package com.hudawei.menusample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

/**
 * OptionMenu
 * 在启动时调用onCreateOptionsMenu，onPrepareOptionsMenu
 * 点击菜单栏上的菜单时调用：onMenuOpened onPrepareOptionsMenu onMenuOpened
 * 点击空白区域或Back键时，什么也不调用
 */
public class MainActivity extends AppCompatActivity {
    private final static int RED=1001;
    private final static int GREEN=1002;
    private final static int BLUE=1003;
    private final static int GRAY=1004;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView contextMenu=(TextView) findViewById(R.id.contextMenu);
        registerForContextMenu(contextMenu);
    }

    /**
     * 在OptionMenu第一次显示的时候调用，如果想修改调用onPrepareOptionsMenu。
     * 使用OptionMenu必须实现onCreateOptionsMenu和onOptionsItemSelected方法
     * @param menu Option item添加到该menu
     * @return true代表显示menu,false代表不显示menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //群组id 该Option的id 排列序号 显示的文本
        //optionid用于唯一标识MenuItem
        //排列序号按从小到大依次排列，如果按照添加顺序可都设为0
        menu.add(1,RED,1,"红");
        menu.add(1,BLUE,6,"蓝");
        menu.add(1,GREEN,2,"绿");
        menu.add(1,GRAY,3,"灰");
        log("onCreateOptionsMenu");
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        log("onPrepareOptionsMenu");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        log("onMenuOpened");
        return super.onMenuOpened(featureId, menu);
    }

    /**
     * 在点击OptionsItem的时候调用，需要调用父类的该方法
     * @param item
     * @return true表示消费该事件，false表示不消费该时间
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case RED:
                log("RED");
                break;
            case GREEN:
                log("GREEN");
                break;
            case BLUE:
                log("BLUE");
                break;
            case GRAY:
                log("GRAY");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        log("onOptionsMenuClosed");
        super.onOptionsMenuClosed(menu);
    }

    public void contextMenu(View view){
//        registerForContextMenu((TextView)view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        menu.add(1,RED,1,"红");
//        menu.add(1,BLUE,6,"蓝");
//        menu.add(1,GREEN,2,"绿");
//        menu.add(1,GRAY,3,"灰");

        getMenuInflater().inflate(R.menu.menu_context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:
                log("RED");
                break;
            case R.id.green:
                log("GREEN");
                break;
            case R.id.blue:
                log("BLUE");
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void popMenu(View view){
        PopupMenu popupMenu=new PopupMenu(this,view);
        popupMenu.inflate(R.menu.menu_context);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.red:
                        log("RED");
                        break;
                    case R.id.green:
                        log("GREEN");
                        break;
                    case R.id.blue:
                        log("BLUE");
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    private void log(String message){
        Log.e(this.getClass().getSimpleName(),message);
    }
}
