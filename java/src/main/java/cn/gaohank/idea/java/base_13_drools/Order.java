package cn.gaohank.idea.java.base_13_drools;

public class Order {

   public static class Car {

       private int discount = 100;
       private Person person;

       public int getDiscount() {
           return discount;
       }

       public void setDiscount(int discount) {
           this.discount = discount;
       }

       public Person getPerson() {
           return person;
       }

       public void setPerson(Person person) {
           this.person = person;
       }
   }



    public static class Person {
        private String name;
        private Integer age;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}