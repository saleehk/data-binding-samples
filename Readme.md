# Data binding samples
Samples for google new dataBinding Library

##Simple Data Binding
####simple.xml
```
<layout>
    <data>
        <variable
            name="user"
            type="com.saleeh.databinding.models.User" />
    </data>
    <LinearLayout>
         <ImageView
         app:imageUrl="@{user.url}"/>
        <TextView
                    android:text="@{user.name}" />
        <TextView
                android:text="@{String.valueOf(user.age)}" />
        <TextView
                android:text="@{user.phone}" />
</LinearLayout>
</layout>
```
And in java just
```
 ActivityDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data);
        User user = new User("Saleeh", 22, "123456789", "https://developer.android.com/assets/images/android_logo.png");
        binding.setUser(user);
```
thats it
###Here is how it look
![Screen 1] (https://raw.githubusercontent.com/saleeh93/data-binding-samples/master/art/simple.png)


