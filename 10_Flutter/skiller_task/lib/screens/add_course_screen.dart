import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';
import '../services/firebase_service.dart';
import '../localization/app_localizations.dart';

class AddCourseScreen extends StatefulWidget {
  const AddCourseScreen({super.key});

  @override
  State<AddCourseScreen> createState() => _AddCourseScreenState();
}

class _AddCourseScreenState extends State<AddCourseScreen> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _titleController = TextEditingController();
  final TextEditingController _instructorController = TextEditingController();
  final TextEditingController _descriptionController = TextEditingController();
  final TextEditingController _durationController = TextEditingController();
  final TextEditingController _imageController = TextEditingController();
  final TextEditingController _priceController = TextEditingController();

  bool _isLoading = false;

  @override
  void dispose() {
    _titleController.dispose();
    _instructorController.dispose();
    _descriptionController.dispose();
    _durationController.dispose();
    _imageController.dispose();
    _priceController.dispose();
    super.dispose();
  }

  Future<void> _addCourse() async {
    if (!_formKey.currentState!.validate()) return;

    setState(() {
      _isLoading = true;
    });

    final newCourse = {
      'title': _titleController.text.trim(),
      'instructor': _instructorController.text.trim(),
      'description': _descriptionController.text.trim(),
      'duration': _durationController.text.trim(),
      'image': _imageController.text.trim(),
      'price': double.tryParse(_priceController.text.trim()) ?? 0.0,
    };

    try {
      await FirebaseService.addCourse(newCourse);

      if (!mounted) return;

      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(
          content: Text(
            AppLocalizations.of(context)?.translate('course_added') ??
                'Course successfully added!',
          ),
        ),
      );

      _formKey.currentState!.reset();
      _titleController.clear();
      _instructorController.clear();
      _descriptionController.clear();
      _durationController.clear();
      _imageController.clear();
      _priceController.clear();
    } on FirebaseException catch (e) {
      debugPrint("Firebase error: ${e.message}");
      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text(
              '${AppLocalizations.of(context)?.translate('firebase_error')}: ${e.message}',
            ),
          ),
        );
      }
    } catch (e) {
      debugPrint("Unexpected error: $e");
      if (mounted) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text(
              AppLocalizations.of(context)?.translate('unexpected_error') ??
                  'An unexpected error occurred',
            ),
          ),
        );
      }
    } finally {
      if (mounted) {
        setState(() {
          _isLoading = false;
        });
      }
    }
  }

  Widget _buildTextField(
    TextEditingController controller,
    String localizationKey, {
    int maxLines = 1,
    TextInputType keyboardType = TextInputType.text,
    IconData? icon,
  }) {
    final label =
        AppLocalizations.of(context)?.translate(localizationKey) ??
        localizationKey;

    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: TextFormField(
        controller: controller,
        maxLines: maxLines,
        keyboardType: keyboardType,
        style: const TextStyle(color: Colors.black87),
        decoration: InputDecoration(
          prefixIcon: icon != null ? Icon(icon, color: Colors.black) : null,
          labelText: label,
          labelStyle: TextStyle(color: Colors.grey[700]),
          border: OutlineInputBorder(borderRadius: BorderRadius.circular(12.0)),
          focusedBorder: OutlineInputBorder(
            borderRadius: BorderRadius.circular(12.0),
            borderSide: const BorderSide(color: Colors.black, width: 2),
          ),
        ),
        validator: (value) {
          if (value == null || value.trim().isEmpty) {
            return '${AppLocalizations.of(context)?.translate('please_enter')} $label';
          }
          if (localizationKey == 'price' &&
              double.tryParse(value.trim()) == null) {
            return AppLocalizations.of(
                  context,
                )?.translate('enter_valid_number') ??
                'Please enter a valid number';
          }
          return null;
        },
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);
    final addCourseLabel =
        localizations?.translate('add_course') ?? 'Add Course';

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
          padding: const EdgeInsets.all(16.0),
          child: Form(
            key: _formKey,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: [
                _buildTextField(
                  _titleController,
                  'course_title',
                  icon: Icons.title,
                ),
                _buildTextField(
                  _instructorController,
                  'instructor',
                  icon: Icons.person,
                ),
                _buildTextField(
                  _descriptionController,
                  'description',
                  maxLines: 3,
                  icon: Icons.description,
                ),
                _buildTextField(
                  _durationController,
                  'duration',
                  icon: Icons.timer,
                ),
                _buildTextField(
                  _imageController,
                  'image_url',
                  icon: Icons.image,
                ),
                _buildTextField(
                  _priceController,
                  'price',
                  keyboardType: TextInputType.number,
                  icon: Icons.attach_money,
                ),
                const SizedBox(height: 30),
                _isLoading
                    ? const Center(child: CircularProgressIndicator())
                    : ElevatedButton(
                      onPressed: _addCourse,
                      style: ElevatedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(vertical: 14),
                        backgroundColor: Colors.black,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(12),
                        ),
                      ),
                      child: Text(
                        addCourseLabel,
                        style: const TextStyle(
                          fontSize: 18,
                          color: Colors.white,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
