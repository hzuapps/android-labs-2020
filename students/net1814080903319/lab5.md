# 实验五
## 一、实验目标
1. 了解Android的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储 

## 二、实验内容
1. 修改activity_item.xml对应的布局内容；
2. 创建一个实现适配器的类，将内容显示在activity_item.xml界面上；

## 三、实验步骤
1. 创建一个Java对象类Message.java，会用在activity_item.xml界面中遍历的属性
```java
public class Message {
    private Integer id;
    private String singname;
    private String fangshi;
    private String singer;
}
```
2. 创建一个activity_inner.xml用于循环的框架结构；
3. 创建适配器类MessageAdapter.java；
```java
@Override
    public MessageInnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_inner,parent,false);
        MessageInnerHolder messageInnerHolder=new MessageInnerHolder(view);
        return messageInnerHolder;
    }
```
4. 修改ItemActivity.java和activity_item.xml；
```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        initView();
        initData();
    }
    private void initData() {
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<Message> messageList = getMessageItem();
        MessageAdapter messageAdapter=new MessageAdapter(messageList,ItemActivity.this);
        recyclerView.setAdapter(messageAdapter);
    }
    private List<Message> getMessageItem() {
        List<Message> messageList = new ArrayList<>();
        for (int i=1;i<=10;i++){
            Message message=new Message();
            message.setId(i);
            message.setSingname("歌名"+i);
            message.setFangshi("弹唱");
            message.setSinger("歌手"+i);
            messageList.add(message);
        }
        return messageList;
    }
```
5. 用git bash提交相关文件到hzuapps/android-labs-2020

## 四、实验结果
![列表结果截图](https://raw.githubusercontent.com/Basr-suer/android-labs-2020/master/students/net1814080903319/lab5.jpg)

## 五、实验心得
在项目中没有需要用到存储手段，故本次实验没有使用Android数据库存储技术，仅是给ItemActivity.java添加适配器循环输出列表
