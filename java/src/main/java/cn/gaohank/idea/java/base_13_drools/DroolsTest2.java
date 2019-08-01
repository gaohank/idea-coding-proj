package cn.gaohank.idea.java.base_13_drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

public class DroolsTest2 {
    public static void main(String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kc.newKieSession( "TemplatesKS" );
        // now create some test data
        ksession.insert( new Cheese( "stilton", 42 ) );
        ksession.insert( new PersonForTemplate( "michael", "stilton", 42 ) );
        final List<String> list = new ArrayList<>();
        ksession.setGlobal( "list", list );

        int i = ksession.fireAllRules();

        System.out.println("集合："+list);
        System.out.println("执行了规则："+i);

        ksession.dispose();
    }
}
