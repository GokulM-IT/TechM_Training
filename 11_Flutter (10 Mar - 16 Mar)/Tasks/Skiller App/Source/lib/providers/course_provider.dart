import 'package:flutter/material.dart';
import '../services/firebase_service.dart';

class CourseProvider with ChangeNotifier {
  List<Map<String, dynamic>> _courses = [];

  List<Map<String, dynamic>> get courses => _courses;

  Future<void> fetchCourses() async {
    _courses = await FirebaseService.getCourses();
    notifyListeners();
  }

  void addCourse(Map<String, dynamic> course) {
    _courses.add(course);
    notifyListeners();
  }

  void removeCourse(String courseId) {
    _courses.removeWhere((course) => course['id'] == courseId);
    notifyListeners();
  }
}
