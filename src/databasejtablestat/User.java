/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasejtablestat;

/**
 *
 * @author Arm_AVI
 */
public class User {
    private int id;
    private String Name;
    private String Age;
    private String gender;
    private String BirthPlace;
    private String Fathername;
    private String Mothername;
    private String Address;
    private String Email;
    private String PostCode;
    private String CourseName;
    private String Semester;
    private String AddmissionYear;
    private String Contact;
    private String Birthdate;
    
    public User(int id,String Name,String Age,String gender,String BirthPlace,String Fathername, String Motherame, String Address, String Email, String PostCode,String CourseName, String Semester, String AddmissionYear,String Contact,String Birthdate)
    {
        this.id = id;
        this.Name = Name;
        this.Age = Age;
        this.gender = gender;
        this.BirthPlace = BirthPlace;
        this.Fathername = Fathername;
        this.Mothername = Motherame;
        this.Address = Address;
        this.Email = Email;
        this.PostCode = PostCode;
        this.CourseName = CourseName;
        this.Semester = Semester;
        this.AddmissionYear = AddmissionYear;
        this.Contact = Contact;
        this.Birthdate = Birthdate;
      
    }
    
    public int getid()
    {
        return id;
    }
    
    public String getName()
    {
        return Name;
    }
    
    public String getAge()
    {
        return Age;
    }
    
     public String getGender()
    {
        return gender;
    }
     public String getbirthPlace()
    {
        return BirthPlace;
    }
     public String getfatherName()
     {
        return Fathername;
     }
     public String getmotherName()
     {
        return Mothername;
     }
      public String getaddress()
     {
        return Address;
     }
      public String getEmail()
     {
        return Email;
     }
      
      public String getPostCode()
     {
        return PostCode;
     }
    
      public String getCourseName()
     {
        return CourseName;
     }
      public String getSemester()
     {
        return Semester;
     }
      public String getAddmissionYear()
     {
        return AddmissionYear;
     }
     public String getContact()
     {
        return Contact;
     }
      public String getBirthdate()
      {
        return Birthdate;
      }
  
   
}
