import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:provider/provider.dart';
import '../providers/favorite_provider.dart';
import '../providers/course_provider.dart';
import '../localization/app_localizations.dart';
import '../services/firebase_service.dart';

class CourseDetailsScreen extends StatefulWidget {
  final Map<String, dynamic> course;

  const CourseDetailsScreen({super.key, required this.course});

  @override
  State<CourseDetailsScreen> createState() => _CourseDetailsScreenState();
}

class _CourseDetailsScreenState extends State<CourseDetailsScreen> {
  @override
  Widget build(BuildContext context) {
    final favoriteProvider = Provider.of<FavoriteProvider>(context);
    final String currentUserId = FirebaseAuth.instance.currentUser?.uid ?? '';
    final localizations = AppLocalizations.of(context);
    bool isFavorite = favoriteProvider.isFavorite(widget.course['id']);

    // Split the description into bullet points.
    final String descriptionText = widget.course['description'];
    List<String> descriptionItems = descriptionText.split('\n');

    // If there's only a single line, try splitting by a period.
    if (descriptionItems.length == 1) {
      descriptionItems = descriptionText.split('. ');
    }

    // Filter out empty strings.
    descriptionItems =
        descriptionItems.where((item) => item.trim().isNotEmpty).toList();

    return Scaffold(
      body: Container(
        width: double.infinity,
        decoration: BoxDecoration(
          gradient: LinearGradient(
            colors: [Colors.pink.shade50, Colors.white],
            begin: Alignment.topCenter,
            end: Alignment.bottomCenter,
          ),
        ),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              // Top course image with rounded bottom corners.
              ClipRRect(
                borderRadius: const BorderRadius.only(
                  bottomLeft: Radius.circular(20),
                  bottomRight: Radius.circular(20),
                ),
                child: AspectRatio(
                  aspectRatio: 16 / 9,
                  child: Image.network(
                    widget.course['image'],
                    width: double.infinity,
                    fit: BoxFit.cover,
                  ),
                ),
              ),
              // Course details section.
              Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    // Title & Heart Icon Row.
                    Row(
                      children: [
                        Expanded(
                          child: Text(
                            widget.course['title'],
                            style: const TextStyle(
                              fontSize: 28,
                              fontWeight: FontWeight.bold,
                              color: Colors.black87,
                            ),
                          ),
                        ),
                        IconButton(
                          icon: Icon(
                            isFavorite ? Icons.favorite : Icons.favorite_border,
                            size: 32,
                            color: isFavorite ? Colors.red : Colors.black,
                          ),
                          onPressed: () {
                            favoriteProvider.toggleFavorite(widget.course);
                          },
                        ),
                      ],
                    ),
                    const SizedBox(height: 8),
                    // Instructor name.
                    Text(
                      widget.course['instructor'],
                      style: TextStyle(fontSize: 18, color: Colors.grey[700]),
                    ),
                    const SizedBox(height: 25),
                    // Price (without label).
                    Text(
                      "₹${widget.course['price']}",
                      style: const TextStyle(
                        fontSize: 22,
                        fontWeight: FontWeight.bold,
                        color: Colors.black,
                      ),
                    ),
                    const SizedBox(height: 25),
                    // "What you'll learn" header.
                    const Text(
                      "What you'll learn",
                      style: TextStyle(
                        fontSize: 20,
                        fontWeight: FontWeight.bold,
                        color: Colors.black87,
                      ),
                    ),
                    const SizedBox(height: 16),
                    // Course description as bullet points.
                    Padding(
                      padding: const EdgeInsets.symmetric(horizontal: 12.0),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children:
                            descriptionItems.map((item) {
                              return Padding(
                                padding: const EdgeInsets.symmetric(
                                  vertical: 4.0,
                                ),
                                child: Row(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: [
                                    const Icon(
                                      Icons.check,
                                      color: Colors.grey,
                                      size: 20,
                                    ),
                                    const SizedBox(width: 8),
                                    Expanded(
                                      child: Text(
                                        item.trim(),
                                        style: const TextStyle(
                                          fontSize: 16,
                                          color: Colors.black,
                                          height: 1.5,
                                        ),
                                      ),
                                    ),
                                  ],
                                ),
                              );
                            }).toList(),
                      ),
                    ),
                    const SizedBox(height: 100),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
      // Bottom bar: show delete button for owner, enroll button otherwise.
      bottomNavigationBar: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 30),
        child:
            (widget.course['userId'] == currentUserId)
                ? SizedBox(
                  width: double.infinity,
                  child: ElevatedButton(
                    style: ElevatedButton.styleFrom(
                      padding: const EdgeInsets.symmetric(vertical: 16),
                      backgroundColor: Colors.red,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(20),
                      ),
                    ),
                    onPressed: () async {
                      // Cache the provider and ScaffoldMessenger before awaiting.
                      final courseProvider = Provider.of<CourseProvider>(
                        context,
                        listen: false,
                      );
                      final scaffoldMessenger = ScaffoldMessenger.of(context);

                      try {
                        await FirebaseService.deleteCourse(widget.course['id']);

                        // Ensure widget is still mounted.
                        if (!mounted) return;

                        // Refresh course list.
                        courseProvider.fetchCourses();
                        if (!mounted) return;

                        // Navigate back after deletion.
                        Navigator.pop(context);
                      } catch (e) {
                        if (!mounted) return;
                        scaffoldMessenger.showSnackBar(
                          SnackBar(
                            content: Text(
                              "Error deleting course: ${e.toString()}",
                            ),
                          ),
                        );
                      }
                    },
                    child: Text(
                      localizations?.translate('delete') ?? 'Delete',
                      style: const TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                        color: Colors.white,
                      ),
                    ),
                  ),
                )
                : SizedBox(
                  width: double.infinity,
                  child: ElevatedButton(
                    style: ElevatedButton.styleFrom(
                      padding: const EdgeInsets.symmetric(vertical: 16),
                      backgroundColor: Colors.black,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(20),
                      ),
                    ),
                    onPressed: () {
                      // Implement enrollment or purchase action here.
                    },
                    child: Text(
                      localizations?.translate('enroll_now') ?? 'Enroll Now',
                      style: const TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                        color: Colors.white,
                      ),
                    ),
                  ),
                ),
      ),
    );
  }
}
