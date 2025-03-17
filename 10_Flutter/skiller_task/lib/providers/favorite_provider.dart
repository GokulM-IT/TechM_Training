import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'dart:convert';

class FavoriteProvider extends ChangeNotifier {
  List<Map<String, dynamic>> _favorites = [];

  List<Map<String, dynamic>> get favorites => _favorites;

  bool isFavorite(String courseId) {
    return _favorites.any((course) => course['id'] == courseId);
  }

  void toggleFavorite(Map<String, dynamic> course) {
    if (isFavorite(course['id'])) {
      removeFavorite(course['id']);
    } else {
      _favorites.add(course);
      saveFavorites();
    }
    notifyListeners();
  }

  void removeFavorite(String courseId) {
    _favorites.removeWhere((course) => course['id'] == courseId);
    saveFavorites();
    notifyListeners();
  }

  Future<void> saveFavorites() async {
    final prefs = await SharedPreferences.getInstance();
    prefs.setString('favorites', jsonEncode(_favorites));
  }

  Future<void> loadFavorites() async {
    final prefs = await SharedPreferences.getInstance();
    String? favoritesString = prefs.getString('favorites');
    if (favoritesString != null) {
      _favorites = List<Map<String, dynamic>>.from(jsonDecode(favoritesString));
      notifyListeners();
    }
  }
}
