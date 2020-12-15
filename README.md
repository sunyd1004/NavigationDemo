Navigation练习demo

步骤说明：

1.build.gradle（APP）追加依赖
  implementation "android.arch.navigation:navigation-fragment-ktx:1.0.0"
  implementation "android.arch.navigation:navigation-ui-ktx:1.0.0"

2.res新建navigation文件夹

3.navigation文件夹下新建nav_garden

4.nav_garden可以通过design追加plachholer，也可直接通过xml代码追加

<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/nav_garden"            // 为当前xml追加id
    app:startDestination="@id/fragment_1">  // startDestination是和activity绑定后显示的第一个Fragment

    <fragment
        android:id="@+id/fragment_1"      // fragment的id
        android:name="com.sunyd.navigationdemo.Fragment1"     // fragment的全路径
        tools:layout="@layout/fragment_1">      // fragment布局，方便在design中查看，实际不会编译到程序中

        <action
            android:id="@+id/fragment_1_to_fragment_2"    // action 的 id
            app:destination="@id/fragment_2" />           // destination 是目的地，要跳转到哪里的

    </fragment>

    <fragment
        android:id="@+id/fragment_2"
        android:name="com.sunyd.navigationdemo.Fragment2"
        tools:layout="@layout/fragment_2">

        <action
            android:id="@+id/fragment_2_to_fragment_3"
            app:destination="@id/fragment_3" />

        <argument
            android:name="title"            // 参数名称
            android:defaultValue="defaultValue"   // 参数默认值
            app:argType="string" />   /参数类型

    </fragment>

    <fragment
        android:id="@+id/fragment_3"
        android:name="com.sunyd.navigationdemo.Fragment3"
        tools:layout="@layout/fragment_3">

    </fragment>

</navigation>

5.修改activity_main.xml

<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <fragment
        android:id="@+id/demo_fragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:name="androidx.navigation.fragment.NavHostFragment"     // 定死的，不能改
        app:defaultNavHost="true"                                       // 将设备的回退操作进行拦截，并将其交给Navigation进行管理。
        app:navGraph="@navigation/nav_garden"                           // Navigation的配置文件，即上面第四步的xml文件
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>

6.跳转，无参数
  Navigation.findNavController(view).navigate(R.id.fragment_1_to_fragment_2)
  
7.跳转，带参数（安全传值）
  7.1.build.gradle（model）追加：classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.2"
      build.gradle(APP)追加：apply plugin: "androidx.navigation.safeargs.kotlin"
  val fragment2Bundle = Fragment2Args.fromBundle(
                    bundleOf(
                        "title" to "Fragment3"
                    )
                ).toBundle()
  Navigation.findNavController(view).navigate(R.id.fragment_2_to_fragment_3, fragment2Bundle)

7.返回
  Navigation.findNavController(view).popBackStack()
  
