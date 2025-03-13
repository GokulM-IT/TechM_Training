class Recipe {
  final int? id;
  final String name;
  final String category;
  final String instructions;

  Recipe({
    this.id,
    required this.name,
    required this.category,
    required this.instructions,
  });

  // Convert Recipe object to Map (for inserting/updating)
  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'name': name,
      'category': category,
      'instructions': instructions,
    };
  }

  // Create Recipe object from Map (for reading from DB)
  factory Recipe.fromMap(Map<String, dynamic> map) {
    return Recipe(
      id: map['id'],
      name: map['name'],
      category: map['category'],
      instructions: map['instructions'],
    );
  }
}
