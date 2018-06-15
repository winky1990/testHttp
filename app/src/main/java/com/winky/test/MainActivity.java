package com.winky.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final TextView textView = (TextView) findViewById(R.id.hello);
    }


    public void clickme(View view) {
        HttpUtils.getInstance()
                .setDialog(new LoadingDialog(this))
                .request(HttpUtils.create(IArticle.class).queryArticle("25a9b44caa1c5"), new HttpResponse<ApiModel<List<ArticleType>>>() {
                    @Override
                    public void success(ApiModel<List<ArticleType>> result) {
                        for (ArticleType articleType : result.getResult()) {
                            System.out.println(articleType.getName());
                        }
                    }

                    @Override
                    public void failed(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                });
//        BottomSheetDialog bottomSheetDialog=new
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("我是标题");
//        builder.setMessage("me is content");
//        builder.setCustomTitle(View.inflate(this, R.layout.custom_view, null));
//        builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
//            }
//        });
//        builder.create().show();
    }
}
