# XML简介

## 1. XML是什么？

XML是指可扩展标记语言，它支持通过标签来描述复杂数据。

## 2. XML示例

```  
<xml>
  <!-- 学生数组 -->
  <students>
    <!-- 第1个学生 -->
    <student>
      <id>123456</id>
      <name>Tom</name>
      <age>19</age>
      <courses>
        <course>Android</course>
        <course>Web</course>
      </courses>
    </student>
    <!-- 第2个学生 -->
    <student>
      <id>789101112</id>
      <name>李同学</name>
      <age>19</age>
      <courses>
        <course>Android</course>
        <course>Web</course>
      </courses>
    </student>
  </students>
</xml>
```  

## 3. XML语法要点

（1）标签以 < > 表示，必须成对出现，名称严格匹配；  
（2）可以表示多个数据项（数组）或单个数据项。  
