package cn.gaohank.idea.java.base_13_drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {
    public static void main(String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kc.newKieSession( "ksession-rules" );
        Order.Person p1 = new Order.Person();
        p1.setAge(32);
        Order.Car car = new Order.Car();
        car.setPerson(p1);

        ksession.insert(car);//插入到working memory

        int count = ksession.fireAllRules();//通知规则引擎执行规则
        System.out.println(count);
        System.out.println(car.getDiscount());

        ksession.dispose();
    }
}
