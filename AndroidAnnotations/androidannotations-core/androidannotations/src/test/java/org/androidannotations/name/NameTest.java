package org.androidannotations.name;

import java.io.File;

import org.androidannotations.internal.AndroidAnnotationProcessor;
import org.androidannotations.testutils.AAProcessorTestHelper;

import org.junit.Before;
import org.junit.Test;



public class NameTest extends AAProcessorTestHelper {

	@Before
	public void setUp() throws Exception {
		addManifestProcessorParameter(ActivityWithName.class);
		addProcessor(AndroidAnnotationProcessor.class);
	}

	@Test
	public void testClassName() throws Exception {
		CompileResult result = compileFiles(ActivityWithName.class);
		assertCompilationSuccessful(result);
		File output = new File(OUTPUT_DIRECTORY, toPath(ActivityWithName.class.getPackage()) + "/" + "NamedActivity" + SOURCE_FILE_SUFFIX);
		assertGeneratedClassContains(output, new String[]{"public final class NamedActivity"});
	}

	@Test
	public void testBeanName() throws Exception {
		CompileResult result = compileFiles(BeanWithName.class);
		assertCompilationSuccessful(result);
	}
}
