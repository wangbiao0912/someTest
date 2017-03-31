#!/bin/bash
#传参测试脚本
echo "项目提交: $1"
find ./ -name ".DS_Store" -exec rm {} \;
git status

if [ "$1" = "" ] ;then    
	echo "请填写提交详情    再执行脚本提交..."
	exit 1  
elif ["$1" != "" ];then
	echo "正在准备提交请等待。。。。"
	echo  '提交记录日志为：    $1'
	echo "Press any key to continue!"
	char=`get_char`
fi

git add .
git commit -m "$1"
git push origin master
echo '代码更新完成'
