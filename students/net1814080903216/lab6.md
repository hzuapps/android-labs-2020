##  一、实验目标

1.	掌握Android网络访问方法；
2.	理解XML和JSON表示数据的方法。

## 二、实验内容

1.  创建本地xml文件；
2.	对下载类对应的.xml进行界面设计；
3.	创建相应功能类。
4.	完善相关的方法。


## 三、实验步骤

1. 在main目录创建assets目录，然后再assets创建要解析的XML文件
```
<?xml version="1.0" encoding="UTF-8"?>
<persons>
    <person id = "11">
        <name>黄伟健（SAX解析）</name>
        <age>18</age>
    </person>
    <person id = "13">
        <name>黄伟健2</name>
        <age>19</age>
    </person>
    <person id = "14">
        <name>黄伟健3</name>
        <age>20</age>
    </person>
</persons>
```

2. 创建Sax解析类、Dom解析类和PULL解析类文件
Sax:
```
package edu.hzuapps.androidlabs.net1814080903216;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SaxHelper extends DefaultHandler {
    private Person person;
    private ArrayList<Person> persons;
    //当前解析的元素标签
    private String tagName = null;

    /**
     * 当读取到文档开始标志是触发，通常在这里完成一些初始化操作
     */
    @Override
    public void startDocument() throws SAXException {
        this.persons = new ArrayList<Person>();
        Log.i("SAX", "读取到文档头,开始解析xml");
    }


    /**
     * 读到一个开始标签时调用,第二个参数为标签名,最后一个参数为属性数组
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (localName.equals("person")) {
            person = new Person();
            person.setId(Integer.parseInt(attributes.getValue("id")));
            Log.i("SAX", "开始处理person元素~");
        }
        this.tagName = localName;
    }


    /**
     * 读到到内容,第一个参数为字符串内容,后面依次为起始位置与长度
     */

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        //判断当前标签是否有效
        if (this.tagName != null) {
            String data = new String(ch, start, length);
            //读取标签中的内容
            if (this.tagName.equals("name")) {
                this.person.setName(data);
                Log.i("SAX", "处理name元素内容");
            } else if (this.tagName.equals("age")) {
                this.person.setAge(Integer.parseInt(data));
                Log.i("SAX", "处理age元素内容");
            }

        }

    }

    /**
     * 处理元素结束时触发,这里将对象添加到结合中
     */
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (localName.equals("person")) {
            this.persons.add(person);
            person = null;
            Log.i("SAX", "处理person元素结束~");
        }
        this.tagName = null;
    }

    /**
     * 读取到文档结尾时触发，
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        Log.i("SAX", "读取到文档尾,xml解析结束");
    }

    //获取persons集合
    public ArrayList<Person> getPersons() {
        return persons;
    }

}

```
Dom：
```
package edu.hzuapps.androidlabs.net1814080903216;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomHelper {
    public static ArrayList<Person> queryXML(Context context)
    {
        ArrayList<Person> Persons = new ArrayList<Person>();
        try {
            //①获得DOM解析器的工厂示例:
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //②从Dom工厂中获得dom解析器
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            //③把要解析的xml文件读入Dom解析器
            Document doc = dbBuilder.parse(context.getAssets().open("person2.xml"));
            System.out.println("处理该文档的DomImplemention对象=" + doc.getImplementation());
            //④得到文档中名称为person的元素的结点列表
            NodeList nList = doc.getElementsByTagName("person");
            //⑤遍历该集合,显示集合中的元素以及子元素的名字
            for(int i = 0;i < nList.getLength();i++)
            {
                //先从Person元素开始解析
                Element personElement = (Element) nList.item(i);
                Person p = new Person();
                p.setId(Integer.valueOf(personElement.getAttribute("id")));

                //获取person下的name和age的Note集合
                NodeList childNoList = personElement.getChildNodes();
                for(int j = 0;j < childNoList.getLength();j++)
                {
                    Node childNode = childNoList.item(j);
                    //判断子note类型是否为元素Note
                    if(childNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element childElement = (Element) childNode;
                        if("name".equals(childElement.getNodeName()))
                            p.setName(childElement.getFirstChild().getNodeValue());
                        else if("age".equals(childElement.getNodeName()))
                            p.setAge(Integer.valueOf(childElement.getFirstChild().getNodeValue()));
                    }
                }
                Persons.add(p);
            }
        } catch (Exception e) {e.printStackTrace();}
        return Persons;
    }
}

```
PULL：
```
package edu.hzuapps.androidlabs.net1814080903216;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2015/9/8 0008.
 */
public class PullHelper {
    public static ArrayList<Person> getPersons(InputStream xml) throws Exception {
        //XmlPullParserFactory pullPaser = XmlPullParserFactory.newInstance();
        ArrayList<Person> persons = null;
        Person person = null;
        // 创建一个xml解析的工厂
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        // 获得xml解析类的引用
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(xml, "UTF-8");
        // 获得事件的类型
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    persons = new ArrayList<Person>();
                    break;
                case XmlPullParser.START_TAG:
                    if ("person".equals(parser.getName())) {
                        person = new Person();
                        // 取出属性值
                        int id = Integer.parseInt(parser.getAttributeValue(0));
                        person.setId(id);
                    } else if ("name".equals(parser.getName())) {
                        String name = parser.nextText();// 获取该节点的内容
                        person.setName(name);
                    } else if ("age".equals(parser.getName())) {
                        int age = Integer.parseInt(parser.nextText());
                        person.setAge(age);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("person".equals(parser.getName())) {
                        persons.add(person);
                        person = null;
                    }
                    break;
            }
            eventType = parser.next();
        }
        return persons;
    }

    public static void save(List<Person> persons, OutputStream out) throws Exception {
        XmlSerializer serializer = Xml.newSerializer();
        serializer.setOutput(out, "UTF-8");
        serializer.startDocument("UTF-8", true);
        serializer.startTag(null, "persons");
        for (Person p : persons) {
            serializer.startTag(null, "person");
            serializer.attribute(null, "id", p.getId() + "");
            serializer.startTag(null, "name");
            serializer.text(p.getName());
            serializer.endTag(null, "name");
            serializer.startTag(null, "age");
            serializer.text(p.getAge() + "");
            serializer.endTag(null, "age");
            serializer.endTag(null, "person");
        }

        serializer.endTag(null, "persons");
        serializer.endDocument();
        out.flush();
        out.close();
    }


}

```
3. 界面设计代码：
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/LinearLayout1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnsax"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="SAX解析xml" />

        <Button
            android:id="@+id/btndom"
            android:layout_width="311dp"
            android:layout_height="wrap_content"
            android:text="Dom解析xml" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button
            android:id="@+id/btnpullread"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="pull解析xml" />

        <Button
            android:id="@+id/btnpullwrite"
            android:layout_width="297dp"
            android:layout_height="wrap_content"
            android:text="pull生成xml" />
    </LinearLayout>

    <ListView
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />


</LinearLayout>

```

## 四、实验结果

![image](https://github.com/Xiaohuang-12/android-labs-2020/blob/master/students/net1814080903216/lab6-01.png)
![image](https://github.com/Xiaohuang-12/android-labs-2020/blob/master/students/net1814080903216/lab6-02.png)
![image](https://github.com/Xiaohuang-12/android-labs-2020/blob/master/students/net1814080903216/lab6-03.png)
![image](https://github.com/Xiaohuang-12/android-labs-2020/blob/master/students/net1814080903216/lab6-04.png)

## 五、实验心得体会
这次实验，实现了解析xml文件的功能，在本地创建xml文件，但是也可以解析网络xml文件，但是我不是很会修改代码来实现，但这也可以实现我的一个小小功能
