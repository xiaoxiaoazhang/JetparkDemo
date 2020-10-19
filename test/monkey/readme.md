# [Monkey使用说明](https://blog.csdn.net/qq_30993595/article/details/80748559)
## [Monkey命令介绍](https://developer.android.com/studio/test/monkey.html)
```
F:\workspace\JetparkDemo>adb shell monkey -help
usage: monkey [-p ALLOWED_PACKAGE [-p ALLOWED_PACKAGE] ...]
              [-c MAIN_CATEGORY [-c MAIN_CATEGORY] ...]
              [--ignore-crashes] [--ignore-timeouts]
              [--ignore-security-exceptions]
              [--monitor-native-crashes] [--ignore-native-crashes]
              [--kill-process-after-error] [--hprof]
              [--pct-touch PERCENT] [--pct-motion PERCENT]
              [--pct-trackball PERCENT] [--pct-syskeys PERCENT]
              [--pct-nav PERCENT] [--pct-majornav PERCENT]
              [--pct-appswitch PERCENT] [--pct-flip PERCENT]
              [--pct-anyevent PERCENT] [--pct-pinchzoom PERCENT]
              [--pct-permission PERCENT]
              [--pkg-blacklist-file PACKAGE_BLACKLIST_FILE]
              [--pkg-whitelist-file PACKAGE_WHITELIST_FILE]
              [--wait-dbg] [--dbg-no-events]
              [--setup scriptfile] [-f scriptfile [-f scriptfile] ...]
              [--port port]
              [-s SEED] [-v [-v] ...]
              [--throttle MILLISEC] [--randomize-throttle]
              [--profile-wait MILLISEC]
              [--device-sleep-time MILLISEC]
              [--randomize-script]
              [--script-log]
              [--bugreport]
              [--periodic-bugreport]
              [--permission-target-system]
              COUNT
```
1. -p 用于约束限制，用此参数指定一个包，指定包后Monkey将被允许启动指定应用；如果不指定包，  Monkey将被允许随机启动设备中的应用（主Activity有android.intent.category.LAUNCHER 或android.intent.category.MONKEY类别 ）。比如 adb shell monkey -p xxx.xxx.xxx 1  ; xxx.xxx.xxx 表示应用包名，1 表示monkey模拟用户随机事件参数，最低1，这样就能把应用启动起来
2. -c 指定Activity的category类别，如果不指定，默认是CATEGORY_LAUNCHER 或者 Intent.CATEGORY_MONKEY；不太常用的一个参数
3. -v 用于指定反馈信息级别，也就是日志的详细程度，分Level1、Level2、Level3；-v 默认值，仅提供启动提示，操作结果等少量信息 ，也就是Level1，比如adb shell monkey -p  xxx.xxx.xxx -v 1 ；-v -v 提供比较详细信息，比如启动的每个activity信息 ，也就是Level2，比如adb shell monkey -p xxx.xxx.xxx -v -v 1 ；-v -v -v 提供最详细的信息 ，比如adb shell monkey -p xxx.xxx.xxx -v -v -v 1 
4. -s 伪随机数生成器的种子值，如果我们两次monkey测试事件使用相同的种子值，会产生相同的事件序列；如果不指定种子值，系统会产生一个随机值。种子值对我们复现bug很重要。使用如下adb shell monkey -p xxx.xxx.xxx -s 11111 10；这也是伪随机事件的原因，因为这些事件可以通过种子值进行复现
5. --ignore-crashes 忽略异常崩溃，如果不指定，那么在monkey测试的时候，应用发生崩溃时就会停止运行；如果加上了这个参数，monkey就会运行到指定事件数才停止。比如adb shell monkey -p xxx.xxx.xxx -v -v -v  --ignore-crashes 10 
6. --ignore-timeouts 忽略ANR，情况与4类似，当发送ANR时候，让monkey继续运行。比如adb shell monkey -p xxx.xxx.xxx -v -v -v  --ignore-timeouts 10
7. --ignore-native-crashes 忽略native层代码的崩溃，情况与4类似，比如adb shell monkey -p xxx.xxx.xxx -v -v -v  --ignore-native-crashes 10
8. --ignore-security-exceptions 忽略一些许可错误，比如证书许可，网络许可，adb shell monkey -p xxx.xxx.xxx -v -v -v  --ignore-security-exceptions 10
9. --monitor-native-crashes 是否监视并报告native层发送的崩溃代码，adb shell monkey -p xxx.xxx.xxx -v -v -v  --monitor-native-crashes 10
10. --kill-procress-after-error 用于在发送错误后杀死进程
11. --hprof  设置后，在Monkey事件序列之前和之后立即生产分析报告，保存于data/mic目录，不过将会生成大量几兆文件，谨慎使用
12. --throttle 设置每个事件结束后延迟多少时间再继续下一个事件，降低cpu压力；如果不设置，事件与事件之间将不会延迟，事件将会尽快生成；一般设置300ms，因为人最快300ms左右一个动作，比如 adb shell monkey -p xxx.xxx.xxx -v -v -v  --throttle 300 10
13. --pct-touch 设置触摸事件的百分比，即手指对屏幕进行点击抬起(down-up)的动作；不做设置情况下系统将随机分配各种事件的百分比。比如adb shell monkey -p xxx.xxxx.xxx --pct-touch 50 -v -v 100 ，这就表示100次事件里有50%事件是触摸事件
14. --pct-motion 设置移动事件百分比，这种事件类型是由屏幕上某处的一个down事件-一系列伪随机的移动事件-一个up事件，即点击屏幕，然后直线运动，最后抬起这种运动。
15. --pct-trackball 设置轨迹球事件百分比，这种事件类型是一个或者多个随机移动，包含点击事件，这里可以是曲线运动，不过现在手机很多不支持，这个参数不常用
16. --pct-syskeys 设置系统物理按键事件百分比，比如home键，音量键，返回键，拨打电话键，挂电话键等
17. --pct-nav 设置基本的导航按键事件百分比，比如输入设备上的上下左右四个方向键
18. --pct-appswitch 设置monkey使用startActivity进行activity跳转事件的百分比，保证界面的覆盖情况
19. --ptc-anyevent 设置其它事件百分比
20. --ptc-majornav 设置主导航事件的百分比
21. 保存dos窗口打印的monkey信息，在monkey命令后面补上输出地址，如adb shell monkey -p xxx.xxxx.xxx  -v -v 100 > D:\monkey.txt；这样monkey测试结束后，所有打印的信息都会输出到这个文件里
22. 通过adb bugreport 命令可以获取整个android系统在运行过程中所有app的内存使用情况，cpu使用情况，activity运行信息等，包括出现异常等信息。使用方法 adb bugreport > bugreport.txt ;这样在当前目录就会产生一个txt文件和一个压缩包，具体信息可在压缩包查看，txt文件只会记录压缩包的生成过程信息
23. -f 加载monkey脚本文件进行测试，比如 adb shell monkey -f sdcard/monkey.txt -v -v 500

## Monkey使用
1. 进入adb目录
2. 通过adb install apk名字
3. 输入adb shell monkey -p xxx.xxxx.xxx  -s 123123 --throttle 300 -v -v 20 > d:\monkey.txt，这里指定了seed值，每个事件之间休息300ms，执行了20个事件，然后将日志信息保存在了monkey.txt文件中
4. 打开文件，查看信息

比如：
```
adb shell monkey -v -v -v -s 123123 --throttle 300 --pct-touch 40 --pct-motion 25 --pct-appswitch 25 --pct-syskeys 10 --pct-majornav 0 --pct-nav 0 --pct-trackball 0 --ignore-crashes --ignore-timeouts --ignore-native-crashes -p xxx.xxx.xxx 100000 > d:\monkey.txt
```

## [Monkey脚本](https://github.com/gb112211/Android-Platform-Development/blob/master/cmds/monkey/src/com/android/commands/monkey/MonkeySourceScript.java)
### 脚本格式如下：
```text
type= raw events
count= 1
speed= 1.0   
start data >>   
 
LaunchActivity(pkg_name, cl_name) 
```
1. 第一句到第三句就使用默认值，不需要改，其实这里设置是无效的，最终会采用命令行里的值；
2. start data >> 表示开始执行下面所有的命令行
3. LaunchActivity就是一个启动应用的命令

### 脚本命令
1. LaunchActivity(pkg_name, cl_name)： 启动应用，第一个参数是包名，第二个是启动的activity名
2. DispatchPointer(downtime,eventTime,action,x,y,xpressure,size,metastate,xPrecision,yPrecision,device,edgeFlags) ：向指定位置发送单个手势，相当于我们把手指按在某个点上；这个方法参数有12个，但是我们主要关注owntime,eventTime,action,x,y这么几个参数，x，y表示按下的坐标，可以通过上一篇文章UI Automator获取，这在你想测试点击某个具体view是很有用的
3. DispatchPress(keycode)： 向系统发送一个固定的按键事件；例如home键，back键；参数是按键值 ，按键值可查看keycode
4. UserWait：让脚本的执行暂停一段时间，做一个等待操作
5. RotateScreen(rotationDegree, persist)： 翻转屏幕，第一个参数是旋转角度，第二个是旋转后是否停在当前位置
6. Tap(x, y) ：单击事件，点击屏幕，参数是点击坐标
7. Drag(xStart, yStart, xEnd, yEnd) ：在屏幕上滑动，坐标是从哪一点滑到哪一点
8. LongPress()： 长按2s
9. ProfileWait()： 等待5s
10. PressAndHold(x, y, pressDuration) ：模拟长按 
11. PinchZoom(x1Start, y1Start, x1End, y1End, x2Start, y2Start, x2End, y2End, stepCount)： 模拟缩放
12. DispatchString(input)： 输入字符串
13. RunCmd(cmd) ：执行shell命令，比如截图 screencap -p /data/local/tmp/tmp.png
14. DispatchFlip(true/false) ：打开或者关闭软键盘
15. UserWait(sleepTime) ：睡眠指定时间
16. DeviceWakeUp() ：唤醒屏幕

### 常用命令解释
1. DispatchTrackball命令(轨迹球事件)
DispatchTrackball(long downtime,long eventide,int action,float x,float y,float pressure,float size,int metastate,float xprecision,float yprecision,int device,int edgefalgs)
downtime:按下的时间
evetide:事件发生的时间
action:0 代表按下,1 代表弹起
x:x坐标点
y:y坐标点
pressure:当前压力事件的大小,范围是0-1
size:触摸的一个及时值,范围0-1
metastate:当前按下meta键的标识
xprecision:x的坐标的精确值
yprecision:y的坐标的精确值
device:设备来源, 0表示不来自物理设备,
edgeflags:指的是超出屏幕的范围
这里我们只关注3个参数,action,x,y,其他的参数在使用命令的时候设置上一个默认的初始值就好了

2. DispatchPointer命令(点击事件)
DispatchPointer(long downtime,long eventide,int action,float x,float y,float pressure,float size,int metastate,float xprecision,float yprecision,int device,int edgefalgs)
和DiapatchTrackball命令一样主要关注3个参数,action,x,y
action:0 代表按下,1 代表弹起
x:x坐标点
y:y坐标点

3. DispatchString命令(输入字符串事件)
DispatchString(String text);

4. LaunchActivity命令(启动应用)
LaunchActicity(packge,Activity)

5. UserWait命令(等待事件)
Userwait(1000)

6. DispatchPress命令(按下键值)
DispatchPress(int keycode) 回车键的keycode为66

### 示例
```text

type= raw events
count= 1
speed= 1.0   
start data >>   
 
LaunchActivity(com.android.mangodialog,com.android.mangodialog.MainActivity);
UserWait(1000);
# 按下
DispatchPointer(0,0,0,400,500,0,0,0,0,0,0,0) 
# 抬起
DispatchPointer(0,0,1,400,500,0,0,0,0,0,0,0) 
UserWait(1000);
 
Tab(500,300);
UserWait(1000);
 
DispatchPress(KEYCODE_ENTER)
UserWait(1000);
 
DispatchPress(KEYCODE_BACK);
UserWait(1000);
 
RunCmd(screencap -p /sdcard/tmp.png);
UserWait(1000);
 
Drag(0, 0, 500, 500);
UserWait(1000);
 
RotateScreen(90,1)
UserWait(1000);
 
DispatchString(www.baidu.com);
UserWait(1000);
 
DispatchPress(KEYCODE_BACK);
UserWait(1000);
```
1. 脚本需要对照着MonkeySourceScript.java文件编写，这样才能知道方法需要多少个参数，参数有什么含义；同时要注意方法名是区分大小写的，其实最重要的是脚本的编写需要根据你的测试用例来写，一步步怎么操作就写上对应的方法
2. 因为Monkey是运行在设备上的，所以需要将脚本先传到设备上，通过`adb push d:\monkey.txt sdcard/monkey.txt` 将文件推送到手机sd卡上
3. 最后通过`adb shell monkey -f 脚本文件 次数` 执行脚本文件。如`adb shell monkey -f sdcard/monkey.txt -v -v 1`