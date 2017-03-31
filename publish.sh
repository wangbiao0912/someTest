#!/bin/bash
#传参测试脚本
echo "项目提交: $1"
find ./ -name ".DS_Store" -exec rm {} \;
git status
git add .

if [ "$1" = "" ] ;then    
	echo "请填写提交详情    再执行脚本提交..."
	exit
elif ["$1" != "" ];then
	echo "正在准备提交请等待。。。。"
fi
git commit -m "$1"
git push origin master

