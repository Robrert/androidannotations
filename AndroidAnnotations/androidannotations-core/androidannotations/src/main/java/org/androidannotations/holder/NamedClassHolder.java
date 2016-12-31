package org.androidannotations.holder;

import org.androidannotations.AndroidAnnotationsEnvironment;
import org.androidannotations.annotations.Name;

import javax.lang.model.element.TypeElement;

import static org.androidannotations.helper.ModelConstants.classSuffix;


public class NamedClassHolder extends BaseGeneratedClassHolder {
	public NamedClassHolder(AndroidAnnotationsEnvironment environment, TypeElement annotatedElement) throws Exception {
		super(environment, annotatedElement);
	}

	/**
	 *
	 * @return name provided in {@link Name} if present and standard generated name otherwise
	 */
	@Override
	protected String provideClassName() {
		if(annotatedElement.getAnnotation(Name.class) != null) {
			if (annotatedElement.getNestingKind().isNested()) {
				return provideSimpleName();
			} else {
				return provideQualifiedName();
			}
		} else {
			return super.provideClassName();
		}
	}

	/**
	 *
	 * @return qualified name for generated class
	 */
	private String provideQualifiedName() {
		String annotatedComponentQualifiedName = annotatedElement.getQualifiedName().toString();
		String generatedClassQualifiedName;
		int index = annotatedComponentQualifiedName.lastIndexOf(annotatedElement.getSimpleName().toString());
		generatedClassQualifiedName = annotatedComponentQualifiedName.substring(0, index) + annotatedElement.getAnnotation(Name.class).className();
		if (annotatedElement.getAnnotation(Name.class).applySuffix()) {
			generatedClassQualifiedName = annotatedComponentQualifiedName + classSuffix();
		}
		return generatedClassQualifiedName;
	}

	/**
	 *
	 * @return simple name for generated class
	 */
	private String provideSimpleName() {
		String name = annotatedElement.getAnnotation(Name.class).className();
		if (annotatedElement.getAnnotation(Name.class).applySuffix()) {
			name = name + classSuffix();
		}
		return name;
	}
}
