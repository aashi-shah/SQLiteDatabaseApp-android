package com.example.sqlitedatabaseapp;

public class UserModel {
   private String userid;
   private String userfirstname;
   private String userlastname;
   private String phone;
   private String email;
   private String password;

   public String getUserid() {
      return userid;
   }

   public void setUserid(String userid) {
      this.userid = userid;
   }

   public String getUserfirstname() {
      return userfirstname;
   }

   public void setUserfirstname(String userfirstname) {
      this.userfirstname = userfirstname;
   }

   public String getUserlastname() {
      return userlastname;
   }

   public void setUserlastname(String userlastname) {
      this.userlastname = userlastname;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }


}
