#!/bin/bash
#传参测试脚本
echo "项目提交: $1"
find ./ -name ".DS_Store" -exec rm {} \;
git status
git add .
git commit -m 'some md change'
git push origin master






