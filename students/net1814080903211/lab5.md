# 实验五：Android存储编程

## 一、实验目标

1. 了解Android的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储。

## 二、实验要求

1. 应用数据存储可采用数据库存储；
2. 将应用产生的数据存储到数据库中；
3. 将应用运行结果截图。

## 三、实验步骤

1. 将主页的聊天室列表存储在数据库中，需要在ChatObject.java中加入Room的注释，协助Room完成数据库表的建立。

    ``` java
    @Entity(
            tableName = "chat_list",
            primaryKeys = {"Name", "Type"}
    )
    public class ChatObject {
        @NotNull
        private String name;
        @NotNull
        private String type;

        private @Nullable @Ignore
        String extraInfo;

        // 省略默认构造函数，以及name、type、extraInfo的setter与getter
    }
    ```

2. 创建ChatObject的数据库交互接口ChatObjectDao

    ``` java
    @Dao
    public interface ChatObjectDao {
        @Query("SELECT * from chat_list")
        LiveData<List<ChatObject>> getAll();

        @Insert
        void insertAll(ChatObject... objects);

        @Delete
        void delete(ChatObject obj);
    }
    ```

3. 创建数据库的交互入口AppDatabase

    ``` java
    @Database(entities = {ChatObject.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract ChatObjectDao chatObjectDao();
    }
    ```

4. 为简化数据库交互，创建一致的数据库访问帮助类Database

    ``` java
    public class Database {
        private static final String DATABASE_NAME = "kChatPrototype";

        public static AppDatabase getFromContext(Context context) {
            return Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).build();
        }
    }
    ```

5. 修改HomeViewModel，不再使用假数据

    ```  java
    public class HomeViewModel extends ViewModel {

        // 省略上文

        public LiveData<List<ChatObject>> getChatObjects(Context context) {
            return Database.getFromContext(context).chatObjectDao().getAll();
        }
    }
    ```

6. 另外，在本地存储用户档案数据的时候，发现使用文件或者数据库实现都不太方便，文件的话需要我手动完成数据结构序列化的操作，比较繁琐，而数据库存储只有一行的表不太合适，并且找不到合适的主键。随后查阅安卓官方指导，发现还可以使用SharedPreferences来进行键值对方式的存储，比较优雅。
7. 于是需要修改ProfileFragment，在创建fragment的时候创建SharedPerference。

    ``` java
    public class ProfileFragment extends Fragment {

        private FragmentProfileBinding binding;
        private SharedPreferences sharedPreferences;

        public View onCreateView(@NonNull LayoutInflater inflater,
                                ViewGroup container, Bundle savedInstanceState) {
            /*  上略  */
            sharedPreferences = requireContext().getSharedPreferences(
                    getString(R.string.preference_profile_key), Context.MODE_PRIVATE
            );
            /*  下略  */
        }

        // 下略
    }
    ```

8. 并且添加写入和恢复档案的操作

    ``` java
    View.OnClickListener saveProfile = view -> {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(
                getString(R.string.profile_pref_name_key),
                binding.profileId.getText().toString()
        );
        editor.putInt(
                getString(R.string.profile_pref_sex_key),
                binding.sexualSpinner.getSelectedItemPosition()
        );
        editor.putInt(
                getString(R.string.profile_pref_age_key),
                binding.ageSpinner.getSelectedItemPosition()
        );
        editor.putString(
                getString(R.string.profile_pref_intro_key),
                binding.introText.getText().toString()
        );
        editor.apply();
    };

    void recoverProfile() {
        binding.profileId.setText(sharedPreferences.getString(
                getString(R.string.profile_pref_name_key), "Anonymous")
        ); // 对于新用户，取不到值，所以默认用户名为Anonymous
        binding.sexualSpinner.setSelection(sharedPreferences.getInt(
                getString(R.string.profile_pref_sex_key), 2
        )); // 默认性别为保密
        binding.ageSpinner.setSelection(sharedPreferences.getInt(
                getString(R.string.profile_pref_age_key), 19
        )); // 默认二十岁
        binding.introText.setText(sharedPreferences.getString(
                getString(R.string.profile_pref_intro_key), "I am new here."
        )); // 默认留言“I am new here"
    }
    ```

9. 在Fragment创建的时候读取值然后写入界面，以及绑定保存按钮的操作

    ``` java
    // 在上文的onCreateView的末尾数行
    recoverProfile();
    binding.submitBtn.setOnClickListener(saveProfile);
    ```

## 四、实验结果

![before](https://raw.githubusercontent.com/zhongzhitao/android-labs-2020/master/students/net1814080903211/lab5-1.png)
![after](https://raw.githubusercontent.com/zhongzhitao/android-labs-2020/master/students/net1814080903211/lab5-2.png)
![shared_pref](https://raw.githubusercontent.com/zhongzhitao/android-labs-2020/master/students/net1814080903211/lab5-3.png)

## 五、实验心得

按照正常的思路，应该是直接手写SQL调用嵌入式数据库SQLite来完成数据库的交互，但是在看文档的时候，发现Room库更好玩一些，它能够根据手写注解的提示来自动生成操作SQLite数据库的代码，并且能够自动实现异步操作，防止UI线程冻结。除此之外，虽然在实验里用不到，但是它能够记录数据库的版本，在用户升级应用程序时验证已有数据库的版本和程序所期待的版本，在版本不一致时检查程序是否提供迁移数据库版本的代码，有则执行数据库迁移，无则报错退出，防止旧版本已有数据格式和新版本应用程序不兼容导致可能出现的数据损坏甚至丢失。写完Room部分的代码之后发现数据库不太适合保存本地的用户档案，随后还找到了安卓官方提供的存储键值对的SharedPreference，确实很适合存储本地数据，并且不需要获取额外的权限。
