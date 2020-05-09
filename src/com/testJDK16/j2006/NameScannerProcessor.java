package com.testJDK16.j2006;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

public class NameScannerProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		if(!roundEnv.processingOver()){
			for(Element e:roundEnv.getElementsAnnotatedWith(NameScanner.class)){
				String name=e.getSimpleName().toString();
				processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "element name: " + name);
			}			
		}
		return false;
	}

}
