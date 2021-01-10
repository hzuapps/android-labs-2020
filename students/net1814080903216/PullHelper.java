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
