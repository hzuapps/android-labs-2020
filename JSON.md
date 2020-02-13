# JSON格式及文件

## 1. JSON是什么？

JSON是JavaScript对象描述符，它可以用来表示任意结构的数据。

## 2. JSON例子

```  
{
  "name": "Tom",
  "age": 19,
  "isBoy": true,
  "numbers": [1, 2, 3],
  "courses": [{
    "name": "Android",
    "teacher": "Mr. Zeng"
  }, {
    "name": "Web",
    "teacher": "曾老师"
  }]
}
```  

## 3. JSON语法要点

（1）对象（复杂数据结构）用花括号 { } 表示；  
（2）属性名（Key）一定要用双引号（表示字符串），同一个对象的属性都用逗号 , 分隔；  
（3）不同类型值，像JavaScript（或Java）里一样表示，字符串、整数、布尔值等；  
（4）数组用中括号 [ ] 表示，里面可以是普通数据，也可以是对象。  

## 4. 使用工具检查JSON格式

http://www.bejson.com/  
