#!/usr/bin/env bash

while read lines
do
echo ${lines}
done < "/Users/lihao/Documents/workspace/practice/src/main/resources/users.txt"

#模拟添加用户
echo "模拟添加用户"
while read lines
do
echo username:`echo ${lines} | cut -f1 -d ' '` >> passwordFile
echo password:`echo ${lines} | cut -f2 -d ' '` >>passwordFile
done < "/Users/lihao/Documents/workspace/practice/src/main/resources/users.txt"

#echo "测试read函数"
testRead()
{
#让用户输入值
read -p "please input number:" v1 v2
echo ${v1},${v2}
}
#testRead


#测试if使用方法、文件是否存在
read -p "what file do you want to test?" filename
if [ -e ${filename} ]
then
echo "file exist" ;else
echo "file not exist"
fi
