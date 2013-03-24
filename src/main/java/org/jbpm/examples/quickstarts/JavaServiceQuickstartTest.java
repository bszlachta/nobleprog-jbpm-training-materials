package org.jbpm.examples.quickstarts;

import java.util.HashMap;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.jbpm.test.JbpmJUnitTestCase;
import org.junit.Test;

public class JavaServiceQuickstartTest extends JbpmJUnitTestCase {

  @Test
  public void testProcess() {

	  
		try {
			KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
			kbuilder.add(ResourceFactory.newClassPathResource("quickstarts/ScriptTask.bpmn"), ResourceType.BPMN2);
			KnowledgeBase kbase = kbuilder.newKnowledgeBase();

			StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();

		    Map<String, Object> params = new HashMap<String, Object>();

		    params.put("person", new Person("krisv"));

		    ksession.startProcess("org.jbpm.examples.quickstarts.script", params);

		
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}





}