# Data binding samples
Samples for google new dataBinding Library
https://developer.android.com/tools/data-binding/guide.html

### Simple Data Binding 
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

In Activity

```java
 ActivityDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data);
        User user = new User("Saleeh", 22, "123456789", "https://developer.android.com/assets/images/android_logo.png");
        binding.setUser(user);
```
That's it to get all done

###Here is how it look
![Screen 1] (https://raw.githubusercontent.com/saleeh93/data-binding-samples/master/art/simple.png)
###ListView Binding 

In list item view just as above 

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

In adapter getView

```java
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListRepoItemBinding binding;
        if (convertView == null)
            binding = DataBindingUtil.inflate(mInflater, R.layout.list_repo_item, parent, false);
        else
            binding = DataBindingUtil.getBinding(convertView);
        Repo item = getItem(position);
        binding.setRepo(item);

        convertView = binding.getRoot();
        return convertView;
    }
    
```
![Screen 2] (https://raw.githubusercontent.com/saleeh93/data-binding-samples/master/art/list.png)

