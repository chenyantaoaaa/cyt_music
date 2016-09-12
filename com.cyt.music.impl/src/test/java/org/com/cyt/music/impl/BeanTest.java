package org.com.cyt.music.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.apache.commons.beanutils.BeanUtils;

import bean.MusicInfoT;

import com.cyt.music.interfaces.pojo.music.MusicInfo;

public class BeanTest {
	
	public static void test1(){
		MusicInfo info1=new MusicInfo();
		MusicInfoT info2=new MusicInfoT();
		info1.setAuthor("zzzz");
		info1.setAlbum("ssssss");
		info1.setTitle("ttttt");
		
		try {
			BeanUtils.copyProperties(info2, info1);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(info1);
		System.err.println(info2);
	}
	
	public static void test2() throws ClassNotFoundException{
		Class<?> class1=Class.forName("com.cyt.music.interfaces.pojo.music.MusicInfo");
		Class<MusicInfo> class2=MusicInfo.class;
		MusicInfo info=new MusicInfo();
		Class<?> class3=info.getClass();
		System.err.println(class1);
		System.err.println(class2);
		System.err.println(class3);
	}
	
	public static void test3(){
		//获取整个类  
        Class c;
		try {
			c = Class.forName("java.lang.Integer");
	          //获取所有的属性?  
	        Field[] fs = c.getDeclaredFields();  
	   
	               //定义可变长的字符串，用来存储属性  
	        StringBuffer sb = new StringBuffer();  
	        //通过追加的方法，将每个属性拼接到此字符串中  
	        //最外边的public定义  
	        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");  
	        //里边的每一个属性  
	        for(Field field:fs){  
	            sb.append("\t");//空格  
	            sb.append(Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等  
	            sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字  
	            sb.append(field.getName()+";\n");//属性的名字+回车  
	        }  
	  
	        sb.append("}");  
	  
	        System.out.println(sb);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void test4() throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException{
		MusicInfo ms1=new MusicInfo();
		MusicInfo ms2=new MusicInfo();
		ms1.setId(1);
		ms1.setAlbum("aa");
		ms1.setAuthor("bb");
		ms1.setRemark("cc");
		ms1.setImage("dd");
		copyProperties(ms1,ms2);
		System.err.println(ms1);
		System.err.println(ms2);
	}
	
	public static  Object copyProperties(Object source,Object target) throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException{
		Class<?> cls=source.getClass();
		
		Object obj=cls.newInstance();
		//取到对象所有属性
		Field [] fields=cls.getDeclaredFields();
//		System.err.println(Arrays.toString(field));
		for (Field field : fields) {
			//取到所有属性名
			String fieldName=field.getName();
			//取到属性名首字母并大写
			String firstLetter=fieldName.substring(0, 1).toUpperCase();
			//拼接get方法
			String getMethorName="get"+firstLetter+fieldName.substring(1);
			//得到get方法对象
			Method getMethod=cls.getMethod(getMethorName);
			//获取属性值
			Object value = getMethod.invoke(source);
			
			//拼接set方法
			String setMethodName = "set" + firstLetter + fieldName.substring(1);
			//得到set方法对象
			Method setMethod=cls.getMethod(setMethodName, new Class[] { field.getType() });
			//写入值
			setMethod.invoke(target, new Object[] { value });
//			System.err.println(getMethorName);
		}
		return target;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, ClassNotFoundException{

		test2();
	}
}
