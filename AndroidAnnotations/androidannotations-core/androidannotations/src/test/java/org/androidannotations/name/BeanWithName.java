package org.androidannotations.name;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.Name;

/**
 * Created by Robert on 30.12.2016.
 */
@EBean
@Name(className = "NamedBean")
public class BeanWithName {

	@EBean
	@Name(className = "InnerBeanWithName")
	public static class InnerBeanWithName {

	}

}
