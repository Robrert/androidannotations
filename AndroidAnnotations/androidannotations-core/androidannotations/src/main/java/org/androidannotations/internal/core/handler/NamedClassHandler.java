package org.androidannotations.internal.core.handler;

import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;

import org.androidannotations.AndroidAnnotationsEnvironment;
import org.androidannotations.ElementValidation;
import org.androidannotations.annotations.Name;
import org.androidannotations.handler.BaseAnnotationHandler;
import org.androidannotations.holder.BaseGeneratedClassHolder;


public class NamedClassHandler extends BaseAnnotationHandler<BaseGeneratedClassHolder> {
	public NamedClassHandler(AndroidAnnotationsEnvironment environment) {
		super(Name.class, environment);
	}

	@Override
	public void process(Element element, BaseGeneratedClassHolder holder) throws Exception {
		holder.getGeneratedClass();
	}

	@Override
	protected void validate(Element element, ElementValidation validation) {
		if (element.getAnnotation(Name.class) != null) {
			validateCustomName(element, validation);
		}
	}

	private void validateCustomName(Element element, ElementValidation validation) {
		String className = element.getAnnotation(Name.class).className();
		if (className.isEmpty()) {
			validation.addError("Class name cannot be null or empty");
		}
		if (className.contains(".")) {
			validation.addError("Class name cannot contain dots");
		}
		if (!SourceVersion.isName(className)) {
			validation.addError(String.format("%s is not valid class name", className));
		}
	}
}
