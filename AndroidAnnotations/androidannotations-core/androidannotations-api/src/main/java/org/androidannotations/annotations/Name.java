package org.androidannotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Use on classes that You want provide custom name, other than BaseClass + classSuffix.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Name {

	/**
	 * String name of class to be generated.
	 *
	 * @return the name of new class
	 */
	String className();

	/**
	 * Set this to true if apply default suffix to {@link Name#className()}.
	 *
	 * @return true if apply suffix to class name
	 */
	boolean applySuffix() default false;
}
