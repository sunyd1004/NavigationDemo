package com.sunyd.navigationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}

/**
 * navigation: 定义导航栈，可以进行嵌套定义，各个navigation相互独立。它有一个属性startDestination用来定义导航栈的根入口fragment
 * fragment: 顾名思义fragment页面。通过name属性来定义关联的fragment
 * action: 意图，可以理解为Intent，即跳转的行为。通过destination来关联将要跳转的目标fragment。
 *
 * defaultNavHost: 将设备的回退操作进行拦截，并将其交给Navigation进行管理。
 * navGraph: Navigation的配置文件，即上面我们配置的nav_graph.xml文件
 *
 * 除此之外，fragment的name属性必须为NavHostFragment，因为它会作为我们配置的所有fragment的管理者。
 * 具体通过内部的NavController中的NavigationProvider来获取Navigator抽象实例，具体实现类是FragmentNavigator，
 * 所以最终通过它的navigate方法进行创建我们配置的Fragment，并且添加到NavHostFragment的FrameLayout根布局中。
 * 此时如果我们直接运行程序后发现已经可以看到入口页面WelcomeFragment
 *
 * 依赖：implementation "android.arch.navigation:navigation-fragment-ktx:1.0.0"
 *      implementation "android.arch.navigation:navigation-ui-ktx:1.0.0"
 * 传参：classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.2"
 *      apply plugin: "androidx.navigation.safeargs.kotlin"
 */