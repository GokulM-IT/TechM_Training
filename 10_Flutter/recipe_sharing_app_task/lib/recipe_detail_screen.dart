import 'package:flutter/material.dart';
import 'recipe_model.dart';
import 'recipe_database.dart';

class RecipeDetailScreen extends StatelessWidget {
  const RecipeDetailScreen({super.key});

  _deleteRecipe(BuildContext context, Recipe recipe) async {
    await RecipeDatabase.deleteRecipe(recipe.id!);
    ScaffoldMessenger.of(
      // ignore: use_build_context_synchronously
      context,
    ).showSnackBar(SnackBar(content: Text('Recipe deleted!')));
    // ignore: use_build_context_synchronously
    Navigator.pop(context); // Go back to the home screen
  }

  @override
  Widget build(BuildContext context) {
    final Recipe recipe = ModalRoute.of(context)!.settings.arguments as Recipe;

    return Scaffold(
      appBar: AppBar(
        title: Text(recipe.name),
        foregroundColor: const Color.fromARGB(255, 197, 58, 15),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              "Category: ${recipe.category}",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 10),
            Text(
              "Instructions:",
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 10),
            Text(recipe.instructions),
            SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                ElevatedButton(
                  onPressed: () {
                    Navigator.pushNamed(
                      context,
                      '/editRecipe',
                      arguments: recipe,
                    );
                  },
                  style: ElevatedButton.styleFrom(
                    backgroundColor: const Color.fromARGB(255, 33, 97, 1),
                    foregroundColor: Colors.white,
                  ),
                  child: Text('Edit'),
                ),
                ElevatedButton(
                  onPressed: () {
                    _deleteRecipe(context, recipe);
                  },
                  style: ElevatedButton.styleFrom(
                    backgroundColor: const Color.fromARGB(255, 131, 9, 1),
                    foregroundColor: Colors.white,
                  ),
                  child: Text('Delete'),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
