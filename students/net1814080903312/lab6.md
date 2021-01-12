# 一、实验目的
1.掌握Android网络访问方法；
2.理解XML和JSON表示数据的方法。 
# 二、实验内容
1.在个人目录中创建一个表示数据的XML或JSON文件；
2.数据文件代码提交之后从GitHub获取文件URL；
3.在应用中通过网络编程访问GitHub的数据文件；
4.在应用中解析并显示文件所包含的数据；
5.将应用运行结果截图。
# 三、实验步骤
1.SearchActivity的布局为顶部搜索框，下面是一个List用了显示搜索到的音乐
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@drawable/wangyiyun3"
    tools:context=".SearchActivity">

    <SearchView
        android:id="@+id/searchView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#D86781" >
    </SearchView>

    <ListView
        android:id="@+id/netmusiclist"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" >
    </ListView>

</LinearLayout>
```
2.建立异步任务以及解析Json
```
// 负责搜索音乐的异步任务，搜索完成后显示网络音乐列表
    private class SearchMusicTask extends AsyncTask<String, Void, Void> {
        private ListView musicList;

        public SearchMusicTask(ListView musicList) {
            this.musicList = musicList;
        }

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected Void doInBackground(String... params) {
            String url = params[0];
            try {
                HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
                conn.setConnectTimeout(5000);
                //使用缓存提高处理效率
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = null;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                //网络响应赋值给成员变量searchResponse
                searchResponse = sb.toString();
                parseResponse();
                Log.d(TAG, "searchResponse = " + searchResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //adapter数据更新后通知列表更新
            netMusicListAdapter.notifyDataSetChanged();
            //musicList.setAdapter(netMusicListAdapter);
        }

        //json解析网络响应
        private void parseResponse() {
            try {
                JSONObject response = new JSONObject(searchResponse);
                JSONObject result = response.getJSONObject("result");
                JSONArray songs = result.getJSONArray("songs");
                if (netMusicList.size() > 0) netMusicList.clear();
                for (int i = 0; i < songs.length(); i++) {
                    JSONObject song = songs.getJSONObject(i);
                    //获取歌曲名字
                    String title = song.getString("name");
                    //获取歌词演唱者
                    String artist = song.getJSONArray("artists")
                            .getJSONObject(0).getString("name");
                    //获取歌曲专辑图片的url
                    String albumPicUrl = song.getJSONObject("album").getString(
                            "picUrl");
                    //获取歌曲音频的url
                    String audioUrl = song.getString("audio");
                    Log.d(TAG, "doenloadUrl = " + audioUrl);
                    //保存音乐信息的Map
                    Map<String, Object> item = new HashMap<>();
                    item.put("title", title);
                    item.put("artist", artist);
                    item.put("picUrl", albumPicUrl);
                    picUrlMap.put(title + artist, new SoftReference<String>(
                            albumPicUrl));
                    item.put("audio", audioUrl);
                    //将一条歌曲信息存入list中
                    netMusicList.add(item);
                }
                Log.d(TAG, "搜到" + netMusicList.size() + "首歌");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }
```
# 四、实验结果
![搜索界面](https://github.com/xiangzuonidekongbai/android-labs-2020/blob/master/students/net1814080903312/lab6.PNG)
# 五、实验心得
本次实验是学习使用APP进行网络访问，在这方面有很多难点，实验进度也因此拉慢很多，通过网上资源以及一些视频讲解，稍微理解了一部分，不过还是要继续学习。
