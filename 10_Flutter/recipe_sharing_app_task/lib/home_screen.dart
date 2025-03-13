import 'package:flutter/material.dart';
import 'recipe_database.dart';
import 'recipe_model.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  List<Recipe> recipes = [];

  @override
  void initState() {
    super.initState();
    _loadRecipes();
  }

  _loadRecipes() async {
    var recipeList = await RecipeDatabase.getAllRecipes();
    setState(() {
      recipes = recipeList;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Recipe Sharing App')),
      body: ListView.builder(
        itemCount: recipes.length,
        itemBuilder: (context, index) {
          return Card(
            margin: EdgeInsets.all(10),
            child: ListTile(
              title: Text(recipes[index].name),
              subtitle: Text(recipes[index].category),
              onTap: () {
                Navigator.pushNamed(
                  context,
                  '/recipeDetail',
                  arguments: recipes[index],
                );
              },
            ),
          );
        },
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.pushNamed(context, '/addRecipe');
        },
        tooltip: "Add Recipe",
        child: Icon(Icons.add),
      ),
    );
  }
}
