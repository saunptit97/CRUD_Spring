package com.tutorialspoint;

public class Client {
   private Integer age;
   private String name;
   private Integer id;
   private String description;

   public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public void setAge(Integer age) {
      this.age = age;
   }
   public Integer getAge() {
      return age;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }
   public void setId(Integer id) {
      this.id = id;
   }
   public Integer getId() {
      return id;
   }
}