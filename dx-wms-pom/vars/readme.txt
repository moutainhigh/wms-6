vars文件里的变量定义用于对工程中的静态文件（html,js,css）进行替换，我们一共准备了3套变量，
分别是DEV、SIT、和PRE，maven在打包前会对src/main/webapp下的静态资源文件中的变量进
行替换。

mvn clean install -DskipTests -Ppre