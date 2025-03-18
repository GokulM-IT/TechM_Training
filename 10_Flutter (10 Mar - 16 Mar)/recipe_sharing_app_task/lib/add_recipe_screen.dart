import 'package:flutter/material.dart';
import 'recipe_database.dart';
import 'recipe_model.dart';

class AddRecipeScreen extends StatefulWidget {
  const AddRecipeScreen({super.key});

  @override
  State<AddRecipeScreen> createState() => _AddRecipeScreenState();
}

class _AddRecipeScreenState extends State<AddRecipeScreen> {
  final _formKey = GlobalKey<FormState>();
  final _nameController = TextEditingController();
  final _categoryController = TextEditingController();
  final _instructionsController = TextEditingController();

  // Method to add the recipe to the database
  _addRecipe() async {
    if (_formKey.currentState?.validate() ?? false) {
      var newRecipe = Recipe(
        name: _nameController.text,
        category: _categoryController.text,
        instructions: _instructionsController.text,
      );
      await RecipeDatabase.insertRecipe(newRecipe);

      // Safely using context to pop and show SnackBar
      if (mounted) {
        Navigator.pop(context); // Navigate back to the home screen
        ScaffoldMessenger.of(
          context,
        ).showSnackBar(SnackBar(content: Text('Recipe Added!')));
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Add New Recipe")),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                controller: _nameController,
                decoration: InputDecoration(labelText: "Recipe Name"),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter recipe name.';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: _categoryController,
                decoration: InputDecoration(labelText: "Category"),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter category.';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: _instructionsController,
                decoration: InputDecoration(labelText: "Instructions"),
                maxLines: 5,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter instructions.';
                  }
                  return null;
                },
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: _addRecipe, // Trigger add recipe
                child: Text("Add Recipe"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
