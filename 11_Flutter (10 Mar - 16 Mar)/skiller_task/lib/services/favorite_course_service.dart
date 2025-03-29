import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

class FavoriteCourseService {
  static Database? _database;

  static Future<Database> get _db async {
    if (_database != null) {
      return _database!;
    }
    _database = await _initDB();
    return _database!;
  }

  static Future<Database> _initDB() async {
    final dbPath = await getDatabasesPath();
    return await openDatabase(
      join(dbPath, 'favorite_courses.db'),
      version: 1,
      onCreate: (db, version) async {
        await db.execute('''
          CREATE TABLE favorite_courses(
            id TEXT PRIMARY KEY,
            title TEXT,
            category TEXT,
            description TEXT,
            duration TEXT,
            instructor TEXT,
            image TEXT,
            price TEXT
          )
        ''');
      },
    );
  }

  // Add a course to favorites
  static Future<void> addFavoriteCourse(Map<String, dynamic> course) async {
    final db = await _db;
    await db.insert(
      'favorite_courses',
      course,
      conflictAlgorithm: ConflictAlgorithm.replace,
    );
  }

  // Remove a course from favorites
  static Future<void> removeFavoriteCourse(String courseId) async {
    final db = await _db;
    await db.delete('favorite_courses', where: 'id = ?', whereArgs: [courseId]);
  }

  // Get all favorite courses
  static Future<List<Map<String, dynamic>>> getFavoriteCourses() async {
    final db = await _db;
    return await db.query('favorite_courses');
  }

  // Check if a course is in favorites
  static Future<bool> isFavorite(String courseId) async {
    final db = await _db;
    final result = await db.query(
      'favorite_courses',
      where: 'id = ?',
      whereArgs: [courseId],
    );
    return result.isNotEmpty;
  }
}
