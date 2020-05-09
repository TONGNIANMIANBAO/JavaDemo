package com.testJDK16.j2006;

import java.io.File;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestScripting {

	/**
	 * @param args
	 * @throws ScriptException
	 */
	public static void main(String[] args) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		testScriptVariables(engine);
		testInvokeMethod(engine);
		testScriptInterface(engine);
		testUsingJdkClasses(engine);
	}

	/*
	 * 演示如何暴露Java对象为脚本语言的全局变量
	 */
	private static void testScriptVariables(ScriptEngine engine)
			throws ScriptException {
		File file = new File("c:\\a.txt");
		engine.put("f", file);
		// engine.eval("alert(f.getName())");

	}

	/*
	 * 演示如何在Java中调用脚本语言的方法
	 */
	private static void testInvokeMethod(ScriptEngine engine)
			throws ScriptException, NoSuchMethodException {
		String script = "function test(name){return 'hello!'+name}";
		engine.eval(script);
		Invocable inv = (Invocable) engine;
		System.out.println(inv.invokeFunction("test", "Blizzard"));

		// 如果调用的是脚本中对象的成员方法，则需要用invokeMethod
		script = "var obj={test:function(name){return 'hello!'+name}}";
		engine.eval(script);
		Object obj = engine.get("obj");
		System.out.println(inv.invokeMethod(obj, "test", "Tencent"));

	}

	/*
	 * 演示脚本语言如何实现Java的接口
	 */
	private static void testScriptInterface(ScriptEngine engine)
			throws ScriptException {
		String script = "var obj=new Object();obj.run=function(){println('called')}";
		engine.eval(script);
		Object obj = engine.get("obj");
		Invocable inv = (Invocable) engine;
		Runnable r = inv.getInterface(obj, Runnable.class);
		new Thread(r).start();

	}

	/*
	 * 演示脚本语言如何使用JDK平台下的类
	 */
	private static void testUsingJdkClasses(ScriptEngine engine) throws ScriptException, NoSuchMethodException {
		String script = "function test(t){var f=Packages.javax.swing.JFrame(t);f.setSize(400,300);f.setVisible(true);}";
		engine.eval(script);
		Invocable inv=(Invocable) engine;
		inv.invokeFunction("test", "alibaba");

	}

}
