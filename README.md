# BUPT-IOT-RFID-Experiment
这是北邮物联网工程系《物联网工程实践》课程作业之二 15组作业
# 运行效果
```
"C:\Program Files\Java\jdk1.8.0_111\bin\java" "-Djava.library.path=C:\Users\hp\Desktop\第三代实验箱光盘（2019改版） - 中文\学生用书\RFID实验\实验程序\JavaUhf\src\config\dll\x64" -Didea.launcher.port=7540 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.1.5\bin" -Dfile.encoding=GBK -classpath "C:\Program Files\Java\jdk1.8.0_111\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\zipfs.jar;C:\Users\hp\Desktop\第三代实验箱光盘（2019改版） - 中文\学生用书\RFID实验\实验程序\JavaUhf\bin;C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.1.5\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain com.uhf.demo.UhfDemo
connect success
result====ABCD8888630D02141670673F
epc====ABCD8888630D02141670673F
read success
epc====ABCD8888630D02141670673F
epc write success
userData====ABCD
epc====00008888630D02141670673F
user read success
epc00008888630D02141670673F
user write success
userData====0000
epc====00008888630D02141670673F
user read success
tidData====E2003412
epc====00008888630D02141670673F
tid read success
断开成功
Debug:[09-26 15:59:48 setRFModuleType 719] RF moduleType is 0
Debug:[09-26 15:59:48 setRFConnectMode 681] RF ConnectMode is 0
Debug:[09-26 15:59:48 setRFModuleType 719] RF moduleType is 0
Debug:[09-26 15:59:48 threadReceive 262] 
Debug:[09-26 15:59:48 threadParse 339] 
Debug:[09-26 15:59:48 threadCallback 170] 
Debug:[09-26 15:59:48 threadParse 350] sMaxRBFromDevLen = 22, total buffer size = 6144
Debug:[09-26 15:59:48 threadParse 350] sMaxRBFromDevLen = 81, total buffer size = 6144
Debug:[09-26 15:59:48 threadParse 350] sMaxRBFromDevLen = 86, total buffer size = 6144
Debug:[09-26 15:59:48 threadParse 350] sMaxRBFromDevLen = 124, total buffer size = 6144

Process finished with exit code 0

```
# 验证标签某项信息功能
功能表述：验证标签的某项信息（这里是EPC码），如果信息是我们需要的（这里是如果是我们指定的标签），那么进行操作，否则提示这不是我们想要的标签。
```
"C:\Program Files\Java\jdk1.8.0_111\bin\java" "-Djava.library.path=C:\Users\hp\Desktop\第三代实验箱光盘（2019改版） - 中文\学生用书\RFID实验\实验程序\JavaUhf\src\config\dll\x64" -Didea.launcher.port=7540 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.1.5\bin" -Dfile.encoding=GBK -classpath "C:\Program Files\Java\jdk1.8.0_111\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext\zipfs.jar;C:\Users\hp\Desktop\第三代实验箱光盘（2019改版） - 中文\学生用书\RFID实验\实验程序\JavaUhf\bin;C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.1.5\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain com.uhf.demo.UhfDemo
connect success
result====22228888630D02141670673F
epc====22228888630D02141670673F
read success
Not the desired tag
Not the desired tag
Not the desired tag
Not the desired tag
Not the desired tag
Not the desired tag
Not the desired tag
Not the desired tag
Not the desired tag
Not the desired tag
Not the desired tag

Process finished with exit code -1
```
