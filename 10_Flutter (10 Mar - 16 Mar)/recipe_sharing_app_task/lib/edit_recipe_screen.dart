import 'package:flutter/material.dart';
import 'recipe_model.dart';
import 'recipe_database.dart';

class EditRecipeScreen extends StatefulWidget {
  const EditRecipeScreen({super.key});

  @override
  State<EditRecipeScreen> createState() => _EditRecipeScreenState();
}

class _EditRecipeScreenState extends State<EditRecipeScreen> {
  final _formKey = GlobalKey<FormState>();
  late TextEditingController _nameController;
  late TextEditingController _categoryController;
  late TextEditingController _instructionsController;

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    final Recipe recipe = ModalRoute.of(context)!.settings.arguments as Recipe;

    _nameController = TextEditingController(text: recipe.name);
    _categoryController = TextEditingController(text: recipe.category);
    _instructionsController = TextEditingController(text: recipe.instructions);
  }

  // Method to update the recipe in the database
  _updateRecipe() async {
    if (_formKey.currentState?.validate() ?? false) {
      var updatedRecipe = Recipe(
        id: (ModalRoute.of(context)!.settings.arguments as Recipe).id,
        name: _nameController.text,
        category: _categoryController.text,
        instructions: _instructionsController.text,
      );

      await RecipeDatabase.insertRecipe(
        updatedRecipe,
      ); // Reuse the insert method to update

      // ignore: use_build_context_synchronously
      Navigator.pop(context); // Go back to the home screen
      ScaffoldMessenger.of(
        // ignore: use_build_context_synchronously
        context,
      ).showSnackBar(SnackBar(content: Text('Recipe updated!')));
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Edit Recipe')),
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
                onPressed: _updateRecipe, // Trigger update recipe
                child: Text("Update Recipe"),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
