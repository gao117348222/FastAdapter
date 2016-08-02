# FastAdapter
封装Adapter
###1 Listview adapter
### 使用方法如下
```
 FastAdapterListView adapter1=new FastAdapterListView<String>(getApplicationContext(),mDatas,R.layout.lv_item1) {
            @Override
            public void convert(ViewHolder helper, String item) {
                Log.e("Unity", "convert");
                TextView tv1=helper.getView(R.id.textView);
                tv1.setText(item);
                Button bt1=helper.getView(R.id.button2);
                bt1.setText(item);
                bt1.setTag(item);
                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.e("com.gx303.framedemo",""+v.getTag());
                    }
                });
                //...给item赋值
            }
        };
        lv1.setAdapter(adapter1);
```