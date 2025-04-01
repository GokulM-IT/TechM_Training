import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:logger/logger.dart';

class FirebaseService {
  static final FirebaseFirestore _db = FirebaseFirestore.instance;
  // Initialize a logger instance.
  static final Logger _logger = Logger();

  // Fetch all available courses from Firestore.
  static Future<List<Map<String, dynamic>>> getCourses() async {
    try {
      final snapshot = await _db.collection('courses').get();

      return snapshot.docs
          .map((doc) {
            var data = doc.data();
            if (data['title'] != null &&
                data['instructor'] != null &&
                data['image'] != null &&
                data['price'] != null) {
              return {
                // Store document ID for future reference.
                'id': doc.id,
                ...data,
              };
            }
            return null;
          })
          .where((course) => course != null)
          .cast<Map<String, dynamic>>()
          .toList();
    } catch (e) {
      _logger.e("Error fetching courses: $e");
      return [];
    }
  }

  // Add a new course to Firestore, linked to the current user.
  static Future<void> addCourse(Map<String, dynamic> courseData) async {
    final user = FirebaseAuth.instance.currentUser;

    if (user != null) {
      // Add the current user's ID to the course data.
      courseData['userId'] = user.uid;

      try {
        await _db.collection('courses').add(courseData);
      } catch (e) {
        _logger.e("Error adding course: $e");
        throw Exception("Error adding course");
      }
    } else {
      throw Exception("No logged-in user found");
    }
  }

  // Delete a course from Firestore (only allowed if owned by the current user).
  static Future<void> deleteCourse(String courseId) async {
    final user = FirebaseAuth.instance.currentUser;

    if (user != null) {
      final doc = await _db.collection('courses').doc(courseId).get();
      if (doc.exists && doc.data()?['userId'] == user.uid) {
        try {
          await _db.collection('courses').doc(courseId).delete();
        } catch (e) {
          _logger.e("Error deleting course: $e");
          throw Exception("Error deleting course");
        }
      } else {
        throw Exception("Unauthorized deletion attempt");
      }
    } else {
      throw Exception("No logged-in user found");
    }
  }
}
