// IMyService.aidl
package com.sily.dhwdemo.aidl;
import com.sily.dhwdemo.aidl.Student;
// Declare any non-default types here with import statements

interface IMyService {
  List<Student> getStudent();
  void addStudent(inout Student student);
}
