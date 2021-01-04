## 实验五
一、实验目标  
1.了解Andoid的存储手段;  
2.掌握Android的文件存储;  
3.掌握Android的数据库存储.  
二、实验内容  
应用数据存储可采用数据库存储。  
1.将应用产生的数据存储到数据库中；  
2.将应用运行结果截图。  
三、实验步骤  
1.CostBean类：  
```
import java.io.Serializable;
public class CostBean implements Serializable {  //实现一个可序列化的结果
public String costTitle;
public String costDate;
    public String costMoney;
}
```
  
2. CostListAdapter类：    
```
public class CostListAdapter extends BaseAdapter {
    private List<CostBean> mList;//其中每一个列表项都封装一个CostBean
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public CostListAdapter(Context context, List<CostBean> list)
    {
        mContext = context;
        mList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mList.size();
    }
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
```  

3.DataBaseHelper类：  
```
public void toDelete(CostBean costBean){
    SQLiteDatabase database = getWritableDatabase();
    database.delete(ACCOUNT_COST,"COST_TITLE = ? and COST_MONEY = ? and COST_DATE = ?",
            new String[]{""+costBean.costTitle,""+costBean.costMoney,""+costBean.costDate});
}
```  

4.（主界面是由adapter实现的，每次来到主界面时，都会调取数据库中保存的账单数据，再通过CostBeanList类中的方法使所有数据显示到每个item中。在添加账单时，都会将添加的数据传入数据库中，再次调取数据库中的数据，界面自动刷新，更新显示在主界面中。这样就生成了一个完整的Cost_List界面。）  
CostListAdapter类：  
```
 @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){   //创建新账单时，创建新的list布局
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.list_item, null);
            viewHolder.CostTitle = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.CostDate = (TextView) convertView.findViewById(R.id.tv_date);
            viewHolder.CostMoney = (TextView) convertView.findViewById(R.id.tv_cost);
            convertView.setTag(viewHolder);  //标记一个
        }else{
            viewHolder = (ViewHolder) convertView.getTag();  //找到相应的对象取出
        }
        CostBean bean = mList.get(position);  //具体的数据显示到item中
        viewHolder.CostTitle.setText(bean.costTitle);
        viewHolder.CostDate.setText(bean.costDate);
        viewHolder.CostMoney.setText(bean.costMoney);
        return convertView;
    }

    private static class ViewHolder{
        public TextView CostTitle;
        public TextView CostDate;
        public TextView CostMoney;
    }
}
```  

实验截图：![avatar](https://github.com/1814080911138/android-labs-2020/blob/master/students/sec1814080911138/8.png)    
         ![avatar](https://github.com/1814080911138/android-labs-2020/blob/master/students/sec1814080911138/9.png)


四、实验心得  
本次实验是本学期移动应用开发的第五次实验课，初步学会了Android存储编程，了解了Andoid的存储手段、掌握了Android的数据库存储。


