# 实验四 Android存储编程

## 一、实验要求

- 了解Andoid的存储手段;
- 掌握Android的文件存储;
- 掌握Android的数据库存储

## 二、实验内容

- 将应用产生的数据存储到数据库中； 
- 将应用运行结果截图。


## 三、实验步骤
1. JsonIO.java---读写Json文件
```java
public class JsonIO {
    public static void save(JSONObject json,String fileName){
        String jsonText = json.toString();
        String savePath = ApplicationGetter.getCurApplication().getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = overrideFile(savePath);
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(jsonText);
            System.out.println(savePath);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject get(String fileName){
        String savePath = ApplicationGetter.getCurApplication().getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = openFile(savePath);
        StringBuffer sb = new StringBuffer();
        String str = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            while((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\r\n");
            }
            br.close();
            JSONObject json = new JSONObject(sb.toString());
            return json;
        } catch (Exception e) {
            return null;
        }
    }
    private static File openFile(String path){
        File file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    private static File overrideFile(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static class ApplicationGetter{
        public static Application getCurApplication(){
            Application application = null;
            try{
                Class atClass = Class.forName("android.app.ActivityThread");
                Method currentApplicationMethod = atClass.getDeclaredMethod("currentApplication");
                currentApplicationMethod.setAccessible(true);
                application = (Application) currentApplicationMethod.invoke(null);
                Log.d("fw_create","curApp class1:"+application);
            }catch (Exception e){
                Log.d("fw_create","e:"+e.toString());
            }

            if(application != null)
                return application;

            try{
                Class atClass = Class.forName("android.app.AppGlobals");
                Method currentApplicationMethod = atClass.getDeclaredMethod("getInitialApplication");
                currentApplicationMethod.setAccessible(true);
                application = (Application) currentApplicationMethod.invoke(null);
                Log.d("fw_create","curApp class2:"+application);
            }catch (Exception e){
                Log.d("fw_create","e:"+e.toString());
            }
            return application;
        }
    }

}
```

Course.java--单个课程
```java
public Course(JSONObject json){
        try {
            this.courseName = json.getString("courseName");
            this.courseRoom = json.getString("courseRoom");
            this.courseDay = json.getString("courseDay");
            this.courseNumber = json.getString("courseNumber");
            this.courseStartWeek = json.getString("courseStartWeek");
            this.courseEndWeek = json.getString("courseEndWeek");
            this.courseOdd = json.getString("courseOdd");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public JSONObject toJSONObject(){
        JSONObject json = new JSONObject();
        try {
            json.put("courseName",courseName);
            json.put("courseRoom",courseRoom);
            json.put("courseDay",courseDay);
            json.put("courseNumber",courseNumber);
            json.put("courseStartWeek",courseStartWeek);
            json.put("courseEndWeek",courseEndWeek);
            json.put("courseOdd",courseOdd);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}
    private static File openFile(String path){
        File file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    private static File overrideFile(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static class ApplicationGetter{
        public static Application getCurApplication(){
            Application application = null;
            try{
                Class atClass = Class.forName("android.app.ActivityThread");
                Method currentApplicationMethod = atClass.getDeclaredMethod("currentApplication");
                currentApplicationMethod.setAccessible(true);
                application = (Application) currentApplicationMethod.invoke(null);
                Log.d("fw_create","curApp class1:"+application);
            }catch (Exception e){
                Log.d("fw_create","e:"+e.toString());
            }

            if(application != null)
                return application;

            try{
                Class atClass = Class.forName("android.app.AppGlobals");
                Method currentApplicationMethod = atClass.getDeclaredMethod("getInitialApplication");
                currentApplicationMethod.setAccessible(true);
                application = (Application) currentApplicationMethod.invoke(null);
                Log.d("fw_create","curApp class2:"+application);
            }catch (Exception e){
                Log.d("fw_create","e:"+e.toString());
            }
            return application;
        }
    }

}
```



ClassArray.java--course数组
```java
public class ClassArray {
    int maxSection=0;
    Map<Integer,Course>[] courseTable = new HashMap[7];

    public ClassArray(JSONObject json){
        for(int i=0;i<7;i++){
            courseTable[i] = new HashMap<Integer, Course>();
        }
        if(json != null){
            try {
                for(int i=0;i<7;i++){
                    JSONObject row = json.getJSONObject(String.valueOf(i));
                    Iterator<String> iterator = row.keys();
                    if(iterator.hasNext()){
                        String key = iterator.next();
                        courseTable[i].put(Integer.valueOf(key),new Course(row.getJSONObject(key)));
                        if(maxSection<Integer.valueOf(key)){
                            maxSection = Integer.valueOf(key);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getCourseName(int day,int section){
        Course course = courseTable[day].get(section);
        if(course==null){
            return null;
        }
        return course.courseName;
    }

    public void add(int day,int section,Course course){
        courseTable[day].put(section,course);
    }

    public int getMaxSection(){
        return maxSection;
    }

    public JSONObject toJsonObject(){
        JSONObject table = new JSONObject();
        try{
            for(int i=0;i<7;i++){
                JSONObject row = new JSONObject();
                for (Integer courseNum:courseTable[i].keySet()){
                    row.put(courseNum.toString(),courseTable[i].get(courseNum).toJSONObject());
                }
                table.put(String.valueOf(i),row);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return table;
    }



}
```
## 四、实验结果
  
  [![lab5](https://s3.ax1x.com/2021/01/14/saMxBR.png)](https://imgchr.com/i/saMxBR)
## 五、实验心得
  通过这次实验学会了使用Json来存取数据，需要存取的数据较少时可以使用Json来存取。
 
