import 'package:flutter/material.dart';
import 'home_screen.dart';
import 'add_recipe_screen.dart';
import 'recipe_detail_screen.dart';
import 'edit_recipe_screen.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Recipe Sharing App',
      theme: ThemeData(
        primarySwatch: Colors.orange,
        hintColor: Colors.green,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: HomeScreen(),
      routes: {
        '/addRecipe': (context) => AddRecipeScreen(),
        '/recipeDetail': (context) => RecipeDetailScreen(),
        '/editRecipe': (context) => EditRecipeScreen(),
      },
    );
  }
}
