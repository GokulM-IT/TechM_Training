import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';
import 'recipe_model.dart';

class RecipeDatabase {
  static Database? _database;

  // Open the database
  static Future<Database> getDatabase() async {
    if (_database != null) return _database!;

    _database = await openDatabase(
      join(await getDatabasesPath(), 'recipes.db'),
      onCreate: (db, version) {
        return db.execute(
          'CREATE TABLE recipes(id INTEGER PRIMARY KEY, name TEXT, category TEXT, instructions TEXT)',
        );
      },
      version: 1,
    );
    return _database!;
  }

  // Insert a new recipe
  static Future<void> insertRecipe(Recipe recipe) async {
    final db = await getDatabase();
    await db.insert(
      'recipes',
      recipe.toMap(),
      conflictAlgorithm: ConflictAlgorithm.replace,
    );
  }

  // Method to delete a recipe
  static Future<void> deleteRecipe(int id) async {
    final db = await getDatabase();
    await db.delete('recipes', where: 'id = ?', whereArgs: [id]);
  }

  // Get all recipes
  static Future<List<Recipe>> getAllRecipes() async {
    final db = await getDatabase();
    final List<Map<String, dynamic>> maps = await db.query('recipes');
    return List.generate(maps.length, (i) {
      return Recipe.fromMap(maps[i]);
    });
  }
}
