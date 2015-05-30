# Data binding samples
Samples for google new dataBinding Library

* ###Simple Data Binding 
>In xml
```xml
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
>In Activity 
```java
 ActivityDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data);
        User user = new User("Saleeh", 22, "123456789", "https://developer.android.com/assets/images/android_logo.png");
        binding.setUser(user);
```
>That's it to get all done
###Here is how it look
![Screen 1] (https://raw.githubusercontent.com/saleeh93/data-binding-samples/master/art/simple.png)
* ###ListView Binding 
>In list item view just as above 
```xml

<layout>
    <data>
    <variable
            name="repo"
            type="com.saleeh.databinding.api.models.Repo" />
    </data>
    <RelativeLayout>
    <TextView
    android:text="@{repo.fullName}"/>
    <ImageView
            app:imageUrl="@{repo.owner.avatarUrl}" />
    <TextView
            android:text="@{repo.description}" />
    </RelativeLayout>
</layout>

```

